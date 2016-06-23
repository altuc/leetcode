public class WordDictionary {
    
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }
    
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if(cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int start, TrieNode node) {
        if(start == word.length()) {
            return node.isLeaf;
        }
        if(word.charAt(start) == '.') {
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null) {
                    if(search(word, start + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(node.children[word.charAt(start) - 'a'] == null) {
                return false;
            }
            return search(word, start + 1, node.children[word.charAt(start) - 'a']);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
