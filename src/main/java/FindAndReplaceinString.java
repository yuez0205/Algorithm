import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceinString {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indexes.length; i++) {
            sorted.add(new int[]{indexes[i], i});
        }
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String str = sources[j], t = targets[j];
            if (s.substring(i, i + str.length()).equals(str)) {
                s = s.substring(0, i) + t + s.substring(i + str.length());
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indexes = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        FindAndReplaceinString replace = new FindAndReplaceinString();
        System.out.println(replace.findReplaceString(s, indexes, sources, targets));
    }
}
