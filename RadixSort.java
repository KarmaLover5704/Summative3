import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    public static ArrayList<String> stages = new ArrayList<>();
    private final int[] args;
    private final int size;
    private final String startingArgs;

    public RadixSort(int listSize) {
        Random random = new Random();
        this.args = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            args[i] =  (random.nextInt(998) + 1);
        }
        this.size = args.length;
        this.startingArgs = Arrays.toString(args);
    }

    public void radixSort() {
        int maxNum = getMaxNum();

        for (int exp = 1; maxNum / exp > 0; exp *= 10) {
            countSort(exp);
            stages.add(Arrays.toString(args));
        }
    }

    // gets the biggest number in the list
    private int getMaxNum() {
        int maxNum = args[0];
        for (int i = 0; i < size; i++) {
            if (args[i] > maxNum) {
                maxNum = args[i];
            }
        }
        return maxNum;
    }

    private void countSort(int exp) {
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

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = String.format("%s%s ", str, args[i]);
        }
        return str;
    }

    public String getStage(int stageNum) {
        return stages.get(stageNum);
    }
    
   
    public String getStartingArgs() {
        return startingArgs;
    }
}