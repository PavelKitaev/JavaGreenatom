package work1;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class WorkingWithArrays {

    // Заполнение массива случайными числами в пределах заданных границ
    public static void filling(int[] array, int min, int max) {
        int range = max - min + 1;

        for (int i = 0; i < array.length; ++i) {
            array[i] = (int)(Math.random() * range) + min;
        }
    }

    // Сортировка пузырьком (возрастание)
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j + 1] < array[j]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }

    // Поиск минимального значения в массиве
    public static int getMinValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Поиск минимального значения в массиве
    public static double getMinValue(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Поиск максимального значения в массиве
    public static int getMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Поиск максимального значения в массиве
    public static double getMaxValue(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Вычисление среднего арифметического
    public static int getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }

        return sum / array.length;
    }

    // Вычисление среднего арифметического
    public static double getAverage(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }

        return sum / array.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Размер массива не может быть равен " + size);
            return;
        }

        System.out.print("Нижняя граница генерации чисел: ");
        int min = scanner.nextInt();

        System.out.print("Верхняя граница генерации чисел: ");
        int max = scanner.nextInt();

        int[] array = new int[size];
        try {
            filling(array, min, max);
            System.out.println("Минимальное значение массива: " + getMinValue(array));
            System.out.println("Максимальное значение массива: " + getMaxValue(array));
            System.out.println("Среднее арифметическое массива: " + getAverage(array));
            System.out.println("Массив до сортировки " + Arrays.toString(array));

            sort(array);

            System.out.println("Массив после сортировки " + Arrays.toString(array));
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
