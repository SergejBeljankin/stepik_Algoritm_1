package fibonachi;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class FibonachiRecurs {
    static long[] fibonachi;

    public static void main(String[] args) {

        System.out.print("Введите число Фибоначи :");

        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();
        scanner.close();
        fibonachi = new long[f + 1];
        fibonachi[0] = 0L;
        fibonachi[1] = 1L;
        long time = System.currentTimeMillis();
        System.out.println(fibonachiRecurs(f));
        time = System.currentTimeMillis() - time;
        System.out.println("time : " + time + "ms");

        time = System.currentTimeMillis();
        System.out.println(fibonachiRecurs2(f));
        time = System.currentTimeMillis() - time;
        System.out.println("time : " + time + "ms");

    }

    private static int fibonachiRecurs(int f) {
        if(f == 0 || f == 1){
            return f;
        } else {
            return fibonachiRecurs(f-2) + fibonachiRecurs( f-1);
        }
    }

    private static long fibonachiRecurs2(int f) {

        if(f == 0 || f == 1){
            return f;
        } else {
            fibonachi[f] = fibonachi[f-2] + fibonachi[f-1];
        }
        return fibonachi[f];
    }
}
