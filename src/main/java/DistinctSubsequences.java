public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return 0;
        }
        int m = t.length(), n = s.length();
        int[][] mem = new int[m+1][n+1];
        for (int i=0;i<n;i++) {
            mem[0][i] = 1;
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
        return mem[m][n];
    }
}
