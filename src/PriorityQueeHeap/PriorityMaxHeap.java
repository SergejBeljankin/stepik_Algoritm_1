package PriorityQueeHeap;

import java.util.Arrays;
import java.util.Scanner;

public class PriorityMaxHeap {
    private int[] arrayHeap = new int[0];

    public static void main(String[] args) {
//        PriorityMaxHeap priorityMaxHeap = new PriorityMaxHeap();
//
//
//        priorityMaxHeap.insert(3);
////        priorityMaxHeap.getArrayHeap();
//        priorityMaxHeap.insert(0);
////        priorityMaxHeap.getArrayHeap();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
////        priorityMaxHeap.getArrayHeap();
//        priorityMaxHeap.insert(32323);
//        priorityMaxHeap.insert(334);
//        priorityMaxHeap.insert(11111);
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//        priorityMaxHeap.insert(323123123);
//        priorityMaxHeap.insert(100000000);
//
//        priorityMaxHeap.getArrayHeap();
//
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//
//        priorityMaxHeap.getArrayHeap();
//
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//
//        priorityMaxHeap.getArrayHeap();

//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.extractMax();
//
//        priorityMaxHeap.getArrayHeap();


//        priorityMaxHeap.insert(200);
//        priorityMaxHeap.insert(10);
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.insert(5);
//        priorityMaxHeap.insert(500);
//        priorityMaxHeap.extractMax();
//        priorityMaxHeap.insert(2);
//        priorityMaxHeap.insert(5);
//        priorityMaxHeap.insert(1);
//        priorityMaxHeap.insert(4);
//        priorityMaxHeap.insert(6);
//        priorityMaxHeap.insert(8);
//        priorityMaxHeap.insert(9);
//        priorityMaxHeap.insert(12);
//        priorityMaxHeap.insert(7);
//        priorityMaxHeap.insert(3);
//        priorityMaxHeap.insert(10);
////        System.out.println(Arrays.toString(priorityMaxHeap.getArrayHeap()));
//        System.out.println(priorityMaxHeap.extractMax());
////        System.out.println(Arrays.toString(priorityMaxHeap.getArrayHeap()));
//        System.out.println(priorityMaxHeap.extractMax());
////        System.out.println(Arrays.toString(priorityMaxHeap.getArrayHeap()));



        Scanner scan = new Scanner(System.in);
        PriorityMaxHeap priorityMaxHeap = new PriorityMaxHeap();
        int count = scan.nextInt();
        for (int i = 0; i < count; i ++){
            String string = scan.next();
            if(string.equals("Insert")){
                priorityMaxHeap.insert((scan.nextInt()));
            }
            if(string.equals("ExtractMax")){
                priorityMaxHeap.extractMax();
            }
        }



    }

    public void insert(int i) {

        int[] newArrHaep = new int[arrayHeap.length + 1];
        System.arraycopy(this.arrayHeap, 0, newArrHaep, 0, this.arrayHeap.length);
        newArrHaep[newArrHaep.length - 1] = i;
        this.arrayHeap = newArrHaep;
        if (newArrHaep.length <= 3) {
            for (int k = 1; k <= newArrHaep.length - 1; k++) {
                if (newArrHaep[k] > newArrHaep[0]) {
                    int buff = newArrHaep[0];
                    newArrHaep[0] = newArrHaep[k];
                    newArrHaep[k] = buff;
                }
            }
            this.arrayHeap = newArrHaep;
        } else {
            int ind = newArrHaep.length - 1;
            while (ind >= 0 && (newArrHaep[ind / 2] <= newArrHaep[ind])) {
                int buff = newArrHaep[ind / 2];
                newArrHaep[ind / 2] = newArrHaep[ind];
                newArrHaep[ind] = buff;
                ind = ind / 2;
                if (ind == 0) {
                    break;
                }
            }
            this.arrayHeap = newArrHaep;
//            System.out.println(Arrays.toString(arrayHeap));

        }


    }


    //        extract
    public void extractMax() {
        int maxExtract = this.arrayHeap[0];
        arrayHeap[0] = arrayHeap[arrayHeap.length - 1];

        arrayHeap = Arrays.copyOfRange(arrayHeap, 0, arrayHeap.length - 1);

        for (int i = 0; i < arrayHeap.length / 2; i++) {
            if (arrayHeap[i] < arrayHeap[2 * i] || arrayHeap[i] < arrayHeap[2 * i + 1]) {
                int buff = arrayHeap[i];
                if (arrayHeap[2 * i ] > arrayHeap[2 * i + 1]) {
                    arrayHeap[i] = arrayHeap[2 * i ];
                    arrayHeap[2 * i ] = buff;
                } else {
                    arrayHeap[i] = arrayHeap[2 * i + 1];
                    arrayHeap[2 * i + 1] = buff;
                }
            }
        }

        System.out.println(maxExtract);
    }

    private void getArrayHeap() {
        System.out.println(Arrays.toString(arrayHeap));
    }
}
