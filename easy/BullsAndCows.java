public class Solution1 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] sa = new int[10];
        int[] ga = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i)) {
                sa[secret.charAt(i) - '0']++;
                ga[guess.charAt(i) - '0']++;
            } else {
                bulls++;
            }
        }
        for(int i = 0; i < 10; i++){
            cows += Math.min(sa[i], ga[i]);
        }
        String res = Integer.toString(bulls).concat("A").concat(Integer.toString(cows)).concat("B");
        return res;
    }
}

public class Solution2 {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if(!map1.containsKey(secret.charAt(i)) && !map2.containsKey(secret.charAt(i))) {
                    map1.put(secret.charAt(i), 1);
                } else if(map1.containsKey(secret.charAt(i)) && !map2.containsKey(secret.charAt(i))) {
                    map1.put(secret.charAt(i), map1.get(secret.charAt(i)) + 1);
                } else if(!map1.containsKey(secret.charAt(i)) && map2.containsKey(secret.charAt(i))) {
                    cows++;
                    map2.put(secret.charAt(i), map2.get(secret.charAt(i)) - 1);
                    map1.put(secret.charAt(i), 0);
                } else {
                    if(map2.get(secret.charAt(i)) != 0) {
                        cows++;
                        map2.put(secret.charAt(i), map2.get(secret.charAt(i)) - 1);
                    } else {
                        map1.put(secret.charAt(i), map1.get(secret.charAt(i)) + 1);
                    }
                }
                if(!map2.containsKey(guess.charAt(i)) && !map1.containsKey(guess.charAt(i))) {
                    map2.put(guess.charAt(i), 1);
                } else if(map2.containsKey(guess.charAt(i)) && !map1.containsKey(guess.charAt(i))) {
                    map2.put(guess.charAt(i), map2.get(guess.charAt(i)) + 1);
                } else if(!map2.containsKey(guess.charAt(i)) && map1.containsKey(guess.charAt(i))) {
                    cows++;
                    map1.put(guess.charAt(i), map1.get(guess.charAt(i)) - 1);
                    map2.put(guess.charAt(i), 0);
                } else {
                    if(map1.get(guess.charAt(i)) != 0) {
                        cows++;
                        map1.put(guess.charAt(i), map1.get(guess.charAt(i)) - 1);
                    } else {
                        map2.put(guess.charAt(i), map2.get(guess.charAt(i)) + 1);
                    }
                }
            }
        }
        String res = Integer.toString(bulls).concat("A").concat(Integer.toString(cows)).concat("B");
        return res;
    }
}
