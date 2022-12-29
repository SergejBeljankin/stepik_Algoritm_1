package raznieslogaemie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        scanner.close();
//        System.out.println(test);
        List<Integer> integerList = new ArrayList<>();
        int sum = 0;
        while (sum < test) {
            if (sum + 1 + integerList.size() <= test) {
//                System.out.println("sum = " + sum + "; size" + integerList.size());
                integerList.add(1 + integerList.size());
                sum = 1 + integerList.size() -1 + sum;
//                System.out.println(sum);
//                System.out.println(integerList);
                if (sum + 1 + integerList.size() > test){
                    sum = sum - integerList.remove(integerList.size() - 1);
                    integerList.add(test - sum);
                    break;
                }
            }

        }
        System.out.println(integerList.size());
//        System.out.println(integerList.stream().reduce(0, Integer::sum));
        integerList.stream().map( e -> e + " ").forEach(System.out::print);
    }

}
