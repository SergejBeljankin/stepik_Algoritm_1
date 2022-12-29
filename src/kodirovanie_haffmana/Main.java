package kodirovanie_haffmana;


//  https://habr.com/ru/post/144200/
//  https/www.baeldung.com/java-binary-tree
//  https://habr.com/ru/post/65617/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        /**
         *  тестовая строка
         *  abadcabadd
         *  beep boop beer!
         */
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        scanner.close();
        Map<String, Integer> map = Arrays.stream(stringInput.split(""))
                .collect(Collectors.toMap(Function.identity(), e -> 1, (e, eNew) -> (e + 1)));

        if (map.size() > 2) {
            PriorityQueue<NodeLeav> priorityQueue = new PriorityQueue<>();
            map.entrySet().stream().forEach(e -> priorityQueue.add(new NodeLeav(e.getValue(), e.getKey(), null, null)));

            while (priorityQueue.size() > 1) {
                NodeLeav nodeLeav = NodeLeav.sum(priorityQueue.poll(), priorityQueue.poll());
                priorityQueue.add(nodeLeav);
            }
            NodeLeav nodeLeavResult = priorityQueue.poll();

            nodeLeavResult.initializerMapCode();
            Map<String, String> keyCodeResulr = nodeLeavResult.mapCode(nodeLeavResult.initializerMapCode());

            StringBuilder codeString = new StringBuilder();

            Arrays.stream(stringInput.split("")).map(keyCodeResulr::get).forEach(codeString::append);
            System.out.println(keyCodeResulr.size() + " " + codeString.length());
            keyCodeResulr.entrySet().stream().map( e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);
            System.out.println(codeString);
        } else {
            Map<String, String> keyCodeResulr = new HashMap<>();
            int i = 0;
            for (Map.Entry<String, Integer> mapItem: map.entrySet()) {
                keyCodeResulr.put(mapItem.getKey(), String.valueOf(i));
                i ++;
            }
            StringBuilder codeString = new StringBuilder();

            Arrays.stream(stringInput.split("")).map(keyCodeResulr::get).forEach(codeString::append);
            System.out.println(keyCodeResulr.size() + " " + codeString.length());
            keyCodeResulr.entrySet().stream().map( e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);
            System.out.println(codeString);
        }

    }

    static class NodeLeav implements Comparable<NodeLeav> {

        private int freq;
        private String string;
        private NodeLeav left;
        private NodeLeav rigth;

        public NodeLeav(int freq, String string, NodeLeav left, NodeLeav rigth) {
            this.freq = freq;
            this.string = string;
            this.left = left;
            this.rigth = rigth;
        }

        public static NodeLeav sum(NodeLeav nodeLeav1, NodeLeav nodeLeav2) {
            return new NodeLeav(nodeLeav1.getFreq() + nodeLeav2.getFreq(),
                    nodeLeav1.getString() + nodeLeav2.getString(),
                    nodeLeav1, nodeLeav2);
        }

        public int getFreq() {
            return freq;
        }

        public String getString() {
            return string;
        }

        public NodeLeav getLeft() {
            return left;
        }

        public NodeLeav getRigth() {
            return rigth;
        }


        @Override
        public int compareTo(NodeLeav nodeLeav) {
            return Integer.compare(this.freq, nodeLeav.getFreq());
        }

        @Override
        public String toString() {
            return "NodeLeav{" +
                    "freq=" + freq +
                    ", string='" + string + '\'' +
                    ", left=" + left +
                    ", rigth=" + rigth +
                    '}';
        }


        public Map<String, String> initializerMapCode() {
            Map<String, String> keyCode = new HashMap<>();
            Arrays.stream(this.string.split("")).forEach(e -> keyCode.put(e, ""));
            return keyCode;
        }

        public Map<String, String> mapCode(Map<String, String> keyCode) {

            if (getLeft() != null) {
                Arrays.stream(getLeft().getString().split(""))
                        .forEach(e -> keyCode.put(e, keyCode.get(e) + "0"));
            }

            if (getRigth() != null) {
                Arrays.stream(getRigth().getString().split(""))
                        .forEach(e -> keyCode.put(e, keyCode.get(e) + "1"));
            }

            if (left != null) {
                left.mapCode(keyCode);
            }
            if (rigth != null) {
                rigth.mapCode(keyCode);
            }
            return keyCode;
        }
    }
}
