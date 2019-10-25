package binary;


import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] whiteList = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            whiteList[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(whiteList);
        System.out.println("2333");
    }
}
