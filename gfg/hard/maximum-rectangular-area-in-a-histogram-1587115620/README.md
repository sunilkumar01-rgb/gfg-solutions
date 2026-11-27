# Histogram Max Rectangular Area

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a histogram represented by an array  **arr[]**, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Find the  **largest**  rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

 **Examples:** 

```
Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed = 50 * 2 = 100.

```

```
Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed = 5 * 3 = 15.
```

```
Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-27T17:54:27.990Z  

```java
import java.util.Stack;

class Solution {
    public static int getMaxArea(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            // Last me height 0 maan kar saare remaining bars process karenge
            int h = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && h < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1)