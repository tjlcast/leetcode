package com.jialtang.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _035Offer {

  static class Solution {
    public Node copyRandomList(Node head) {
      Node node = head;
      LinkedList<Node> nodeArr = new LinkedList<>();
      Map<Node, Integer> map = new HashMap<Node, Integer>();
      while (node != null) {
        map.put(node, nodeArr.size());
        nodeArr.add(node);
        node = node.next;
      }

      Node root = new Node(), tNode = head;
      node = root;
      int no = 0;
      Map<Integer, Node> map1 = new HashMap<>();
      while (tNode != null) {
        node.next = new Node();
        map1.put(no++, node.next);
        node = node.next;
        node.val = tNode.val;
        tNode = tNode.next;
      }

      node = head;
      Node newNode = root.next;
      while (node != null) {
        no = map.get(node.random);
        newNode.random = map1.get(no);

        node = node.next;
        newNode = newNode.next;
      }

      return root.next;
    }
  }

  static class Node {
    int val;
    Node next;
    Node random;

    public Node() {}

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
