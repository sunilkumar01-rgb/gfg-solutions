# Prefix Sum Range Query

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of integers and a list of  **q**  queries  **queries[][]**, where each query is in the form [L, R], compute the sum of elements from index L to R (both inclusive) for each query.

 **Examples:** 

```
Input: arr[] = [2, 4, 6, 8, 10], queries[][] = [[1, 3], [0, 2]]
Output: [18, 12]
Explanation:
Query [1, 3] -> 4 + 6 + 8 = 18
Query [0, 2] -> 2 + 4 + 6 = 12
```

```
Input: arr[] = [5, 1, 3, 2], queries[][] = [[0, 1], [2, 3]]
Output: [6, 5]
Explanation:
Query [0, 1] -> 5 + 1 = 6
Query [2, 3] -> 3 + 2 = 5
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-06T17:24:13.988Z  

```java
class Solution {
    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];

            ans.add(prefix[right + 1] - prefix[left]);
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/prefix-sum-range-query/1)