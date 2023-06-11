package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _082RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode node1 = ListNode.Create.createNode(5);
        ListNode node2 = ListNode.Create.createNode(5);
        ListNode merge = ListNode.merge(node1, node2);

        System.out.println(merge.toString());
        ListNode listNode = new Solution().deleteDuplicates(merge);
        System.out.println(listNode.toString());
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode root = new ListNode();
            ListNode l = root;
            ListNode r = head;

            while (r != null) {
                ListNode t = r;
                while (r!=null && r.next!=null && r.val==r.next.val) r = r.next;
                if (t == r) {
                    l.next = r;
                    l = l.next;
                }
                if (r != null) r = r.next;
                l.next = null;
            }

            return root.next;
        }
    }
}
