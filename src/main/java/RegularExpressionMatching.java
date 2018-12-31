public class RegularExpressionMatching {
    /*
    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    3, If p.charAt(j) == '*':
         here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) { return false; }
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m+1][n+1];
        match[0][0] = true;
        for (int i=0;i<n;i++) {
            if (p.charAt(i) == '*' && match[0][i-1]) {
                match[0][i+1] = true;
            }
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                char cs = s.charAt(i), cp = p.charAt(j);
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    match[i+1][j+1] = match[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') { // count as empty
                        match[i+1][j+1] = match[i+1][j-1];
                    } else {
                        match[i+1][j+1] = (match[i][j+1] || match[i+1][j] || match[i+1][j-1]);
                    }
                }
            }
        }
        return match[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println("Actual value is " + matching.isMatch(s, p) + ", expect value is false");
        s = "aab";
        p = "c*a*b";
        System.out.println("Actual value is " + matching.isMatch(s, p) + ", expect value is true");
        s = "aa";
        p = "a*";
        System.out.println("Actual value is " + matching.isMatch(s, p) + ", expect value is true");
        s = "aaa";
        p = "ab*ac*a";
        System.out.println("Actual value is " + matching.isMatch(s, p) + ", expect value is true");
        s = "a";
        p = "ab*";
        System.out.println("Actual value is " + matching.isMatch(s, p) + ", expect value is true");
    }
}
