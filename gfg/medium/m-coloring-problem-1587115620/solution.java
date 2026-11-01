class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {

        boolean[][] graph = new boolean[v][v];

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        int[] color = new int[v];

        return solve(0, v, m, graph, color);
    }

    boolean solve(int node, int v, int m,
                  boolean[][] graph, int[] color) {

        if (node == v) {
            return true;
        }

        for (int c = 1; c <= m; c++) {

            boolean safe = true;

            for (int i = 0; i < v; i++) {
                if (graph[node][i] && color[i] == c) {
                    safe = false;
                    break;
                }
            }

            if (safe) {
                color[node] = c;

                if (solve(node + 1, v, m, graph, color)) {
                    return true;
                }

                color[node] = 0;
            }
        }

        return false;
    }
}