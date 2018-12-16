import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) { return new ArrayList<List<String>>(); }
        int n = s.length();
        List<List<String>>[] res = new ArrayList[n+1];
        res[0] = new ArrayList<List<String>>();
        res[0].add(new ArrayList<String>());
        boolean[][] pair = new boolean[n][n];
        for (int i=0;i<n;i++) {
            res[i+1] = new ArrayList<List<String>>();
            for (int j=0;j<=i;j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j<=1 || pair[j+1][i-1])) {
                    pair[j][i] = true;
                    for (List<String> str : res[j]) {
                        List<String> tmp = new ArrayList<>(str);
                        tmp.add(s.substring(j, i+1));
                        res[i+1].add(tmp);
                    }
                }
            }
        }
        return res[n];
    }
}
