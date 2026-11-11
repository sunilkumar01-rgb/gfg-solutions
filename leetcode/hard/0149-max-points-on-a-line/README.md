# Max Points on a Line

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array of `points` where `points[i] = [xi, yi]` represents a point on the  **X-Y**  plane, return  *the maximum number of points that lie on the same straight line*.

 

Original
Java
 **Example 1:** 

```
Input: points = [[1,1],[2,2],[3,3]]
Output: 3

```

 **Example 2:** 

```
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

```

 

 **Constraints:** 

- 1 <= points.length <= 300
- points[i].length == 2
- -104 <= xi, yi <= 104
- All the points are unique.

## Solution

**Language:** Java  
**Runtime:** 37 ms (beats 19.65%)  
**Memory:** 45.2 MB (beats 88.77%)  
**Submitted:** 2026-11-11T16:24:03.661Z  

```java
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int max = 2;
        
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                
                String slope = dx + "/" + dy;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope) + 1);
            }
        }
        return max;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/max-points-on-a-line/)