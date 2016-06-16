public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty()) {
            return false;
        }
        String[] nodes = preorder.split(",");
        if(nodes.length % 2 == 0) {
            return false;
        }
        if(!("#").equals(nodes[nodes.length - 1])) {
            return false;
        }
        int isNull = 0;
        int isNotNull = 0;
        for(int i = 0; i < nodes.length - 1; i++) {
            if(("#").equals(nodes[i])) {
                isNull++;
            } else {
                isNotNull++;
            }
            if(isNull > isNotNull) {
                return false;
            }
        }
        if(isNotNull != isNull) {
            return false;
        }
        return true;
    }
}
