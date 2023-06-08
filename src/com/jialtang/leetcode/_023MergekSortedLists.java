package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _023MergekSortedLists {
  public static void main(String[] args) {
    ListNode node = ListNode.Create.createNode(3);
    ListNode node2 = ListNode.Create.createNode(2);
    ListNode node1 = ListNode.Create.createNode(4);
    ListNode[] lists = new ListNode[] {node, node1, node2};

    ListNode listNode = new Solution().mergeKLists(lists);
    System.out.println(listNode);
  }

  static class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode root = new ListNode();
      ListNode tail = root;

      int pos = getMinPos(lists);
      while (pos != -1) {
        ListNode node = lists[pos];
        lists[pos] = lists[pos].next;
        tail.next = node;
        tail = tail.next;
        pos = getMinPos(lists);
      }

      return root.next;
    }

    private int getMinPos(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return -1;
      }
      int pos = -1;
      int val = Integer.MAX_VALUE;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null && lists[i].val <= val) {
          pos = i;
          val = lists[i].val;
        }
      }
      return pos;
    }
  }
}
