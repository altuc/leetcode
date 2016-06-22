public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sta = new Stack<Integer>();
        int o1 = 0;
        int o2 = 0;
        int res = 0;
        for(String s : tokens) {
            switch(s) {
                case "+":
                    o1 = sta.pop();
                    o2 = sta.pop();
                    res = o2 + o1;
                    sta.push(res);
                    break;
                case "-":
                    o1 = sta.pop();
                    o2 = sta.pop();
                    res = o2 - o1;
                    sta.push(res);
                    break;
                case "*":
                    o1 = sta.pop();
                    o2 = sta.pop();
                    res = o2 * o1;
                    sta.push(res);
                    break;
                case "/":
                    o1 = sta.pop();
                    o2 = sta.pop();
                    res = o2 / o1;
                    sta.push(res);
                    break;
                default:
                    sta.push(Integer.parseInt(s));
                    break;
            }
        }
        return sta.pop();
    }
}
