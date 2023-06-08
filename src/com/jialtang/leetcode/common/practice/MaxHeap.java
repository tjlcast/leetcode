package com.jialtang.leetcode.common.practice;

public class MaxHeap {
  int[] maxHeap;
  int capacity;
  int size;

  public MaxHeap(int n) {
    maxHeap = new int[n];
    capacity = n;
    size = 0;
  }

  private void swap(int a, int b) {
    int tmp = maxHeap[a];
    maxHeap[a] = maxHeap[b];
    maxHeap[b] = tmp;
  }

  public void offer(int element) {
    if (isFull()) {
      return;
    }

    maxHeap[size++] = element;
    int idxStart = size - 1;
    int idxFather = (idxStart - 1) >> 1;
    while (idxFather >= 0 && maxHeap[idxStart] > maxHeap[idxFather]) {
      swap(idxFather, idxStart);
      idxStart = idxFather;
      idxFather = (idxStart - 1) >> 1;
    }
  }

  public int peek() {
    return maxHeap[0];
  }

  public int poll() {
    if (isEmpty()) {
      return -1;
    }

    int popVal = maxHeap[0];
    maxHeap[0] = maxHeap[--size];

    int idxStart = 0;
    int idxLeft = (idxStart << 1) + 1, idxRight = idxLeft + 1;
    int largest = 0;

    while (idxLeft < size) {
      if (idxRight < size && maxHeap[idxRight] > maxHeap[idxLeft]) {
        largest = idxRight;
      } else {
        largest = idxLeft;
      }

      if (maxHeap[idxStart] > maxHeap[largest]) {
        break;
      }

      swap(idxStart, largest);
      idxStart = largest;
      idxLeft = (idxStart << 1) + 1;
      idxRight = idxLeft + 1;
    }
    return popVal;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }
}
