public class Solution {
    
    private HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> res = new ArrayList<String>();
    
    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        findItineraryHelper("JFK");
        return res;
    }
    
    public void findItineraryHelper(String dept) {
        while(map.containsKey(dept) && !map.get(dept).isEmpty()) {
            findItineraryHelper(map.get(dept).poll());
        }
        res.add(0, dept);
    }
}
