public class Solution {
    private TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        int m = board.length, n = board[0].length;
        for(String word : words) {
            insertWord(word);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                searchWord(board, i, j, root, res);
            }
        }
        return res;
    }
    
    private void insertWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.word = word;
    }
    
    private void searchWord(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        if(i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return;
        }
        char c = board[i][j];
        if(c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        board[i][j] = '#';
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs) {
            searchWord(board, i + dir[0], j + dir[1], node.children[c - 'a'], res);
        }
        board[i][j] = c;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
}
