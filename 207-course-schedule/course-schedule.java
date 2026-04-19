class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<numCourses; i++){
            if(degree[i] == 0) q.add(i);
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;

            for(int next : adj.get(node)){
                degree[next]--;
                if(degree[next] == 0) q.add(next);
            }
        }
        return cnt == numCourses;
    }
}