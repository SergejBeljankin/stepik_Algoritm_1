package PriorityQueeHeap;

import java.util.Arrays;
import java.util.Scanner;

public class MaxHeap {
    private int[] heapMax = new int[0];

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
//        maxHeap.insert(500);
//        maxHeap.insert(200);
//        maxHeap.insert(10);
//        maxHeap.insert(100);
//        maxHeap.insert(150);
//        maxHeap.printHeapMax();
//        maxHeap.insert(10);
//        maxHeap.printHeapMax();
//        maxHeap.insert(200);
//        maxHeap.insert(11);
//        maxHeap.printHeapMax();
//        maxHeap.extractMax();
//        maxHeap.printHeapMax();
//        maxHeap.extractMax();
//        maxHeap.printHeapMax();
//        maxHeap.extractMax();
//        maxHeap.printHeapMax();
//        maxHeap.extractMax();
//        maxHeap.printHeapMax();
//        maxHeap.extractMax();
//        maxHeap.extractMax();
//        maxHeap.extractMax();
//        maxHeap.extractMax();
//        maxHeap.printHeapMax();
//        maxHeap.insert(11);

        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        for (int i = 0; i < count; i++) {
            String string = scan.next();
            if (string.equals("Insert")) {
                maxHeap.insert((scan.nextInt()));
            }
            if (string.equals("ExtractMax")) {
                maxHeap.extractMax();
            }
            if (string.length() == 0) {
                i--;
                continue;
            }
        }



//        maxHeap.printHeapMax();
    }

    private void siftUp(int i) {
        while (heapMax[i] > heapMax[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }

    }

    private void siftDown(int i) {
        while (2 * i + 1 < heapMax.length) {
            int left = 2 * i + 1;
            int rigth = 2 * i + 2;
            int j = left;
            if (rigth < heapMax.length && heapMax[rigth] > heapMax[left] ) {
                j = rigth;
            }
            if (heapMax[i] > heapMax[j]) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    public void swap(int a, int b) {
        int buff = heapMax[a];
        heapMax[a] = heapMax[b];
        heapMax[b] = buff;
    }

    private void insert(int i) {
        int[] newheap = new int[heapMax.length + 1];
        System.arraycopy(heapMax, 0, newheap, 0, heapMax.length);
        newheap[newheap.length - 1] = i;
        this.heapMax = newheap;
        siftUp(newheap.length - 1);
    }

    public void extractMax() {
        System.out.println(heapMax[0]);
        heapMax[0] = heapMax[heapMax.length - 1];
        heapMax = Arrays.copyOfRange(heapMax, 0, heapMax.length - 1);
        siftDown(0);
    }
//    public void printHeapMax() {
//        System.out.println(Arrays.toString(heapMax));
//    }
}
