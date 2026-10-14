# Spiral Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` `matrix`, return  *all elements of the*  `matrix`  *in spiral order*.

 

 **Example 1:** 

```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

```

 **Example 2:** 

```
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

```

 

 **Constraints:** 

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 10
- -100 <= matrix[i][j] <= 100

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.7 MB (beats 89.58%)  
**Submitted:** 2026-10-14T10:13:46.671Z  

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int row=matrix.length;
        int col=matrix[0].length;
         
         int st_row=0, st_col=0;
         int end_row=row-1, end_col=col-1;

         while(st_row<=end_row && st_col<=end_col)
         {
            for(int i=st_col;i<=end_col; i++){
                ans.add(matrix[st_row][i]);
            }
            st_row++;
            if(st_row>end_row)
            break;

            for(int i=st_row;i<=end_row;i++){
                ans.add(matrix[i][end_col]);
            }
            end_col--;
            if(st_col>end_col)
            break;

            for(int i=end_col;i>=st_col;i--){
                ans.add(matrix[end_row][i]);
            }
            end_row--;
            if(st_row>end_row)
            break;

            for(int i=end_row;i>=st_row;i--){
                ans.add(matrix[i][st_col]);
            }
            st_col++;
         }
         return ans;
        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/spiral-matrix/)