package com.jialtang.leetcode.common;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode merge(ListNode node1, ListNode node2) {
    ListNode root = new ListNode();
    ListNode node = root;
    while(node1!=null || node2!=null) {
      int val1 = Integer.MAX_VALUE, val2=val1;
      if (node1!=null) val1 = node1.val;
      if (node2!=null) val2 = node2.val;
      if (val1 < val2) {
        node.next = node1;
        node = node.next;
        node1 = node1.next;
      } else {
        node.next = node2;
        node = node.next;
        node2 = node2.next;
      }
    }
    return root.next;
  }

    @Override
  public String toString() {
    if (this.next == null) {
      return this.val + "";
    }
    return this.val + " " + this.next.toString();
  }

  public static class Create {
    public static ListNode createNode(int n) {
      ListNode root = new ListNode();
      ListNode node = root;

      for (int i = 0; i < n; i++) {
        ListNode listNode = new ListNode();
        listNode.val = i;
        node.next = listNode;
        node = listNode;
      }

      return root.next;
    }
  }
}
