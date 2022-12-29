package kodirovanie_haffmana;

import java.util.PriorityQueue;

public class ElementTest {
    public static void main(String[] args) {
        PriorityQueue<Element> elementPriorityQueue = new PriorityQueue<>();
        elementPriorityQueue.add(new Element(1, "!"));
        elementPriorityQueue.add(new Element(2, "p"));
        elementPriorityQueue.add(new Element(2, " "));
        elementPriorityQueue.add(new Element(3, "b"));
        elementPriorityQueue.add(new Element(2, "o"));
        elementPriorityQueue.add(new Element(4, "e"));
        elementPriorityQueue.add(new Element(1, "r"));
        Element element = null;
        while ((element = elementPriorityQueue.poll())!=null){
            System.out.println(element);
        }
//        System.out.println(elementPriorityQueue);
    }
}
