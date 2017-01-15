public class Solution {
    private String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        return numberToWordsHelper(num);
    }
    
    private String numberToWordsHelper(int num) {
        String res = "";
        if(num < 20) {
            res = belowTwenty[num];
        } else if(num < 100) {
            res = belowHundred[num / 10] + " " + numberToWordsHelper(num % 10);
        } else if(num < 1000) {
            res = numberToWordsHelper(num / 100) + " Hundred " + numberToWordsHelper(num % 100);
        } else if(num < 1000000) {
            res = numberToWordsHelper(num / 1000) + " Thousand " + numberToWordsHelper(num % 1000);
        } else if(num < 1000000000) {
            res = numberToWordsHelper(num / 1000000) + " Million " + numberToWordsHelper(num % 1000000);
        } else {
            res = numberToWordsHelper(num / 1000000000) + " Billion " + numberToWordsHelper(num % 1000000000);
        }
        return res.trim();
    }
}
