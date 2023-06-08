package com.jialtang.leetcode;

import java.util.Stack;

public class _020ValidParentheses {
  public static void main(String[] args) {
    String s = "()[]{}";
    boolean valid = new Solution().isValid(s);
    System.out.println(valid);

    String s1 = "(]{}";
    boolean valid1 = new Solution().isValid(s1);
    System.out.println(valid1);

    String s2 = "([)]";
    boolean valid2 = new Solution().isValid(s2);
    System.out.println(valid2);
  }

  static class Solution {
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        Character peek = (stack.isEmpty()) ? ('0') : (stack.peek());
        switch (c) {
          case ')':
            if (peek.equals('(')) {
              stack.pop();
            } else {
              return false;
            }
            break;
          case ']':
            if (peek.equals('[')) {
              stack.pop();
            } else {
              return false;
            }
            break;
          case '}':
            if (peek.equals('{')) {
              stack.pop();
            } else {
              return false;
            }
            break;
          default:
            if (!(c == '(' || c == '[' || c == '{')) {
              return false;
            }
            stack.add(c);
        }
      }
      if (stack.isEmpty()) {
        return true;
      }
      return false;
    }
  }
}
