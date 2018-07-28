public class RotatedDigits {

    // dp
    public int rotatedDigits(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for(int i = 0; i <= N; i++){
            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }

    public int rotatedDigits1(int N) {
        int count = 0;
        for (int i=1;i<=N;i++) {
            if (isValid(i)) {
                ++count;
            }
        }
        return count;
    }
    public boolean isValid(int num) {
        if (num < 10) {
            if (num==2 || num==5 || num==6 || num==9) {
                return true;
            }
        } else {
            String str = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<str.length();i++) {
                char c = str.charAt(i);
                if (c=='3' || c== '4' || c== '7') { return false; }
                if (c=='0' || c=='1' || c=='8') { sb.append(c); }
                if (c=='2') { sb.append('5'); }
                if (c=='5') { sb.append('2'); }
                if (c=='6') { sb.append('9'); }
                if (c=='9') { sb.append('6'); }
            }
            if (!sb.toString().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
