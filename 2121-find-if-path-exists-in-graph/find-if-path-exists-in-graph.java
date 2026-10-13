
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        boolean[] visited = new boolean[n];
        java.util.List<Integer>[] graph = new java.util.ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new java.util.ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(java.util.List<Integer>[] graph, boolean[] visited,
                        int current, int destination) {
        if (current == destination) {
            return true;
        }

        visited[current] = true;

        for (int neighbor : graph[current]) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
