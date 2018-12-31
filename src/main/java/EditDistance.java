public class EditDistance {

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) { return 0; }
        if (word1 == null) { return word2.length(); }
        if (word2 == null) { return word1.length(); }
        int m = word1.length(), n = word2.length();
        int[][] mem = new int[m+1][n+1];
        for (int i=1;i<=n;i++) {
            mem[0][i] = i;
        }
        for (int i=1;i<=m;i++) {
            mem[i][0] = i;
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j];
                } else {
                    // replace, delete, insert
                    int minCount = Math.min(mem[i][j], Math.min(mem[i+1][j], mem[i][j+1]));
                    mem[i+1][j+1] = minCount + 1;
                }
            }
        }
        return mem[m][n];
    }
}
