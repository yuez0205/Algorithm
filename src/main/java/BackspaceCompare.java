public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (true) {
            int count = 0;
            while (i>=0 && (count > 0 || s.charAt(i) == '#')) {
                count += (s.charAt(i) == '#' ? 1 : -1);
                --i;
            }
            count = 0;
            while (j>=0 && (count > 0 || t.charAt(j) == '#')) {
                count += (t.charAt(j) == '#' ? 1 : -1);
                --j;
            }
            if (i < 0 || j < 0 || s.charAt(i) != t.charAt(j)) {
                return i == -1 && j == -1;
            }
            --i; --j;
        }
    }

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        System.out.println(backspaceCompare.backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare.backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare.backspaceCompare("a#c", "bc"));
    }
}
