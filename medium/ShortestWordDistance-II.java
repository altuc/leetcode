public class WordDistance {
    
    private HashMap<String, List<Integer>> map = null;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        Iterator<Integer> ite1 = map.get(word1).iterator();
        Iterator<Integer> ite2 = map.get(word2).iterator();
        int pos1 = ite1.next();
        int pos2 = ite2.next();
        int res = Math.abs(pos2 - pos1);
        while(ite1.hasNext() || ite2.hasNext()) {
            if(ite1.hasNext() && ite2.hasNext()) {
                if(pos2 > pos1) {
                    pos1 = ite1.next();
                } else {
                    pos2 = ite2.next();
                }
            } else if(ite1.hasNext()) {
                pos1 = ite1.next();
            } else {
                pos2 = ite2.next();
            }
            res = Math.min(res, Math.abs(pos2 - pos1));
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
