package net.bestprog.firstTask;

/**
 * @author Odilov_Zafarjon
 * @link <a href="https://t.me/zafarzhon_odilov">...</a>
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 1. Задача. Параллельные целочисленные массивы в потоках
 * Условие задачи. Пользователь вводит с клавиатуры значение в массив.
 * После чего запускаются два потока. Первый поток находит максимум в массиве, второй — минимум.
 * Результаты вычислений возвращаются в метод main().
 */
public class Launcher {
    private static final String SUP = File.separator;

    public static void main(final String[] args) throws InterruptedException {
        String path = "src" + SUP + "net" + SUP + "bestprog" + SUP + "firstTask" + SUP + "Numbers.txt";
        File file = new File(path);
        int[] ints = new int[100000000];
        try (Scanner scanner = new Scanner(file)) {
            for(int i = 0;i<ints.length;i++){
                ints[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Sort sort = new Sort();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(sort.getMaxInt(ints));
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(sort.getMinInt(ints));
            }
        });
        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
    }
}

class Sort {
    public int getMaxInt(int[] array) {
        int max = Integer.MIN_VALUE;
        for (final int item : array) {
            if (max < item) {
                max = item;
            }
        }
        return max;
    }

    public int getMinInt(int[] array) {
        int min = Integer.MAX_VALUE;
        for (final int item : array) {
            if (min > item) {
                min = item;
            }
        }
        return min;
    }
}