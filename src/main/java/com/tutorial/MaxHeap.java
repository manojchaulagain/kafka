package com.tutorial;

public class MaxHeap {

    private final int[] heap;
    private int size;

    public MaxHeap(int heapCapacity) {
        heap = new int[heapCapacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int val) {
        if (isEmpty()) {
            heap[0] = val;
        } else {
            heap[size] = val;
            heapifyUp(size);
        }
        size++;
    }

    public int remove() {
        int val;
        if (isEmpty()) {
            val = -1;
        } else {
            val = heap[0];
            heap[0] = heap[size - 1];
            heapifyDown(0);
        }
        size--;
        return val;
    }

    private int parent(int index) {
        return heap[(index - 1) / 2];
    }

    private void heapifyUp(int index) {
        if (heap[index] <= parent(index) ||   index <= 0) {
            return;
        }
        swap(index, (index - 1) / 2);
        heapifyUp((index - 1) / 2);

    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int leftChild(int index) {
        return heap[2 * index + 1];
    }

    private int rightChild(int index) {
        return heap[2 * index + 2];
    }

    private void heapifyDown(int index) {
        if (index > size / 2 && index <= size) {
            return;
        }
        if (heap[index] < leftChild(index) && size > 2 * index + 1) {
            swap(index, 2 * index + 1);
            heapifyDown(2 * index + 1);
        }
        if (heap[index] < rightChild(index) && size > 2 * index + 2) {
            swap(index, 2 * index + 2);
            heapifyDown(2 * index + 2);
        }
    }

}
