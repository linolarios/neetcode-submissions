class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1 ) return false;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int counter =0;
        for(int i=0; i< n ; i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            int a = e[0];
            int b = e[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            counter++;
            dfs(i, adj, visited);
        }

        return counter == 1;

    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(int next:adj.get(node)){
            if(visited[next]) continue;
            dfs(next, adj, visited);

        }
    }
}
