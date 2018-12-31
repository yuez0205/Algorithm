import Utils.Printer;

public class SortColors {

    public void sortColors(int[] nums) {
        if (nums==null || nums.length<2) { return; }
        int n = nums.length;
        int start = 0, end = n-1;
        // [2,0,2,1,1,0]
        // [1,2,0]
        for (int i=0;i<=end;i++) {
            if (i<start) { continue; }
            if (nums[i] == 0) {
                int tmp = nums[start];
                nums[start++] = 0;
                nums[i--] = tmp;
            } else if (nums[i] == 2) {
                int tmp = nums[end];
                nums[end--] = 2;
                nums[i--] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] colors1 = new int[] {2,0,2,1,1,0};
        sortColors.sortColors(colors1);
        Printer.printIntArray(colors1);

        int[] colors2 = new int[] {1,2,0};
        sortColors.sortColors(colors2);
        Printer.printIntArray(colors2);

    }
}
