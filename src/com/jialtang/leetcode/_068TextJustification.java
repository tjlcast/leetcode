package com.jialtang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _068TextJustification {

  // This     is    an
  public static void main(String[] args) {
    String[] words;
    List<String> strings;
    int maxWidth;

    words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
    maxWidth = 16;
    strings = new Solution().fullJustify(words, maxWidth);
    System.out.println(Arrays.toString(strings.toArray()));
  }

  static class Solution {
    List<String> ans = new LinkedList<>();
    int maxWidth;

    public List<String> fullJustify(String[] words, int maxWidth) {
      this.maxWidth = maxWidth;
      int i = 0;
      List<String> aLine = new LinkedList<>();
      while (i < words.length) {
        String word = words[i];
        if (!canLine(aLine, word)) {
          String lineStr = toLineString(aLine, true);
          ans.add(lineStr);
          aLine.clear();
        }
        aLine.add(word);
        i++;
      }

      if (!aLine.isEmpty()) {
        ans.add(toLineString(aLine, false));
      }

      return ans;
    }

    private String toLineString(List<String> aLine, boolean avg) {
      if (!avg || aLine.size() == 1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aLine.size(); i++) {
          if (i != 0) {
            sb.append(" ");
          }
          sb.append(aLine.get(i));
        }
        while (sb.length() < this.maxWidth) sb.append(" ");
        return sb.toString();
      }

      int boxTotal = 0;
      int charNum = 0;
      int wordNum = aLine.size();
      int boxSize = wordNum - 1;
      for (String word : aLine) {
        charNum += word.length();
      }
      boxTotal = this.maxWidth - charNum;

      int[] boxLength = new int[boxSize];
      int boxPerLen = boxTotal / boxSize;
      int b = boxTotal % boxSize;
      for (int i = 0; i < boxLength.length; i++) {
        boxLength[i] = boxPerLen;
        if (i + 1 <= b) boxLength[i] += 1;
      }

      StringBuilder sb = new StringBuilder();
      int j = 0;
      for (int i = 0; i < aLine.size(); i++) {
        if (i != 0) {
          int i1 = boxLength[j++];
          for (int i11 = 0; i11 < i1; i11++) sb.append(" ");
        }
        sb.append(aLine.get(i));
      }
      return sb.toString();
    }

    private boolean canLine(List<String> aLine, String word) {
      int size = 0;
      for (String lineWord : aLine) {
        size += (lineWord.length() + 1);
      }
      if (size + word.length() <= maxWidth) {
        return true;
      }
      return false;
    }
  }
}
