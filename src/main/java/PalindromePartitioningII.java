public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] min = new int[n+1];
        // initial
        for (int i=0;i<=n;i++) {
            min[i] = i-1;
        }
        for (int i=0;i<n;i++) {
            for (int j=0;i-j>=0 && i+j<n && s.charAt(i-j) == s.charAt(i+j);j++) { // odd
                min[i+j+1] = Math.min(min[i+j+1], min[i-j] + 1);
            }
            for (int j=1;i-j+1>=0 && i+j<n && s.charAt(i-j+1) == s.charAt(i+j);j++) { // even
                min[i+j+1] = Math.min(min[i+j+1], min[i-j+1] + 1);
            }
        }
        return min[n];
    }
}
