import java.util.List;

public class Printer {

    public static void printIntArray(int[] nums) {
        if (nums == null) { return; }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printList(List list) {
        if (list == null) { return; }
        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
