public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        int num1 = 0;
        int num2 = 0;
        Stack<Integer> sta = new Stack<Integer>();
        for(String s : tokens) {
            switch(s) {
                case "+": num1 = sta.pop();
                          num2 = sta.pop();
                          sta.push(num1 + num2);
                          break;
                case "-": num1 = sta.pop();
                          num2 = sta.pop();
                          sta.push(num2 - num1);
                          break;
                case "*": num1 = sta.pop();
                          num2 = sta.pop();
                          sta.push(num1 * num2);
                          break;
                case "/": num1 = sta.pop();
                          num2 = sta.pop();
                          sta.push(num2 / num1);
                          break;
                default:  sta.push(Integer.parseInt(s));
                          break;
            }
        }
        return sta.pop();
    }
}
