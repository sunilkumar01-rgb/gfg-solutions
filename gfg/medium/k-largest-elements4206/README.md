# k Largest Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of positive integers and an integer  **k**, Your task is to return k largest elements in decreasing order. 

 **Examples:** 

```
Input: arr[] = [12, 5, 787, 1, 23], k = 2
Output: [787, 23]
Explanation: 1st largest element in the array is 787 and second largest is 23.

```

```
Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3 
Output: [50, 30, 23]
Explanation: Three Largest elements in the array are 50, 30 and 23.

```

```
Input: arr[] = [12, 23], k = 1
Output: [23]
Explanation: 1st Largest element in the array is 23.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-23T18:06:10.685Z  

```java
class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(minHeap);
        ans.sort(Collections.reverseOrder());
        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1)