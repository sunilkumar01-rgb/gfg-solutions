# Perfect Rectangle

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array `rectangles` where `rectangles[i] = [xi, yi, ai, bi]` represents an axis-aligned rectangle. The bottom-left point of the rectangle is `(xi, yi)` and the top-right point of it is `(ai, bi)`.

Return `true`  *if all the rectangles together form an exact cover of a rectangular region*.

 

Original
Java
 **Example 1:** 

```
Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
Output: true
Explanation: All 5 rectangles together form an exact cover of a rectangular region.

```

 **Example 2:** 

```
Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
Output: false
Explanation: Because there is a gap between the two rectangular regions.

```

 **Example 3:** 

```
Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
Output: false
Explanation: Because two of the rectangles overlap with each other.

```

 

 **Constraints:** 

- 1 <= rectangles.length <= 2 * 104
- rectangles[i].length == 4
- -105 <= xi < ai <= 105
- -105 <= yi < bi <= 105

## Solution

**Language:** Java  
**Runtime:** 51 ms (beats 6.73%)  
**Memory:** 55.4 MB (beats 77.18%)  
**Submitted:** 2026-11-10T15:59:08.602Z  

```java
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        long area = 0;
        
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            
            area += (long)(rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            String p1 = rect[0] + " " + rect[1];
            String p2 = rect[0] + " " + rect[3];
            String p3 = rect[2] + " " + rect[1];
            String p4 = rect[2] + " " + rect[3];
            
            if (!set.add(p1)) set.remove(p1);
            if (!set.add(p2)) set.remove(p2);
            if (!set.add(p3)) set.remove(p3);
            if (!set.add(p4)) set.remove(p4);
        }
        
        if (set.size() != 4 || !set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || 
            !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2)) {
            return false;
        }
        
        return area == (long)(x2 - x1) * (y2 - y1);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/perfect-rectangle/)