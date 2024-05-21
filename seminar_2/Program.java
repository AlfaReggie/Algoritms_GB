package org.example.seminar_2;

public class Program {
    public static void main(String[] args) {

        Integer[] array = ArrayUtils.prepareArray(150000);
        Integer[] array_2 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 89};
//        ArrayUtils.printArray(array);
//        long startTime; long endTime;
//        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array);
//        endTime = System.currentTimeMillis();
//        ArrayUtils.printArray(array);
        Integer res = SearchUtils.binarySearch(array, 97);
        System.out.print(res);
    }
}

