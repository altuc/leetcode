public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String encode = "";
        for(String s : strs) {
            encode = encode + s.length() + "#" + s;
        }
        return encode;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decode = new ArrayList<String>();
        int i = 0;
        int current = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '#') {
                int len = Integer.valueOf(s.substring(current, i));
                decode.add(s.substring(i + 1, i + len + 1));
                i += len + 1;
                current = i;
            } else {
                i++;
            }
        }
        return decode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
