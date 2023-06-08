package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _061RotateList {
  public static void main(String[] args) {
    ListNode node, listNode;

    node = ListNode.Create.createNode(3);
    listNode = new Solution().rotateRight(node, 2000000000);
    System.out.println(listNode);

    node = ListNode.Create.createNode(5);
    listNode = new Solution().rotateRight(node, 2);
    System.out.println(listNode);
  }

  static class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if (head == null) return head;

      ListNode root = new ListNode();
      root.next = head;

      int len = getLen(head);
      k = k % len;

      for (int i = 0; i < k; i++) {
        ListNode node = root;
        while (node.next.next != null) node = node.next;

        ListNode lastNode = node.next;
        node.next = null;

        lastNode.next = root.next;
        root.next = lastNode;
      }

      return root.next;
    }

    private int getLen(ListNode node) {
      int num = 0;
      while (node != null) {
        node = node.next;
        num += 1;
      }
      return num;
    }
  }
}
