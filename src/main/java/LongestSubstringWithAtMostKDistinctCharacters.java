import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int longtestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() <= k) { return s.length(); }
        Set<Character> set = new HashSet<>();
        int max = 1;
        int start = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                // update idx in queue
            } else {
                if (set.size() == k) {
                    int idx = queue.poll();
                    set.remove(s.charAt(idx));
                    start = idx + 1;
                }
                set.add(c);
                queue.offer(i);
            }
            max = Math.max(max, i - start);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aabbacae";
        System.out.println(longtestSubstring(s, 3));
    }
}
