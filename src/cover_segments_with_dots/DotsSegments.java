package cover_segments_with_dots;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Если не получается разобраться с условием задачи, то попробуйте представить эту задачу так:
 *
 * есть несколько дощечек разной длины (это наши отрезки n). Нужно прибить их к полу так, чтобы
 * если комната перевернулась они не попадали. Вот минимальное количество гвоздей в этой задаче и
 * точки куда они прибиты и будет решением.
 *
 */

public class DotsSegments {
    private DotsSegments() {
    }

    private List<List<Integer>> input() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(scanner.nextInt());
            integerList.add(scanner.nextInt());
            listList.add(integerList);
        }
        return listList;
        }
    public List<List<Integer>> sortListList(List<List<Integer>> listList) {
        listList.sort((e1, e2) -> e1.get(1) - e2.get(1));
        return listList;
    }

    public void pontsCommon(List<List<Integer>> listList) {
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
    public static void main(String[] args) {
        DotsSegments dotsSegments = new DotsSegments();
        List<List<Integer>> listListInteger = dotsSegments.input();
        dotsSegments.pontsCommon(dotsSegments.sortListList(listListInteger));




//        List<List<Integer>> listList1 = new ArrayList<>();
//        List<Integer> integerList1 = List.of(4, 7);
//        List<Integer> integerList2 = List.of(1, 3);
//        List<Integer> integerList3 = List.of(2, 5);
//        List<Integer> integerList4 = List.of(5, 6);
////        List<Integer> integerList5 = List.of(6, 8);
//        listList1.add(integerList1);
//        listList1.add(integerList2);
//        listList1.add(integerList3);
//        listList1.add(integerList4);
////        listList1.add(integerList5);
//        listList1.sort((e1, e2) -> e1.get(1) - e2.get(1));
//        System.out.println(listList1);
//
//
//        /**
//         * 4 отрезка 3 гвоздя
//         */
//        List<List<Integer>> listList4Seg3Dot = new ArrayList<>();
//        List<Integer> integerList4Seg3Dot1 = List.of(0, 2);
//        List<Integer> integerList4Seg3Dot2 = List.of(2, 4);
//        List<Integer> integerList4Seg3Dot3 = List.of(4, 6);
//        List<Integer> integerList4Seg3Dot4 = List.of(6, 8);
//        listList4Seg3Dot.add(integerList4Seg3Dot3);
//        listList4Seg3Dot.add(integerList4Seg3Dot2);
//        listList4Seg3Dot.add(integerList4Seg3Dot4);
//        listList4Seg3Dot.add(integerList4Seg3Dot1);
//        listList4Seg3Dot.sort((e1, e2) -> e1.get(1) - e2.get(1));
//        System.out.println(listList4Seg3Dot);
//
//
//        /**
//         * Test1
//         * 5
//         * 5 6
//         * 4 7
//         * 3 8
//         * 2 9
//         * 1 10
//         *
//         * ------
//         * 1
//         * 6
//         */
//        List<List<Integer>> listListTest1 = new ArrayList<>();
//        List<Integer> listListTest1Seg1 = List.of(5, 6);
//        List<Integer> listListTest1Seg2 = List.of(4, 7);
//        List<Integer> listListTest1Seg3 = List.of(3, 8);
//        List<Integer> listListTest1Seg4 = List.of(2, 9);
//        List<Integer> listListTest1Seg5 = List.of(1, 10);
//        listListTest1.add(listListTest1Seg1);
//        listListTest1.add(listListTest1Seg2);
//        listListTest1.add(listListTest1Seg3);
//        listListTest1.add(listListTest1Seg4);
//        listListTest1.add(listListTest1Seg5);
////        listListTest1.sort((e1, e2) -> e1.get(1) - e2.get(1));
//        System.out.println(listListTest1);
//
//        System.out.println("1 - 6");
//        CommonPonts commonPonts16 = new CommonPonts(listListTest1);
//        List<Integer> integerList = commonPonts16.pontsCommon();
//        System.out.println(integerList.size());
//        System.out.println(integerList);
//
//        /**
//         * Test2
//         * 5
//         * 1 2
//         * 2 3
//         * 3 4
//         * 4 5
//         * 5 6
//         *
//         * _______
//         * 3
//         * 2 4 6
//         */
//        List<List<Integer>> listListTest2 = new ArrayList<>();
//        List<Integer> listListTest2Seg1 = List.of(1, 2);
//        List<Integer> listListTest2Seg2 = List.of(2, 3);
//        List<Integer> listListTest2Seg3 = List.of(3, 4);
//        List<Integer> listListTest2Seg4 = List.of(4, 5);
//        List<Integer> listListTest2Seg5 = List.of(5, 6);
//        listListTest2.add(listListTest2Seg1);
//        listListTest2.add(listListTest2Seg2);
//        listListTest2.add(listListTest2Seg3);
//        listListTest2.add(listListTest2Seg4);
//        listListTest2.add(listListTest2Seg5);
//
//        System.out.println("2 4 6");
//        CommonPonts commonPonts2 = new CommonPonts(listListTest2);
//        List<Integer> integerList2PC = commonPonts2.pontsCommon();
//        System.out.println(integerList2PC.size());
//        System.out.println(integerList2PC);
//
//    }
//
//    private List<List<Integer>> input() {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        List<List<Integer>> listList = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            List<Integer> integerList = new ArrayList<>();
//            integerList.add(scanner.nextInt());
//            integerList.add(scanner.nextInt());
//            listList.add(integerList);
//        }
//        System.out.println(count);
//        System.out.println(listList);
//        return listList;
//    }
//
//    public static class CommonPonts {
//        private List<List<Integer>> listList;
//
//        public CommonPonts() {
//        }
//
//        public CommonPonts(List<List<Integer>> listList) {
//            this.listList = listList;
//        }
//
//        public List<List<Integer>> getListList() {
//            return listList;
//        }
//
//        public void setListList(List<List<Integer>> listList) {
//            this.listList = listList;
//        }
//
//        public void sortListList() {
//            this.listList.sort((e1, e2) -> e1.get(1) - e2.get(1));
//        }
//
//        public List<Integer> pontsCommon() {
//            List<Integer> common = new ArrayList<>();
//            boolean param = true;
//            for (List<Integer> integerList : listList) {
//                if (param) {
//                    common.add(integerList.get(1));
//                    param = false;
//                }
//                if (!param) {
//                    if (integerList.get(0) > common.get(common.size() - 1)) {
//                        common.add(integerList.get(1));
//                    }
//                }
//
//            }
//            return common;
//        }
    }
}


