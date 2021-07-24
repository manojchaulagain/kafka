package com.tutorial;

import com.tutorial.MaxHeap;

public class TestMaxHeap {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(20);
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(7);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(4);
        maxHeap.add(6);
        System.out.println(maxHeap.getSize());

        while(!maxHeap.isEmpty()) {
            System.out.print(maxHeap.remove() + " -> ");
        }
    }
}
