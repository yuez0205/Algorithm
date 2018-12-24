import Utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return res;
        }
        int[] count = new int[26];
        int len = p.length();
        for (int i=0;i<len;i++) {
            ++count[p.charAt(i)-'a'];
        }
        for (int i=0;i+len-1<=s.length();i++) {
            --count[s.charAt(i) - 'a'];
            if (i >= len - 1) {
                boolean isAnagrams = true;
                for (int j = 0; j < 26; j++) {
                    if (count[j] != 0) {
                        isAnagrams = false;
                        break;
                    }
                }
                if (isAnagrams) {
                    res.add(i - len + 1);
                }
                ++count[s.charAt(i - len + 1) - 'a'];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        Printer.printList(findAnagrams(s, p));

        s = "abab"; p = "ab";
        Printer.printList(findAnagrams(s, p));
    }
}
