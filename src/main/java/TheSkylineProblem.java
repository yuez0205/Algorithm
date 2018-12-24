import java.util.*;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) { return res; }
        List<int[]> height = new ArrayList<>();
        for (int[] arr : buildings) {
            height.add(new int[]{arr[0], -arr[2]});
            height.add(new int[]{arr[1], arr[2]});
        }
        Collections.sort(height, new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[] n2) {
                if (n1[0] == n2[0]) {
                    return n1[1] - n2[1];
                }
                return n1[0] - n2[0];
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        });
        heap.offer(0);
        int pre = 0; // last highest
        for (int[] h : height) {
            if (h[1] < 0) {
                heap.offer(-h[1]);
            } else {
                heap.remove(h[1]);
            }
            int cur = heap.peek(); // cur highest
            if (pre != cur) {
                res.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}
