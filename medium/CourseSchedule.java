// BFS
public class Solution1 {
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

// DFS
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(!canFinishHelper(prerequisites, visited, visiting, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean canFinishHelper(int[][] prerequisites, boolean[] visited, boolean[] visiting, int i) {
        if(visiting[i]) {
            return false;
        }
        boolean res = true;
        if(!visited[i]) {
            visiting[i] = true;
            for(int j = 0; j < prerequisites.length; j++) {
                if(prerequisites[j][1] == i) {
                    res = res & canFinishHelper(prerequisites, visited, visiting, prerequisites[j][0]);
                    if(res == false) {
                        return false;
                    }
                }
            }
            visited[i] = true;
            visiting[i] = false;
        }
        return res;
    }
}
