public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordList.add(endWord);
        int length = 1;
        while(!reached.contains(endWord)) {
            HashSet<String> next = new HashSet<String>();
            for(String s : reached) {
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    char original = ch[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == original) {
                            continue;
                        }
                        ch[i] = c;
                        String str = new String(ch);
                        if(wordList.contains(str)) {
                            next.add(str);
                            wordList.remove(str);
                        }
                    }
                    ch[i] = original;
                }
            }
            length++;
            if(next.isEmpty()) {
                return 0;
            }
            reached = next;
        }
        return length;
    }
}
