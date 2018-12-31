public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static int longestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0, diff = -1;
        int max = 1;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                continue;
            }
            if (diff > -1 && s.charAt(i) != s.charAt(diff)) {
                max = Math.max(max, i - start);
                start = diff + 1;
            }
            diff = i - 1;
        }
        return Math.max(max, s.length() - start);
    }

    public static void main(String[] args) {
        String s = "ababab"; //"abaaeb";
        System.out.println(longestSubstring(s));
    }
}
