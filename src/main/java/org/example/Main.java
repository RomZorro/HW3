package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Пусть дан произвольный список целых чисел.
 *
 * 1) Нужно удалить из него чётные числа
 * 2) Найти минимальное значение
 * 3) Найти максимальное значение
 * 4) Найти среднее значение
 */
public class Main {public static void main(String[] args) {
    System.out.print("Введите длину массива ---> ");
    Scanner s1 = new Scanner(System.in);
    int length = s1.nextInt();

    System.out.print("Введите минимальное значение элемента: ");
    Scanner s2 = new Scanner(System.in);
    int minValue = s2.nextInt();

    System.out.print("Введите максимальное значение элемента: ");
    Scanner s3 = new Scanner(System.in);
    int maxValue = s3.nextInt();

    System.out.println("-----".repeat(10));
    ArrayList<Integer> nums = createArray(length, minValue, maxValue);      // Создаем список с нужными параметрами
    System.out.println(nums);
    ArrayList<Integer> numsCopy = new ArrayList<>();         // Создаем копию основного списка для удаления четных чисел без изменения основного списка
    numsCopy.addAll(nums);

    System.out.println("-----".repeat(10));
    ArrayList<Integer> unevenNums = getArrayWithoutEven(numsCopy);             // Получаем список без четных чисел
    System.out.println("Cписок без четных чисел ниже");
    System.out.println(unevenNums);
    // System.out.println(nums);

    System.out.println("-----".repeat(10));
    int minNum = getMinElement(nums);
    System.out.print("Минимальный элемент = ");                             // Получаем минимальный элемент
    System.out.println(minNum);
    int maxNum = getMaxElement(nums);                                         // Получаем максимальный элемент
    System.out.print("Максимальный элемент = ");
    System.out.println(maxNum);
    float avgValue = getAvarageValue(nums);                             // Получаем среднее значение
    System.out.print("Среднее значение в списке = ");
    System.out.println(avgValue);

}
    public static ArrayList<Integer> createArray(int size, int minValue, int maxValue) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(new Random().nextInt(minValue, maxValue));
        }
        return array;

    }
    public static ArrayList<Integer> getArrayWithoutEven(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            // if (array.get(i) % 2 == 0) array.remove(i);
            array.removeIf(el -> el % 2 == 0);
        }
        return array;

    }
    public static int getMinElement(ArrayList<Integer> array) {             // Метод взвращает минимальный элемент
        int min = array.get(0);
        for (Integer integer : array) {
            if (min > integer) min = integer;
        }
        return min;

    }
    public static int getMaxElement(ArrayList<Integer> array) {             // Метод взвращает максимальный элемент
        int max = array.get(0);
        for (Integer integer : array) {
            if (max < integer) max = integer;
        }
        return max;
    }
    public static float getAvarageValue(ArrayList<Integer> array) {        // Метод возвращает среднее значение элементов в списке
        int sum = 0;
        for (Integer integer : array) {
            sum += integer;
        }
        // System.out.println(sum);
        float avg = sum / array.size();                         // Сумму всех элементов делим на длину списка для нахождения среднего значения
        return avg;
    }
}