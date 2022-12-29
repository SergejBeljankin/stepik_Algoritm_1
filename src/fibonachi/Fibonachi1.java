package fibonachi;


import java.util.Scanner;

public class Fibonachi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число:");
        int f = scanner.nextInt();
        scanner.close();
        long time = System.currentTimeMillis();
        System.out.println(fibonachiArr(f));
        time = System.currentTimeMillis() - time;
        System.out.println("time :" + time + "ms");
        time = System.currentTimeMillis();
        System.out.println(fibonachiCount(f));
        time = System.currentTimeMillis() - time;
        System.out.println("time :" + time + "ms");


    }

    private static long fibonachiCount(int f) {
        if(f == 0 || f == 1){
            return (long) f;
        }
        long fibonachiMinusOne = 1L;
        long fibonachiMinusTwo = 0L;
        long fibonachi = 0;
        for (int i = 2; i <= f ; i++){
            fibonachi = fibonachiMinusOne + fibonachiMinusTwo;
            fibonachiMinusTwo = fibonachiMinusOne;
            fibonachiMinusOne = fibonachi;
        }
        return fibonachi;
    }

    private static long fibonachiArr(int f) {
        long[] fibonachi = new long[f + 1];
        if (f >= 3 && f <= 500000) {
            fibonachi[0] = 0;
            fibonachi[1] = 1;
            fibonachi[2] = 1;
            for (int i = 3; i <= f; i++) {
                fibonachi[i] = fibonachi[i - 1] + fibonachi[i - 2];
            }
        }
        return fibonachi[f];
    }

}


