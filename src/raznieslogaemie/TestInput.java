package raznieslogaemie;

import java.util.Scanner;

public class TestInput {
    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.close();
        System.out.println(i);
    }
}
