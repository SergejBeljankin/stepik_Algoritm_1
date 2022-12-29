package cover_segments_with_dots;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(scanner.nextInt());
            integerList.add(scanner.nextInt());
            listList.add(integerList);
        }
        listList.sort((e1, e2) -> e1.get(1) - e2.get(1));

        List<Integer> common = new ArrayList<>();
        boolean param = true;
        for (List<Integer> integerList : listList) {
            if (param) {
                common.add(integerList.get(1));
                param = false;
            }
            if (!param) {
                if (integerList.get(0) > common.get(common.size() - 1)) {
                    common.add(integerList.get(1));
                }
            }
        }
        System.out.println(common.size());
        common.stream().map( e -> e + " ").forEach(System.out::print);
    }
}
