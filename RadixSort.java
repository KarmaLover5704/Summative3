package ca.karmalover.radixsort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        // input for numbers
        int[] i = { 123, 4354, 28943, 29394, 3948549, 3948};
        int size = i.length;

        // sort the numbers
        radixSort(i, size);

        // print them
        System.out.println(toString(i, size));
    }

    public static void radixSort(int[] args, int size) {
        int maxNum = getMaxNum(args, size);

        for (int exp = 1; maxNum / exp > 0; exp *= 10) {
            countSort(args, size, exp);
        }
    }

    // gets the biggest number in the list
    public static int getMaxNum(int[] args, int size) {
        int maxNum = args[0];
        for (int i = 0; i < size; i++) {
            if (args[i] > maxNum) {
                maxNum = args[i];
            }
        }
        return maxNum;
    }

    public static void countSort(int[] args, int size, int exp) {
        int[] output = new int[size];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < size; i++) {
            count[(args[i] / exp) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (i = size - 1; i >= 0; i--) {
            output[count[(args[i] / exp) % 10] - 1] = args[i];
            count[(args[i] / exp) % 10]--;
        }
        for (i = 0; i < size; i++) {
            args[i] = output[i];
        }
    }

    public static String toString(int[] args, int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = String.format("%s%s ", str, args[i]);
        }
        return str;
    }
}
