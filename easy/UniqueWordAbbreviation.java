public class ValidWordAbbr {
    
    private HashMap<String, String> map = null;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String s : dictionary) {
            String key = getKey(s);
            if(map.containsKey(key)) {
                if(!map.get(key).equals(s)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, s);
            }
        }
        
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }
    
    private String getKey(String word) {
        if(word.length() <= 2) {
            return word;
        }
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
