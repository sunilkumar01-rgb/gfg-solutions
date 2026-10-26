# LFU Cache

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the `LFUCache` class:

- LFUCache(int capacity) Initializes the object with the capacity of the data structure.
- int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
- void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.

To determine the least frequently used key, a  **use counter**  is maintained for each key in the cache. The key with the smallest  **use counter**  is the least frequently used key.

When a key is first inserted into the cache, its  **use counter**  is set to `1` (due to the `put` operation). The  **use counter**  for a key in the cache is incremented either a `get` or `put` operation is called on it.

The functions `get` and `put` must each run in `O(1)` average time complexity.

 

 **Example 1:** 

```
Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3

```

 

 **Constraints:** 

- 1 <= capacity <= 104
- 0 <= key <= 105
- 0 <= value <= 109
- At most 2 * 105 calls will be made to get and put.

## Solution

**Language:** Java  
**Runtime:** 69 ms (beats 29.52%)  
**Memory:** 135.6 MB (beats 67.19%)  
**Submitted:** 2026-10-26T17:21:46.021Z  

```java
class LFUCache {
    HashMap<Integer, int[]> cache; // key -> [value, freq]
    HashMap<Integer, LinkedHashSet<Integer>> freqMap; // freq -> keys
    int capacity, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        updateFreq(key);
        return cache.get(key)[0];
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            cache.get(key)[0] = value;
            updateFreq(key);
        } else {
            if (cache.size() >= capacity) {
                int evict = freqMap.get(minFreq).iterator().next();
                freqMap.get(minFreq).remove(evict);
                cache.remove(evict);
            }
            cache.put(key, new int[]{value, 1});
            freqMap.putIfAbsent(1, new LinkedHashSet<>());
            freqMap.get(1).add(key);
            minFreq = 1;
        }
    }
    
    private void updateFreq(int key) {
        int[] info = cache.get(key);
        int f = info[1];
        info[1]++;
        
        freqMap.get(f).remove(key);
        if (freqMap.get(f).isEmpty()) {
            freqMap.remove(f);
            if (minFreq == f) minFreq++;
        }
        
        freqMap.putIfAbsent(f + 1, new LinkedHashSet<>());
        freqMap.get(f + 1).add(key);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/lfu-cache/)