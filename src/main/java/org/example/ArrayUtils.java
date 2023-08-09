package org.example;

public class ArrayUtils {
    public static  int[] extractAfterLastFour(int[] arr) {
        int lastFourIndex =- 1;

        for (int i = arr.length - 1; i >=0; i--) {
            if (arr[i] == 4) {
                lastFourIndex = i;
                break;
            }
        }
        if (lastFourIndex == -1) {
            throw new RuntimeException("No fours found in the array");
        }
        int[] result = new int[arr.length - lastFourIndex - 1];
        System.arraycopy(arr,lastFourIndex + 1, result, 0, result.length);
        return result;
    }

    public static boolean containsOnlyOnesAndFours(int[] arr) {
        boolean containsOne = false;
        boolean conteinsFour = false;

        for (int num : arr) {
            if (num == 1) {
                containsOne = true;
            }else if (num == 4) {
                conteinsFour = true;
            }else {
                return false;
            }
        }
        return containsOne && conteinsFour;
    }
}
