package org.example.seminar_2;
import java.util.Random;

public class ArrayUtils {
    private static Random random = new Random();

    public static Integer[] prepareArray() {
        return prepareArray(random.nextInt(0, 99));
    }

    public static Integer[] prepareArray(Integer length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 99);
        }
        return array;
    }

    public static void printArray(Integer[] array) {
        for (Integer elem : array) {
            System.out.printf("%d\t", elem);
        }
    }
}
