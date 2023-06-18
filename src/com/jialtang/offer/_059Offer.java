package com.jialtang.offer;

import java.util.LinkedList;

public class _059Offer {

  static class MaxQueue {
    private LinkedList<Integer> queue = new LinkedList<>();
    private LinkedList<Integer> maxs = new LinkedList<>();

    public int max_value() {
      return maxs.getFirst();
    }

    public void push_back(int value) {
      queue.addLast(value);

      int maxValue = value;
      while (!maxs.isEmpty() && maxs.getLast() < value) maxs.removeLast();
      maxs.addLast(maxValue);
    }

    public int pop_font() {
      if (queue.isEmpty()) {
        return -1;
      }

      int res = queue.getFirst();
      if (res == maxs.getFirst()) maxs.removeFirst();
      queue.removeFirst();
      return res;
    }
  }
}
