public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.isEmpty()) {
            return path;
        }
        StringBuilder sb = new StringBuilder();
        String[] dirs = path.split("/");
        Deque<String> sta = new ArrayDeque<String>();
        for(String dir : dirs) {
            if(!dir.equals("") && !dir.equals(".") && !dir.equals("..")) {
                sta.push(dir);
            }
            if(dir.equals("..") && !sta.isEmpty()) {
                sta.pop();
            }
        }
        while(!sta.isEmpty()) {
            sb.insert(0, "/" + sta.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
