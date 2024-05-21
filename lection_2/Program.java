package org.example.lection_2;

import com.sun.jdi.Value;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {
    public static void main(String[] args) {

        Integer[] newArray = new Integer[] {8, 7, 4, 2, 1, 10, 9, 3, 6, 5};
        sort(newArray);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
//        quickSort(newArray, 0, newArray.length - 1);
//        for (int i = 0; i < newArray.length; i++) {
//            System.out.print(newArray[i] + " ");
//        }


//        Integer searchPosition = find(newArray, 1);
//        System.out.println(searchPosition + 1);

//        Integer MP = binarySearch(newArray, 3, 0, newArray.length - 1);
//        System.out.println(MP);

//        AtomicInteger cnt = new AtomicInteger();
//        Integer[] newArray = new Integer[] {8, 7, 4, 2, 1, 10, 9, 3, 6, 5};
//        bubbleSort(newArray, cnt);
//        for (int i = 0; i < newArray.length; i++) {
//            System.out.print(newArray[i] + " ");
//        }
//        System.out.println("\n" + cnt.get());
//
//        AtomicInteger cnt_2 = new AtomicInteger();
//        Integer[] newArray_2 = new Integer[] {8, 7, 4, 2, 1, 10, 9, 3, 6, 5};
//        directSort(newArray_2, cnt_2);
//        for (int i = 0; i < newArray_2.length; i++) {
//            System.out.print(newArray_2[i] + " ");
//        }
//        System.out.println("\n" + cnt_2.get());
//
//        AtomicInteger cnt_3 = new AtomicInteger();
//        Integer[] newArray_3 = {8, 7, 4, 2, 1, 10, 9, 3, 6, 5};
//        insertSort(newArray_3, cnt_3);
//        for (int i = 0; i < newArray_3.length; i++) {
//            System.out.print(newArray_3[i] + " ");
//        }
//        System.out.println("\n" + cnt_3.get());
    }

//    public static void bubbleSort(Integer[] array, AtomicInteger cnt) {
//        boolean finish;
//        do {
//            finish = true;
//            for (int j = 0; j < array.length - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    Integer tmp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = tmp;
//                    finish = false;
//                }
//                cnt.incrementAndGet();
//            }
//        } while (!finish);
//    }
//
//    public static void directSort(Integer[] array, AtomicInteger cnt) {
//        for (int i = 0; i < array.length - 1; i++) {
//            int minPosition = i;
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[minPosition]) {
//                    minPosition = j;
//                }
//                cnt.incrementAndGet();
//            }
//            if (i != minPosition) {
//                int tmp = array[i];
//                array[i] = array[minPosition];
//                array[minPosition] = tmp;
//            }
//        }
//    }
//
//    public static void insertSort(Integer[] array, AtomicInteger cnt) {
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[i] > array[j]) {
//                    int tmp = array[i];
//                    array[i] = array[j];
//                    array[j] = tmp;
//                }
//                cnt.incrementAndGet();
//            }
//        }
//    }
//    public static Integer find(Integer[] array, Integer searchNum) {
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == searchNum) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public static Integer binarySearch(Integer[] array, Integer searchNum, Integer min, Integer max) {
//        Integer midPoint;
//
//        if (max < min) {
//            return -1;
//        } else {
//            midPoint = (max - min) / 2 + min;
//        }
//
//        if (array[midPoint] < searchNum) {
//            return binarySearch(array, searchNum, midPoint + 1, max);
//        } else {
//            if (array[midPoint] > searchNum) {
//                return binarySearch(array, searchNum, min, midPoint - 1);
//            } else {
//                return midPoint;
//            }
//        }
//    }
//    public static void quickSort(Integer[] array, Integer startPosit, Integer endPosit) {
//        Integer leftPosit = startPosit;
//        Integer rigthPosit = endPosit;
//        Integer pivot = array[(startPosit + endPosit) / 2]; //7, 8, 2, 3, 1*p, 4, 5, 6, 9 -> 1
//
//        do {
//            while (array[leftPosit] < pivot) {  // 7*l, 8, 2, 3, 1*p, 4, 5, 6, 9
//                leftPosit++;
//            }
//            while (array[rigthPosit] > pivot) { // 7*l, 8, 2, 3, 1*p*r, 4, 5, 6, 9
//                rigthPosit--;
//            }
//            if (leftPosit <= rigthPosit) {
//                if (leftPosit < rigthPosit) {
//                    Integer tmp = array[leftPosit];
//                    array[leftPosit] = array[rigthPosit];
//                    array[rigthPosit] = tmp;
//                }
//                leftPosit++; // 1, 8, 2, 3, 7*p*r, 4, 5, 6, 9
//                rigthPosit--; // 7, 8*l, 2, 3, 1, 4, 5, 6, 9
//            }
//        } while (leftPosit <= rigthPosit);
//
//        if (leftPosit < endPosit) {
//            quickSort(array, leftPosit, endPosit);
//        }
//        if (startPosit < rigthPosit) {
//            quickSort(array, startPosit, rigthPosit);
//        }
//    }

    public static void sort(Integer[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            Integer tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapify(array, i, 0);
        }
    }
    public static void heapify(Integer[] array, Integer heapSize, Integer rootIndex) {
        Integer largest = rootIndex;
        Integer leftChild = 2 * rootIndex + 1;
        Integer rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] >  array[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            Integer tmp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = tmp;

            heapify(array, heapSize, largest);
        }
    }
}

