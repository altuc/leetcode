public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        HashMap<Character, Integer> indegree = new HashMap<Character, Integer>();
        Queue<Character> q = new LinkedList<Character>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        for(int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            int len = Math.min(str1.length(), str2.length());
            for(int j = 0; j < len; j++) {
                if(str1.charAt(j) != str2.charAt(j)) {
                    if(!map.containsKey(str1.charAt(j))) {
                        map.put(str1.charAt(j), new HashSet<Character>());
                    }
                    if(map.get(str1.charAt(j)).add(str2.charAt(j))) {
                        indegree.put(str2.charAt(j), indegree.get(str2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }
        for(char c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                q.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            if(map.containsKey(c)) {
                for(char ch : map.get(c)) {
                    indegree.put(ch, indegree.get(ch) - 1);
                    if(indegree.get(ch) == 0) {
                        q.add(ch);
                    }
                }
            }
        }
        if(sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}
