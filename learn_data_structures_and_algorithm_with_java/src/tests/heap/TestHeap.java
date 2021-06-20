package tests.heap;

import java.util.Random;

import data_structures.heap.MaxHeap;

public class TestHeap{
    public static void main(String[] args) throws Exception {
        // checkHeap();



        int n = 1000000;

        Integer[] testData = new Integer[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        System.out.println("not heapify is " + testHeap(testData,false) + "s.");
        System.out.println("heapify is " + testHeap(testData,true) + "s.");
    }

    private static void checkHeap(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("tests heape");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("MaxHeap Test Complated.");
    }


    private static double testHeap(Integer[] testData, boolean isHeapify){
        long starTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            System.out.println("heapify:");
            maxHeap = new MaxHeap<>(testData);

        }else{
            System.out.println("not heapify:");
            maxHeap = new MaxHeap<>();
            for (Integer num : testData) {
                maxHeap.add(num);
            }
        }
        int[] arr = new int[testData.length];

        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("check worng");
            }
        }
        long endTime = System.nanoTime();

        return (endTime - starTime) / 1000000000.0;
    }
}