package com.jialtang.leetcode.common.practice.QuickSort;

public class QuickSort3 {

  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 1, 43, 33, 22, 64, 74, 25, 13, 27, 98, 56, 100, 21, 7};
    new QuickSort3().quickSort(arr);
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
    int p = arr[left];
    int l = left;
    int r = right;

    while (l < r) {
      while (l < r && arr[r] > p) r--;
      if (l < r) arr[l++] = arr[r];
      while (l < r && arr[l] <= p) l++;
      if (l < r) arr[r--] = arr[l];
    }
    arr[r] = p;
    return r;
  }

  private void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}
