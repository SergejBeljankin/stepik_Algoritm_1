package nod;

import java.util.Scanner;

public class NOD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        int nod;
        if (a >= b) {
            nod = function(a, b);
        } else {
            nod = function(b, a);
        }
        System.out.println(nod);
    }
    private static int function(int a, int b){
        while (b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
