import java.util.*;

public class ReconstructItinerary {
    List<String> res = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return res;
        }
        for (String[] ticket : tickets) {
            PriorityQueue<String> heap = new PriorityQueue<>();
            if (map.containsKey(ticket[0])) {
                heap = map.get(ticket[0]);
            }
            heap.offer(ticket[1]);
            map.put(ticket[0], heap);
        }
        dfs("JFK");
        return res;
    }

    public void dfs(String ticket) {
        while (map.containsKey(ticket) && !map.get(ticket).isEmpty()) {
            String next = map.get(ticket).poll();
            dfs(next);
        }
        res.add(0, ticket);
    }
}
