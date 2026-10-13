# Kth Largest

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array arr[] and a number k. The task is to find the kth largest element in the array.

 **Examples:** 

```
Input: arr[] = [3, 5, 4, 2, 9], k = 3
Output: 4
Explanation: Third largest element in the array is 4.

```

```
Input: arr[] = [4, 3, 7, 6, 5], k = 5
Output: 3
Explanation: Fifth largest element in the array is 3.
```

 **Constraints:** 
1 <= k <= arr.size<= 106
-104 <= arr[i] <= 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-13T17:21:50.808Z  

```java
class Solution {
    public static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/kth-largest-element5034/1)