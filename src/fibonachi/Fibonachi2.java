package fibonachi;

import java.util.Scanner;

public class Fibonachi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.close();
        int[] fib = new int[i+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int k = 2; k <= i ; k++){
            fib[k] = (fib[k-1] + fib[k-2])%10;
        }
        System.out.println(fib[i]);
    }
}
