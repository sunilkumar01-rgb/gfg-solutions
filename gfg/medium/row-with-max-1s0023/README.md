# Row with Max 1s in Rowwise Sorted

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a 2D binary array  **arr[][]**  consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

 **Note:** The array follows 0-based indexing.

 **Examples:** 

```
Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1]]
Output: 2
Explanation: Row 2 contains the most number of 1s (4 - 1s). Hence, the output is 2.
```

```
Input: arr[][] = [[0,0], [1,1]]
Output: 1
Explanation: Row 1 contains the most number of 1s (2 - 1s). Hence, the output is 1.
```

```
Input: arr[][] = [[0,0], [0,0]]
Output: -1
Explanation: No row contains any 1s, so the output is -1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-26T16:39:12.968Z  

```java
class Solution {
    public int rowWithMax1s(int[][] arr) {
        int maxCount = 0;
        int ansRow = -1;
        int cols = arr[0].length;

        for (int i = 0; i < arr.length; i++) {
            int currentCount = 0;
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 1) {
                    currentCount = cols - j; // Sorted hai, toh baaki sab 1 hi honge
                    break;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                ansRow = i;
            }
        }
        return ansRow;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1)