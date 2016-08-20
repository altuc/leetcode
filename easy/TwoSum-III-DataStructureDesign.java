public class TwoSum {

    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    // Add the number to an internal data structure.
	  public void add(int number) {
        if(map.containsKey(number)) {
            map.put(number, 2);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
	  public boolean find(int value) {
	      for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
	          int number1 = entry.getKey();
	          int number2 = value - number1;
	          if((number1 == number2 && entry.getValue() == 2) || (number1 != number2 && map.containsKey(number2))) {
	              return true;
	          }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
