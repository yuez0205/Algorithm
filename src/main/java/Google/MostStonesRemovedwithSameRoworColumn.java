package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedwithSameRoworColumn {

    // DFS
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0 || stones[0].length == 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        for (int[] stone : stones) {
            row.putIfAbsent(stone[0], new HashSet<Integer>());
            col.putIfAbsent(stone[1], new HashSet<Integer>());
            row.get(stone[0]).add(stone[1]);
            col.get(stone[1]).add(stone[0]);
        }
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int[] stone : stones) {
            String key = stone[0] + "," + stone[1];
            if (!visited.contains(key)) {
                ++count;
                visited.add(key);
                dfs(stone[0], stone[1], row, col, visited);
            }
        }
        return stones.length - count;
    }

    public void dfs(int i, int j, Map<Integer, Set<Integer>> row, Map<Integer, Set<Integer>> col, Set<String> visited) {
        for (int y : row.get(i)) {
            String key = i+","+y;
            if (!visited.contains(key)) {
                visited.add(key);
                dfs(i, y, row, col, visited);
            }
        }
        for (int x : col.get(j)) {
            String key = x+","+j;
            if (!visited.contains(key)) {
                visited.add(key);
                dfs(x, j, row, col, visited);
            }
        }
    }


    // union find


}
