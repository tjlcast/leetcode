package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _086PartitionList {

  public static void main(String[] args) {
    ListNode node = ListNode.Create.createNode(6);
    ListNode node1 = ListNode.Create.createNode(6);
    node1 = ListNode.Reverse(node1);
    node = ListNode.Merge(node, node1);

    ListNode partition = new Solution().partition(node, 3);
    System.out.println(partition);
  }

  static class Solution {
    public ListNode partition(ListNode head, int x) {
      ListNode lRoot = new ListNode();
      ListNode lNode = lRoot;
      ListNode rRoot = new ListNode();
      ListNode rNode = rRoot;

      while (head != null) {
        if (head.val < x) {
          lNode.next = head;
          lNode = lNode.next;
        } else {
          rNode.next = head;
          rNode = rNode.next;
        }
        head = head.next;
        lNode.next = null;
        rNode.next = null;
      }

      lNode.next = rRoot.next;
      return lRoot.next;
    }
  }
}
