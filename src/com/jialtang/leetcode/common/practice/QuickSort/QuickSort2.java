package com.jialtang.leetcode.common.practice.QuickSort;

public class QuickSort2 {

  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 1, 43, 33, 22, 64, 74, 25, 13, 27, 98, 56, 100, 21, 7};
    new QuickSort2().quickSort(arr);
    for (int x : arr) {
      System.out.print(x + " ");
    }
  }

  private void quickSort(int[] arr) {
    quick(arr, 0, arr.length - 1);
  }

  public void quick(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int pivot = partition(arr, left, right);
    quick(arr, left, pivot - 1);
    quick(arr, pivot + 1, right);
  }

  public int partition(int[] arr, int left, int right) {
    int val = arr[left];
    int p = left;

    for (int i=left+1; i<=right; i++) {
      if (arr[i] < val) {
        p++;
        int t = arr[i];
        arr[i] = arr[p];
        arr[p] = t;
      }
    }

    arr[left] = arr[p];
    arr[p] = val;
    return p;
  }

  private void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}
