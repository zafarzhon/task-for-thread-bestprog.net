package net.bestprog.firstTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Odilov_Zafarjon
 * @link <a href="https://t.me/zafarzhon_odilov">...</a>
 */
public class Writer {
    public static void main(final String[] args) {
        File file = new File("src/net/bestprog/firstTask/Numbers.txt");
        try(PrintWriter printWriter = new PrintWriter(file)){
            Random random = new Random();
            for(int i = 0;i<100000000;i++){
                printWriter.println(random.nextInt());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Success");
    }
}
