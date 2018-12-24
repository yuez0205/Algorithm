package Google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = wage.length;
        double[][] workers = new double[n][2];
        for (int i=0;i<n;i++) {
            workers[i] = new double[]{(double)wage[i]/quality[i], (double)quality[i]};
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> heap = new PriorityQueue<>();
        double min = Double.MAX_VALUE;
        double sum = 0;
        for (double[] worker : workers) {
            heap.offer(-worker[1]);
            sum += worker[1];
            if (heap.size() > K) {
                sum += heap.poll();
            }
            if (heap.size() == K) {
                min = Math.min(min, worker[0] * sum);
            }
        }
        return min;
    }
}
