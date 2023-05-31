package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

import java.util.Stack;

public class _025ReverseNodesinkGroup {

    public static void main(String[] args) {
        ListNode node = ListNode.Create.createNode(8);
        ListNode listNode = new Solution().reverseKGroup(node, 3);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode root = new ListNode();
            ListNode tail = root;

            ListNode node = head;
            Stack<ListNode> queue = new Stack();
            while (node != null) {
                for (int i = 0; node != null && i < k; i++) {
                    ListNode tmp = node;
                    node = node.next;

                    tmp.next = null;
                    queue.add(tmp);
                }

                if (node == null && queue.size() < k) {
                    break;
                }

                while (!queue.isEmpty()) {
                    tail.next = queue.pop();
                    tail = tail.next;
                }
            }

            while (queue.size() > 0) {
                ListNode tmp = queue.pop();
                tmp.next = tail.next;
                tail.next = tmp;
            }

            return root.next;
        }
    }
}
