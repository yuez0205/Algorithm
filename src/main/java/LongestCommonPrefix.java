import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    // Time complexity : O(S) , where S is the sum of all characters in all strings.
    // In the worst case all nn strings are the same. The algorithm compares the string S1S1 with the other strings [S2..Sn]
    //​​ There are S character comparisons, where S is the sum of all characters in the input array.
    // Space complexity : O(1). We only used constant extra space.

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }
        // sort string by length form low to high
        class MyComparator implements Comparator<String> {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        }
        Arrays.sort(strs, new MyComparator());
        String prefix = strs[0];
        for (int i=1;i<strs.length;i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] strs = new String[]{"dog","racecar","car"};
        String res = prefix.longestCommonPrefix(strs);
        System.out.println(res);
    }
}
