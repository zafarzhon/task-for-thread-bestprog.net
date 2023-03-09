package net.bestprog.firstTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Odilov_Zafarjon
 * @link <a href="https://t.me/zafarzhon_odilov">...</a>
 */
public class LauncherTest {
    private static final String SUP = File.separator;

    public static void main(final String[] args) {

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
        long start = System.currentTimeMillis();
        int max = sort.getMaxInt(ints);
        int min = sort.getMinInt(ints);
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
        System.out.println(max +" "+min);
    }
}

