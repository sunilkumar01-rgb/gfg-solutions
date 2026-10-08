# Majority Element

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**. Find the majority element in the array. If no majority element exists, return  **-1**.

 **Note:**  A majority element in an array is an element that appears  **strictly** more than **arr.size()/2** times in the array.

 **Examples:** 

```
Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
Output: 1
Explanation: Since, 1 is present more than 7/2 times, so it is the majority element.

```

```
Input: arr[] = [7]
Output: 7
Explanation: Since, 7 is single element and present more than 1/2 times, so it is the majority element.
```

```
Input: arr[] = [2, 13]
Output: -1
Explanation: Since, no element is present more than 2/2 times, so there is no majority element.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-08T17:27:42.226Z  

```java
class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = arr.length;
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }

        return -1;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1)