# Column with Max 0s

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a matrix  **mat[][]**  of size  **n**   **×**   **n**  consisting only of  **0** s and  **1** s. Your task is to find the index of the column that contains the  **maximum** number of 0s.

If more than one column has the same maximum number of 0s, return the index of the leftmost such column.

If no column contains any 0 (i.e., all elements in the matrix are 1), return -1.

 **Examples:** 

```
Input: mat[][] = [[0, 0, 0],
                [1, 0, 1],
                [0, 1, 1]]
Output: 0
Explanation: Columns 0 and 1 contain the same number of 0s; however, column 0 appears first, so the answer is 0.
```

```
Input: mat[][] = [[1, 1, 1],
                [1, 1, 1],
                [1, 1, 1]]
Output: -1
Explanation: Since no column contains any 0s, the answer is -1.
```

 **Constraints:** 
1 ≤ n ≤ 103
0 ≤ mat[i][j] ≤ 1

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-10T09:54:48.267Z  

```java
class Solution {
    public int maxZeros(int[][] arr) {
        int n= arr.length;
        int max_count =0, ans= -1;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(arr[j][i]==0){
                    count++;
                }
            }
            if(count>max_count){
                max_count=count;
                ans=i;
            }
        }
        return ans;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/predict-the-column/1)