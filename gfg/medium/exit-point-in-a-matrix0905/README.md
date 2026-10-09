# Exit Point in a Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a matrix mat[][] of size  **n**  ×  **m** consisting of  **0** s and  **1** s. You start at the top-left cell (0, 0). Initially, you are positioned at (0, 0) and facing right (toward (0, 1)). Before each move, apply the rules based on the value of the current cell:

- If the current cell contains 0, continue moving in the same direction.
- If the current cell contains 1, change your direction to the right (clockwise turn), and update the cell value to 0.

You continue this process until you move outside the boundaries of the matrix. Determine the coordinates (row and column index) of the cell from which you exit the matrix.

 **Examples:** 

```
Input: mat[][] = [[0, 1, 0],
               [0, 1, 1], 
               [0, 0, 0]]
Output: [1, 0]
Explanation: 

From the image we can see that, enter the matrix at (0, 0) 
-> then move towards (0, 1) ->  1 is encountered 
-> turn right towards (1, 1)  -> again 1 is encountered 
-> turn right again towards (1, 0) 
-> now, the boundary of matrix will be crossed. Hence, exit point reached at [1, 0].

```

```
Input: mat[][] = [[1, 1],
                 [0, 1]]
Output: [1, 0]
Explanation:

Enter the matrix at (0, 0) facing right
-> 1 is encountered at (0, 0)
-> turn right and move to (1, 0)
-> 0 is encountered at (1, 0)
-> continue moving down and cross the matrix boundary. Hence, the exit point is reached at [1, 0].
```

 **Constraints:** 
1 ≤ n, m ≤ 100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T18:21:45.380Z  

```java

import java.util.*;

class Solution {
    public ArrayList<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int r = 0, c = 0, dir = 0;

        while (r >= 0 && r < n && c >= 0 && c < m) {
            if (mat[r][c] == 1) {
                mat[r][c] = 0;
                dir = (dir + 1) % 4;
            }

            if (dir == 0) {
                c++;
            } else if (dir == 1) {
                r++;
            } else if (dir == 2) {
                c--;
            } else {
                r--;
            }
        }

        if (dir == 0) c--;
        else if (dir == 1) r--;
        else if (dir == 2) c++;
        else r++;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(r);
        arr.add(c);

        return arr;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1)