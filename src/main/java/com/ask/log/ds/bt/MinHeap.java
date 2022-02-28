package com.ask.log.ds.bt;

public class MinHeap {

    int size;
    int currentIndex;
    int[] data;
    MinHeap(int size) {
        this.size = size;
        this.data = new int[size];
    }

    public void add(int data) {
        this.data[currentIndex] = data;
        heapify();
    }

    private void heapify() {

    }
}
