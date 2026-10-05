# Max Sum Path in Two Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two sorted arrays of distinct integers in increasing order  **a[]** and  **b[]**, which may have some common elements, find the  **maximum sum**  of a path from the beginning of any array to the end of any array. You may switch from one array to the other only at common elements.

 **Note:**   When switching, count the  **common**  element only once.

 **Examples :** 

```
Input: a[] = [2, 3, 7, 10, 12], b[] = [1, 5, 7, 8]
Output: 35
Explanation: The path will be (1 + 5 + 7 + 10 + 12) = 35, where 1 and 5 come from arr2 and then 7 is common so we switch to arr1 and add 10 and 12.
```

```
Input: a[] = [1, 2, 3], b[] = [3, 4, 5]
Output: 15
Explanation: The path will be (1 + 2 + 3 + 4 + 5) = 15.
```

 **Constraints:** 
1 ≤ a.size(), b.size() ≤ 104
1 ≤ a[i], b[i] ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T18:10:05.872Z  

```java
class Solution {
    public int maxPathSum(int[] nums1, int[] nums2) {
        long MOD = 1_000_000_007;
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                sum1 = Math.max(sum1, sum2) + nums1[i];
                sum2 = sum1;
                i++;
                j++;
            }
        }

        while (i < nums1.length) sum1 += nums1[i++];
        while (j < nums2.length) sum2 += nums2[j++];

        return (int) (Math.max(sum1, sum2) % MOD);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1)