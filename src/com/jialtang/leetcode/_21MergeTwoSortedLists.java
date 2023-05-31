package com.jialtang.leetcode;

import com.jialtang.leetcode.common.ListNode;

public class _21MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node = ListNode.Create.createNode(3);
        ListNode node1 = ListNode.Create.createNode(10);
        ListNode listNode = new Solution().mergeTwoLists(node, node1);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root = new ListNode();
            ListNode node = root;

            while (list1 != null || list2 != null) {
                if (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        node.next = list1;
                        node = node.next;
                        list1 = list1.next;
                    } else {
                        node.next = list2;
                        node = node.next;
                        list2 = list2.next;
                    }
                    continue;
                }

                if (list2 == null) {
                    node.next = list1;
                    node = node.next;
                    list1 = list1.next;
                    continue;
                }

                if (list1 == null) {
                    node.next = list2;
                    node = node.next;
                    list2 = list2.next;
                    continue;
                }
            }

            return root.next;
        }
    }
}
