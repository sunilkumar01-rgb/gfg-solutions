# Diagonal Traverse

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` matrix `mat`, return  *an array of all the elements of the array in a diagonal order*.

 

 **Example 1:** 

```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]

```

 **Example 2:** 

```
Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]

```

 

 **Constraints:** 

- m == mat.length
- n == mat[i].length
- 1 <= m, n <= 104
- 1 <= m * n <= 104
- -105 <= mat[i][j] <= 105

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 16.71%)  
**Memory:** 47.6 MB (beats 94.30%)  
**Submitted:** 2026-10-16T09:56:07.655Z  

```java
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int row= mat.length;
        int col= mat[0].length;
        int[] ans= new int[row*col];
        int level=1;
        int index=0;
        for(int c=0;c<col;c++){
            int i=0;
            int j=c;
            ArrayList<Integer>arr = new ArrayList<>();
            while(i<row && j>=0){
                arr.add(mat[i][j]);
                i++;
                j--;
            }
            if(level%2==1){
                Collections.reverse(arr);
            }
            level++;
            for(int I=0;I<arr.size();I++){
                ans[index]=arr.get(I);
                index++;
            }
        }
        for(int r=1;r<row;r++){
            int i=r;
            int j=col-1;

            ArrayList<Integer>arr = new ArrayList<>();
            while(i<row && j>=0){
                arr.add(mat[i][j]);
                i++;
                j--;
            }
            if(level%2==1){
                Collections.reverse(arr);
            }
            level++;
            for(int I=0;I<arr.size();I++){
                ans[index]=arr.get(I);
                index++;
            }
        }
        return ans;
        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/diagonal-traverse/)