package org.example.seminar_2;

public class SearchUtils {
    public static Integer binarySearch(Integer[] array, Integer desiredElem) {
        if (array == null) {
            return -1;
        }
        return binarySearch(array, desiredElem, 0, array.length - 1);
    }

    public static Integer binarySearch(Integer[] array, Integer desiredElem, int min, int max) {
        if (min > max) {
            return -1;
        }

        int middle = (min + max) / 2;

        if (array[middle] == desiredElem) {
            return middle;
        }

        if (array[middle] < desiredElem) {
            return binarySearch(array, desiredElem, middle + 1, max);
        } else {
            return binarySearch(array, desiredElem, min, middle - 1);
        }
    }
}
