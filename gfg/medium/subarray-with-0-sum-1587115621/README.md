# Zero Sum Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers,  **arr[]**. Find if there is a subarray (of size at least one) with  **0** sum. Return true/false depending upon whether there is a subarray present with 0-sum or not. 

 **Examples:** 

```
Input: arr[] = [4, 2, -3, 1, 6]
Output: true
Explanation: 2, -3, 1 is the subarray with a sum of 0.
```

```
Input: arr = [4, 2, 0, 1, 6]
Output: true
Explanation: 0 is one of the elements in the array so there exist a subarray with sum 0.
```

```
Input: arr = [1, 2, -1]
Output: false
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-24T17:19:54.124Z  

```java
import java.util.*;

class Solution {
    public boolean subArrayExists(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1)