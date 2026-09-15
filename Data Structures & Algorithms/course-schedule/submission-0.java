class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int[] pre: prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i=0;i<numCourses; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        int taken =0;

        while(!queue.isEmpty()){
            int current = queue.poll();
            taken++;
            for(int next: graph.get(current)){
                if(--inDegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        return taken == numCourses;
    }
}
