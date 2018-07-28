import org.junit.Assert;

public class GuessGame {
    public int target;

    public int guess(int num) {
        if (num > target) {
            return 1;
        } else if (num < target) {
            return -1;
        }
        return 0;
    }

    public int guessNumber(int n) {
        return helper(1, n);
    }

    public int helper(int start, int end) {
        System.out.println(start + " " + end);
        if (start <= end) {
            int mid = (end-start)/2 + start;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                return helper(start, mid-1);
            } else if (res == -1){
                return helper(mid + 1, end);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GuessGame gg = new GuessGame();
        gg.target = 6;
        int res = gg.guessNumber(10);
        System.out.println(res);
        Assert.assertTrue(gg.target == res);
    }
}
