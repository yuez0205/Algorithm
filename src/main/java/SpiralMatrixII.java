public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n<1) { return new int[0][0]; }
        int[][] res = new int[n][n];
        int num = 1;
        int left=0, right=n-1, top=0, bottom=n-1;
        while (left<=right) {
            for (int i=left;i<=right;i++) {
                res[top][i] = num++;
            }
            if (++top>bottom) { break; }
            for (int i=top;i<=bottom;i++) {
                res[i][right] = num++;
            }
            if (left>--right) { break;}
            for (int i=right;i>=left;--i) {
                res[bottom][i] = num++;
            }
            if (top>--bottom) { break; }
            for (int i=bottom;i>=top;--i) {
                res[i][left] = num++;
            }
            ++left;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        Printer.print2DIntArray(spiralMatrixII.generateMatrix(3));
    }
}
