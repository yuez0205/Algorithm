import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n <= 0) { return false; }
        if (n==1) { return true; }
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int sum = 0;
            String str = String.valueOf(n);
            for (char c : str.toCharArray()) {
                int val = Character.getNumericValue(c);
                sum += val * val;
            }
            if (sum==1) { return true; }
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        HappyNumber hm = new HappyNumber();
        System.out.println(hm.isHappy(19));
    }
}
