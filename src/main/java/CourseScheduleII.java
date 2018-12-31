import Utils.Printer;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int n, int[][] prerequisites) {
        if (n == 0) { return new int[0]; }
        int[] degree = new int[n];
        int[][] matrix = new int[n][n];
        for (int[] arr : prerequisites) {
            int pre = arr[1], cur = arr[0];
            if (matrix[pre][cur] == 0) {
                matrix[pre][cur] = 1;
                ++degree[cur];
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[n];
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[idx++] = cur;
            for (int i=0;i<n;i++) {
                if (matrix[cur][i] > 0) {
                    --degree[i];
                    if (degree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return idx == n ? res : new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequest = {{1,0}, {2,0}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        Printer.printIntArray(courseScheduleII.findOrder(3, prerequest));
    }
}
