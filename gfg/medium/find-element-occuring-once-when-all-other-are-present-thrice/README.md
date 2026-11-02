# Single in Array of Triples

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers  **arr[]**  where, every element appears thrice except for one which occurs once.
Find that element which occurs once.

 **Examples:** 

```
Input: arr[] = [1, 10, 1, 1]
Output: 10
Explanation: 10 occurs once in the array while the other element 1 occurs thrice.

```

```
Input: arr[] = [3, 2, 1, 34, 34, 1, 2, 34, 2, 1]
Output: 3
Explanation: All elements except 3 occurs thrice in the array.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-02T13:06:51.425Z  

```java
class Solution {
    public int getSingle(int[] arr) {
        int ones = 0, twos = 0;

        for (int num : arr) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1)