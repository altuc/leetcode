public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.isEmpty()) {
            return path;
        }
        Stack<String> sta = new Stack<String>();
        for(String dir : path.split("/")) {
            if(!dir.equals("..") && !dir.equals(".") && !dir.equals("")) {
                sta.push(dir);
            }
            if(!sta.empty() && dir.equals("..")) {
                sta.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!sta.empty()) {
            sb.insert(0, "/" + sta.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
