package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _083RemoveDuplicatesfromSortedList {
  public static void main(String[] args) {
    ListNode nodeA = ListNode.Create.createNode(5);
    ListNode nodeB = ListNode.Create.createNode(9);

    ListNode merge = ListNode.merge(nodeA, nodeB);
    System.out.println(merge.toString());

    ListNode listNode = new Solution().deleteDuplicates(merge);
    System.out.println(listNode.toString());
  }

  static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode root = new ListNode();
      ListNode node = root;

      while (head != null) {
        ListNode t = head;
        while (head != null && head.next != null && head.val == head.next.val) head = head.next;
        node.next = head;
        node = node.next;

        head = head.next;
        node.next = null;
      }

      return root.next;
    }
  }
}
