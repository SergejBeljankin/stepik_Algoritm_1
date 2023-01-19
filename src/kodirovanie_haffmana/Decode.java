package kodirovanie_haffmana;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */

public class Decode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMap = scanner.nextInt();
        int lengthString = scanner.nextInt();
        Map<String, String> codeMap = new HashMap<>();
        String stringInput;

        for (int k = 0; k <= sizeMap - 1; k++) {
            if ((stringInput = scanner.nextLine()) != null && !stringInput.equals("")) {
                codeMap.put(stringInput.split(": ")[0], stringInput.split(": ")[1]);

            } else {
                k--;
            }
        }

        String stringCode = scanner.nextLine();
        scanner.close();
        /*
        System.out.println(sizeMap + " " + lengthString);
        System.out.println("-------------------");
        System.out.println(codeMap);
        System.out.println("-------------------");
        System.out.println(stringCode);
         */
        Queue<String> stringQueue = new LinkedList<>();
        Arrays.stream(stringCode.split("")).forEach(stringQueue::add);


//        System.out.println(stringQueue);
        StringBuilder stringBuilderItem = new StringBuilder();
        StringBuilder stringBuilderString = new StringBuilder();

        while (!stringQueue.isEmpty()) {
            stringBuilderItem.append(stringQueue.poll());
            for (Map.Entry<String, String> codeMapItem : codeMap.entrySet()) {
                if (stringBuilderItem.toString().equals(codeMapItem.getValue())) {
                    stringBuilderString.append(codeMapItem.getKey());
                    stringBuilderItem.setLength(0);
                }
            }

        }
        System.out.println(stringBuilderString);


    }
}
