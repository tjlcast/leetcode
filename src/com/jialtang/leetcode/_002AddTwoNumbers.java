package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _002AddTwoNumbers {

    public static void main(String[] args) {
        ListNode list1 = ListNode.Create.createNode(9);
        System.out.printf("List: [%s]", list1.toString());
        ListNode list2 = ListNode.Create.createNode(9);
        System.out.printf("List: [%s]", list2.toString());

        ListNode listNode = new Solution().addTwoNumbers(list1, list2);
        System.out.printf("List: [%s]", listNode.toString());
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode();
            ListNode cur = root;

            ListNode s1 = l1;
            ListNode s2 = l2;
            int carr = 0;

            while (s1 != null || s2 != null) {
                int val1 = getVal(s1);
                int val2 = getVal(s2);

                ListNode newNode = new ListNode();
                newNode.val = (val1 + val2 + carr) % 10;
                carr = (val1 + val2 + carr) / 10;
                cur.next = newNode;
                cur = nextNode(cur);

                s1 = nextNode(s1);
                s2 = nextNode(s2);
            }

            if (carr != 0) {
                ListNode newNode = new ListNode();
                newNode.val = (carr) % 10;
                cur.next = newNode;
                cur = nextNode(cur);
            }

            return root.next;
        }

        private ListNode nextNode(ListNode node) {
            if (node == null) {
                return null;
            }

            return node.next;
        }

        private int getVal(ListNode node) {
            if (node == null) {
                return 0;
            }
            return node.val;
        }
    }
}
