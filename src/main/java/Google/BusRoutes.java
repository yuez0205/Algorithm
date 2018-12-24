package Google;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0 || routes[0].length == 0) {
            return -1;
        }
        if (S == T) { return 0; }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(S);
        for (int i=0;i<routes.length;i++) {
            for (int j=0;j<routes[i].length;j++) {
                map.putIfAbsent(routes[i][j], new ArrayList<Integer>());
                List<Integer> buses = map.get(routes[i][j]);
                buses.add(i);
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++res;
            for (int i=0;i<size;i++) {
                int stop = queue.poll();
                for (int bus : map.get(stop)) {
                    if (visited.contains(bus)) {
                        continue;
                    }
                    visited.add(bus);
                    for (int otherStop : routes[bus]) {
                        if (otherStop == T) {
                            return res;
                        }
                        queue.offer(otherStop);
                    }
                }
            }
        }
        return -1;
    }
}
