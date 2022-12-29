package kodirovanie_haffmana;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * План:
 * 1. собираем буквы и частоты;
 * 2. Делаем очередь (сортированный список)
 * 3. берем две самые низкие частоты делаем ноду: freq - сумарная частота, string - сумарная строка,
 * NodeLeav rigth - первая из очереди NodeLeav, NodeLeav rigth - вторая из очереди NodeLeav.
 * Из очереди удаляем выбранные элементы. Повторяем, пока в очереди не останутся две ноды
 * 4. Делаем словарь.
 */
public class NodeLeevTest {
    public static void main(String[] args) {
        String inputString = "beep boop beer!";
        Map<String, Integer> freqMap = new HashMap<>();
        freqMap = Arrays.stream(inputString.split("")).collect(Collectors.toMap(Function.identity(),
                e -> 1, (e, eNew) -> e + 1));
        System.out.println(freqMap);
        if (freqMap.size() <= 2) {
            // тут сразу выводим и ничего не делаем
        }
        PriorityQueue<NodeLeav> priorityQueue = new PriorityQueue<>();
        freqMap.entrySet().stream()
                .forEach(e -> priorityQueue.add(new NodeLeav(e.getValue(), e.getKey(), null, null)));
        System.out.println("Длина priorityQueue: " + priorityQueue.size());
        System.out.println(priorityQueue);

        while (priorityQueue.size() > 1) {
            NodeLeav nodeLeav = NodeLeav.sum(priorityQueue.poll(), priorityQueue.poll());
            priorityQueue.add(nodeLeav);
        }
        System.out.println("Длина priorityQueue: " + priorityQueue.size());
        System.out.println(priorityQueue);

        NodeLeav nodeLeavResult = priorityQueue.poll();
        System.out.println("----------------------------");
        System.out.println(nodeLeavResult);
        nodeLeavResult.initializerMapCode();
        Map<String, String> keyCodeResulr =
        nodeLeavResult.mapCode(nodeLeavResult.initializerMapCode());


        System.out.println("keyCodeResulr");
        System.out.println(keyCodeResulr);
    }
}
