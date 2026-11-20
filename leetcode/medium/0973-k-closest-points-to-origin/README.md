# K Closest Points to Origin

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of `points` where `points[i] = [xi, yi]` represents a point on the  **X-Y**  plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.

The distance between two points on the  **X-Y**  plane is the Euclidean distance (i.e., `√(x1 - x2)2 + (y1 - y2)2`).

You may return the answer in  **any order**. The answer is  **guaranteed**  to be  **unique**  (except for the order that it is in).

 

Original
Java
 **Example 1:** 

```
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

```

 **Example 2:** 

```
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

```

 

 **Constraints:** 

- 1 <= k <= points.length <= 104
- -104 <= xi, yi <= 104

## Solution

**Language:** Java  
**Runtime:** 30 ms (beats 66.62%)  
**Memory:** 53.5 MB (beats 76.33%)  
**Submitted:** 2026-11-20T17:30:24.900Z  

```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap based on distance (x^2 + y^2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/k-closest-points-to-origin/)