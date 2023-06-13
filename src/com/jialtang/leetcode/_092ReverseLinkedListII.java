package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _092ReverseLinkedListII {

  public static void main(String[] args) {
    ListNode head = ListNode.Create.createNode(5);
    ListNode listNode = new Solution().reverseBetween(head, 2, 4);
    System.out.println(listNode.toString());
  }

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
   * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
   * this.next = next; } }
   */
  static class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode root = new ListNode();
      ListNode node = root;
      root.next = head;
      int step = left - 1;
      int len = right - left + 1;

      for (int i = 0; i < step && node != null; i++) {
        node = node.next;
      }

      ListNode lNode = node;
      if (lNode == null) return null;
      ListNode rNode = node.next;
      ListNode tail = rNode;
      if (rNode == null) return null;
      lNode.next = null;

      for (int i = 0; i < len && rNode != null; i++) {
        ListNode k = rNode;
        rNode = rNode.next;
        k.next = null;

        System.out.println(k.val);

        k.next = lNode.next;
        lNode.next = k;
      }

      if (rNode != null) {
        tail.next = rNode;
      }

      return root.next;
    }
  }
}
