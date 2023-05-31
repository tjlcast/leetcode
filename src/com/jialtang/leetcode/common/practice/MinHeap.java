package com.jialtang.leetcode.common.practice;

public class MinHeap {
    int[] heap;
    int capacity;
    int size;

    public MinHeap(int n) {
        heap = new int[n];
        capacity = n;
        size = 0;
    }

    private void swap(int a, int b) {
        int i = heap[a];
        heap[a] = heap[b];
        heap[b] = i;
    }

    public void offer(int element) {
        if (isFull()) {
            return;
        }

        heap[size++] = element;
        int idxStart = size - 1;
        int idxFather = (idxStart - 1) >> 1;
        while (idxFather >= 0 && heap[idxStart] < heap[idxFather]) {
            swap(idxStart, idxFather);
            idxStart = idxFather;
            idxFather = (idxStart - 1) >> 1;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        int popVal = heap[0];
        heap[0] = heap[--size];

        int idxStart = 0;
        int idxLeft = (idxStart << 1) + 1;
        int idxRight = (idxStart << 1) + 2;
        while (idxLeft < size) {
            int idxMin;
            if (idxRight < size && heap[idxRight] < heap[idxStart]) {
                idxMin = idxRight;
            } else {
                idxMin = idxLeft;
            }

            if (heap[idxStart] <= heap[idxMin]) {
                break;
            }

            swap(idxStart, idxMin);
            idxStart = idxMin;
            idxLeft = (idxStart << 1) + 1;
            idxRight = (idxStart << 1) + 2;
        }

        return popVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }
}
