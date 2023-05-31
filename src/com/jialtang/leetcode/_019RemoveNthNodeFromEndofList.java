package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _019RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode node = ListNode.Create.createNode(20);
        ListNode listNode = new Solution().removeNthFromEnd(node, 3);
        System.out.println(listNode.toString());

        ListNode node1 = ListNode.Create.createNode(1);
        ListNode listNode1 = new Solution().removeNthFromEnd(node1, 1);
        System.out.println(listNode1.toString());
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root = new ListNode();
            root.next = head;

            Map<Integer, ListNode> nodeNo = new HashMap<>();
            int no = 0;
            ListNode node = root;
            while (node != null) {
                nodeNo.put(no++, node);
                node = node.next;
            }

            int preNo = no - n - 1;
            ListNode listNode = nodeNo.get(preNo);
            if (listNode == null) {
                return root.next;
            }
            listNode.next = (listNode.next == null) ? (null) : (listNode.next.next);
            return root.next;
        }
    }
}
