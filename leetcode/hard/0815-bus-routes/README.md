# Bus Routes

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an array `routes` representing bus routes where `routes[i]` is a bus route that the `ith` bus repeats forever.

- For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 ->... forever.

You will start at the bus stop `source` (You are not on any bus initially), and you want to go to the bus stop `target`. You can travel between bus stops by buses only.

Return  *the least number of buses you must take to travel from* `source` *to* `target`. Return `-1` if it is not possible.

 

Original
Java
 **Example 1:** 

```
Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

```

 **Example 2:** 

```
Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1

```

 

 

 **Constraints:** 

- 1 <= routes.length <= 500.
- 1 <= routes[i].length <= 105
- All the values of routes[i] are unique.
- sum(routes[i].length) <= 105
- 0 <= routes[i][j] < 106
- 0 <= source, target < 106

## Solution

**Language:** Java  
**Runtime:** 54 ms (beats 61.42%)  
**Memory:** 106.1 MB (beats 27.88%)  
**Submitted:** 2026-11-27T18:06:44.465Z  

```java
import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        HashMap<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(i);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visitedStops = new HashSet<>();
        HashSet<Integer> visitedRoutes = new HashSet<>();
        
        q.add(source);
        visitedStops.add(source);
        int buses = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            buses++;
            
            for (int i = 0; i < size; i++) {
                int currStop = q.poll();
                
                if (!stopToRoutes.containsKey(currStop)) continue;
                
                for (int route : stopToRoutes.get(currStop)) {
                    if (visitedRoutes.contains(route)) continue;
                    visitedRoutes.add(route);
                    
                    for (int stop : routes[route]) {
                        if (stop == target) return buses;
                        if (visitedStops.contains(stop)) continue;
                        
                        visitedStops.add(stop);
                        q.add(stop);
                    }
                }
            }
        }
        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/bus-routes/)