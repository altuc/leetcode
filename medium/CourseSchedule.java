public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int prerequisite = q.poll();
            numCourses--;
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == prerequisite) {
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0) {
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}
