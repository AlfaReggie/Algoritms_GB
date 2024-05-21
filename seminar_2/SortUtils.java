package org.example.seminar_2;

public class SortUtils {
    public static void directSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                Integer buf = array[i];
                array[i] = array[minIdx];
                array[minIdx] = buf;
            }
        }
    }

    public static void quickSort(Integer[] array) {
        if (array == null) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(Integer[] array, Integer startIdx, Integer endIdx) {
        Integer left = startIdx;
        Integer right = endIdx;
        Integer middle = array[(startIdx + endIdx) / 2];

        do {
            while (array[left] < middle) {
                left++;
            }

            while (array[right] > middle) {
                right--;
            }

            if (left <= right) {
                if (left < right) {
                    Integer tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < endIdx) {
            quickSort(array, left, endIdx);
        }
        if (startIdx < right) {
            quickSort(array, startIdx, right);
        }
    }


}
