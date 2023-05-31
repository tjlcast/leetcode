package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _024SwapNodesinPairs {

    public static void main(String[] args) {
        ListNode node = ListNode.Create.createNode(4);
        ListNode listNode = new Solution().swapPairs(node);
        System.out.println(listNode);

        node = ListNode.Create.createNode(1);
        listNode = new Solution().swapPairs(node);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode root = new ListNode();
            ListNode tail = root;

            ListNode node = head;
            while (node != null) {
                if (node.next == null) {
                    ListNode node_a = node;
                    node = node.next;

                    tail.next = node_a;
                    tail = tail.next;
                } else {
                    ListNode node_a = node;
                    node = node.next;
                    ListNode node_b = node;
                    node = node.next;
                    node_a.next = null;
                    node_b.next = null;

                    tail.next = node_b;
                    tail = tail.next;
                    tail.next = node_a;
                    tail = tail.next;
                }
            }

            return root.next;
        }
    }
}
