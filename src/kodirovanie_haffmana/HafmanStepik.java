package kodirovanie_haffmana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HafmanStepik {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new HafmanStepik().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + "ms");
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        String s = input.next();
        System.out.println(s);
        Map<String, Integer> characterIntegerMap = new HashMap<>();
        String[] charArr = s.split("");
        characterIntegerMap = Arrays.stream(charArr).collect(Collectors.toMap(Function.identity(), e -> 1, (oldV, newV) -> oldV + 1));
        System.out.println(characterIntegerMap);


        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        characterIntegerMap.entrySet().stream().forEach(e -> priorityQueue.add(new LeafNode(e.getKey(), e.getValue())));
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.getSum();
            priorityQueue.add(node);
        }
        System.out.println(characterIntegerMap.size() + " " + sum);
        Node root = priorityQueue.poll();
        root.buildCode("");
    }

    class Node implements Comparable<Node> {
        final int sum;
        String code;

        public Node(int sum) {
            this.sum = sum;
        }

        public void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(getSum(), o.getSum());
        }

        public int getSum() {
            return sum;
        }
    }

    class InternalNode extends Node {

        Node left;
        Node right;

        @Override
        public void buildCode(String code){
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {
        String symbol;

        LeafNode(String symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }
    }
}
