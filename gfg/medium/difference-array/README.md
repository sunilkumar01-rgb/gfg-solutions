# Difference Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array  **arr[]**  and a  2D array  **opr[][]**, where each opr[i] denotes an operation in the format  **[l, r, v].** 

- For each operation [l, r, v], you need to add the value v to all elements of the array from index l to r (both inclusive).
- Apply all operations sequentially in the given order, and return the final updated array.

 **Examples:** 

```
Input: arr[] = [2, 3, 5, 6, 7], opr[][] = [[2, 4, 2], [3, 4, -1]]
Output: [2, 3, 7, 7, 8]
Explanation:
Operation [2, 4, 2] : Add 2 to indices 2 to 4 → [2, 3, 7, 8, 9] 
Operation [3, 4, -1] : Subtract 1 from indices 3 to 4 → [2, 3, 7, 7, 8] 
Final array is [2, 3, 7, 7, 8].
```

```
Input: arr[] = [4, 5, 7, 9], opr[][] = [[1, 3, 1], [2, 3, -2]]
Output: [4, 6, 6, 8]
Explanation:
Operation [1, 3, 1] : Add 1 to indices 1 to 3 → [4, 6, 8, 10] 
Operation [2, 3, -2] : Subtract 2 from indices 2 to 3 → [4, 6, 6, 8] 
Final array is [4, 6, 6, 8].
```

**Constraints:
**1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 103
1 ≤ opr.size() ≤ 105
0 ≤ l ≤ r < arr.size()
-103 ≤ v ≤ 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-16T16:07:01.548Z  

```java
class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {

        int n = arr.length;
        int[] diff = new int[n + 1];

        for (int[] q : opr) {
            int l = q[0];
            int r = q[1];
            int v = q[2];

            diff[l] += v;
            diff[r + 1] -= v;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += diff[i];
            ans.add(arr[i] + sum);
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/difference-array/1)