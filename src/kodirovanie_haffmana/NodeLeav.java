package kodirovanie_haffmana;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * План:
 * 1. собираем буквы и частоты;
 * 2. Делаем очередь (сортированный список)
 * 3. берем две самые низкие частоты делаем ноду: freq - сумарная частота, string - сумарная строка,
 * NodeLeav rigth - первая из очереди NodeLeav, NodeLeav rigth - вторая из очереди NodeLeav.
 * Из очереди удаляем выбранные элементы. Повторяем, пока в очереди не останутся две ноды
 * 4. Делаем словарь.
 */
public class NodeLeav implements Comparable<NodeLeav> {

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
            System.out.println("--------------------");
            Arrays.stream(getLeft().getString().split("")).map(e -> "left: " + e + ": 0").forEach(System.out::println);
            Arrays.stream(getLeft().getString().split(""))
                    .forEach(e -> keyCode.put(e, keyCode.get(e) + "0"));
            Arrays.stream(getLeft().getString().split("")).map(keyCode::get).forEach(System.out::println);
            System.out.println(keyCode);
            System.out.println("--------------------");
        }

        if (getRigth() != null) {
            System.out.println("--------------------");
            Arrays.stream(getRigth().getString().split("")).map(e -> "right: " + e + ": 1").forEach(System.out::println);
            Arrays.stream(getRigth().getString().split(""))
                    .forEach(e -> keyCode.put(e, keyCode.get(e) + "1"));
            Arrays.stream(getRigth().getString().split("")).map(keyCode::get).forEach(System.out::println);
            System.out.println(keyCode);
            System.out.println("--------------------");
        }

        if (left != null) {
//            System.out.println(left);
            left.mapCode(keyCode);
        }
        if (rigth != null) {
//            System.out.println(rigth);
            rigth.mapCode(keyCode);
        }

        return keyCode;
    }
}
