class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacency = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int counter =0;
        for(int i =0; i<n; i++) adjacency.add(new ArrayList<>());
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adjacency.get(a).add(b);
            adjacency.get(b).add(a);
        }
        for(int i =0; i<n; i++){
            if(!visited[i]){
                counter++;
                dfs(i, adjacency, visited);

            }
        }
    return counter;
    }

    private void dfs(int node, List<List<Integer>> adjacency, boolean[] visited){
        visited[node] = true;
        for(int next: adjacency.get(node)){
            if(visited[next]) continue;
             dfs(next, adjacency, visited);
        }
    }
}
