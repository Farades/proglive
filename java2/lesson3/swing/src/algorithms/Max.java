package algorithms;

import java.util.Random;

/**
 * Created by Артем on 07.01.2015.
 */
public class Max {

    public static void main(String[] args) {
        int array[] = createArray();
        printArray(array);
        System.out.println();
        System.out.println(max(array));
    }

    public static int[] createArray() {
        int[] res = new int[20];
        Random rand = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = rand.nextInt(101);
        }
        return res;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int max(int[] array) {
        int res = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > res)
                res = array[i];
        }

        return res;
    }
}
