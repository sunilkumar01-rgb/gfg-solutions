# Remove Duplicates Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a sorted array  **arr[]** containing positive integers. Your task is to remove all duplicate elements from this array such that each element appears only once. Return an array containing these distinct elements in the same order as they appeared.

 **Examples :** 

```
Input: arr[] = [2, 2, 2, 2, 2]
Output: [2]
Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position and you should return array containing [2] after modifying the array.

```

```
Input: arr[] = [1, 2, 4]
Output: [1, 2, 4]
Explanation:  As the array does not contain any duplicates so you should return [1, 2, 4].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-12T17:39:02.205Z  

```java
class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr.length == 0) return ans;

        ans.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                ans.add(arr[i]);
            }
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1)