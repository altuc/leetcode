public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int index = 0;
        while(!q.isEmpty()) {
            int prerequisite = q.poll();
            res[index] = prerequisite;
            index++;
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
        return numCourses == 0 ? res : new int[0];
    }
}
