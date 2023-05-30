package com.jialtang.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.next == null) {
            return this.val + "";
        }
        return this.val + " " + this.next.toString();
    }

    public static class Create {
        public static ListNode createNode(int n) {
            ListNode root = new ListNode();
            ListNode node = root;

            for (int i = 0; i < n; i++) {
                ListNode listNode = new ListNode();
                listNode.val = i;
                node.next = listNode;
                node = listNode;
            }

            return root.next;
        }
    }
}
