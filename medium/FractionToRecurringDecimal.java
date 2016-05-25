public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        if(denominator == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            res.append("-");
        }
        long nume = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        res.append(nume / deno);
        nume %= deno;
        if(nume == 0) {
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(nume, res.length());
        while(nume != 0) {
            nume *= 10;
            res.append(nume / deno);
            nume %= deno;
            if(map.containsKey(nume)) {
                int position = map.get(nume);
                res.insert(position, "(");
                res.append(")");
                break;
            } else {
                map.put(nume, res.length());
            }
        }
        return res.toString();
    }
}
