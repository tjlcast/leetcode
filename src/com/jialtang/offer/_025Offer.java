package com.jialtang.offer;

import com.jialtang.leetcode.common.ListNode;

public class _025Offer {
  static class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode root = new ListNode(), tail = root;
      while (l1 != null || l2 != null) {
        int val1 = Integer.MAX_VALUE;
        int val2 = Integer.MAX_VALUE;
        if (l1 != null) val1 = l1.val;
        if (l2 != null) val2 = l2.val;

        ListNode node;
        if (val1 < val2) {
          node = l1;
          l1 = l1.next;
        } else {
          node = l2;
          l2 = l2.next;
        }
        node.next = null;
        tail.next = node;
        tail = tail.next;
      }

      return root.next;
    }
  }
}
