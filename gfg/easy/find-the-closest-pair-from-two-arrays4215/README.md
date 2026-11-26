# Closest Sum Pair Across Two Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two  **sorted**  arrays arr1[] and arr2[] of size n and m and a number x, find the pair whose sum is closest to x and the pair has an element from each array. In the case of multiple closest pairs return any one of them.

 **Note**  : In the driver code, the absolute difference between the sum of the closest pair and x is printed.

 **Examples:** 

```
Input : arr1[] = [1, 4, 5, 7], arr2[] = [10, 20, 30, 40], x = 32
Output : [1, 30]
Explanation:The closest pair whose sum is closest to 32 is [1, 30] = 31.

```

```
Input : arr1[] = [1, 4, 5, 7], arr2[] = [10, 20, 30, 40], x = 50 
Output : [7, 40] 
Explanation: The closest pair whose sum is closest to 50 is [7, 40] = 47.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-26T16:41:06.444Z  

```java
import java.util.*;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int m = arr1.length;
        int n = arr2.length;

        int diff = Integer.MAX_VALUE;
        int res_l = 0, res_r = 0;

        int l = 0, r = n - 1;

        while (l < m && r >= 0) {
            int sum = arr1[l] + arr2[r];

            if (Math.abs(sum - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(sum - x);
            }

            if (sum > x) {
                r--;
            } else {
                l++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr1[res_l]);
        ans.add(arr2[res_r]);

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1)