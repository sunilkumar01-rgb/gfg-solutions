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