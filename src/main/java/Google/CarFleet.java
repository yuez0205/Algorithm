package Google;

import java.util.*;
import Utils.Printer;

public class CarFleet {

    public int carFleet(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < pos.length; ++i) {
            map.put(-pos[i], (double)(target - pos[i]) / speed[i]);
        }
        int res = 0; double cur = 0;
        for (double time : map.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        int target = 12;
        int[] positions = new int[] {10,8,0,5,3};
        int[] speed = new int[] {2,4,1,1,3};
        Printer.printWithExpectResult(carFleet.carFleet(target, positions, speed), 3);
        target = 10;
        positions = new int[] {8,3,7,4,6,5};
        speed = new int[] {4,4,4,4,4,4};
        Printer.printWithExpectResult(carFleet.carFleet(target, positions, speed), 6);
        target = 10;
        positions = new int[] {2,4};
        speed = new int[] {3,2};
        Printer.printWithExpectResult(carFleet.carFleet(target, positions, speed), 1);
        target = 20;
        positions = new int[] {6,2,17};
        speed = new int[] {3,9,2};
        Printer.printWithExpectResult(carFleet.carFleet(target, positions, speed), 2);

        target = 31;
        positions = new int[] {5,26,18,25,29,21,22,12,19,6};
        speed =      new int[] {7,6,6,  4, 3, 4, 9,7,  6,4};
        Printer.printWithExpectResult(carFleet.carFleet(target, positions, speed), 6);
    }
}
