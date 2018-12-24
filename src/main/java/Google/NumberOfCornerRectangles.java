package Google;

public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        if (grid==null || grid.length<2 || grid[0].length<2) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int count = 0;
                for (int row=0;row<m;row++) {
                    if (grid[row][i] == 1 && grid[row][j] == 1) {
                        count += 1;
                    }
                }
                if (count >= 2) {
                    res += count * (count - 1) / 2;
                }
            }
        }
        return res;
    }
}
