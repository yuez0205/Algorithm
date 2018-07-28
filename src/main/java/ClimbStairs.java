import java.util.HashMap;

public class ClimbStairs {

    // Solution 1 : Recursive with cache
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs1(int n) {
        if(n<=0) { return 0; }
        if(n<=2) { return n; }
        int a = 0;
        if (map.containsKey(n-1)) {
            a = map.get(n-1);
        } else {
            a = climbStairs1(n-1);
            map.put(n-1, a);
        }

        int b = 0;
        if (map.containsKey(n-2)) {
            b = map.get(n-2);
        } else {
            b = climbStairs1(n-2);
            map.put(n-2, b);
        }
        return a + b;
    }

    // Solution 2 : DP
    public int climbStairs2(int n) {
        if (n<=2) { return n; }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

    }
}
