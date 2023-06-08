package com.jialtang.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _030SubstringwithConcatenationofAllWords {

  public static void main(String[] args) {
    String s = "barfoothefoobarman";
    String[] word = {"foo", "bar"};
    List<Integer> substring = new Solution().findSubstring(s, word);
    System.out.println(substring);

    s = "wordgoodgoodgoodbestword";
    word = new String[] {"word", "good", "best", "word"};
    substring = new Solution().findSubstring(s, word);
    System.out.println(substring);

    s = "barfoofoobarthefoobarman";
    word = new String[] {"bar", "foo", "the"};
    substring = new Solution().findSubstring(s, word);
    System.out.println(substring);
  }

  static class Solution {
    int wordLen;
    int wordSize;

    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> ans = new LinkedList<>();
      Map<String, Integer> wordNum = new HashMap<>();
      wordLen = words[0].length();
      wordSize = words.length;
      for (String word : words) {
        Integer orDefault = wordNum.getOrDefault(word, 0);
        orDefault += 1;
        wordNum.put(word, orDefault);
      }

      for (int i = 0; i < s.length(); i++) {
        if (isSub(i, s, wordNum)) {
          ans.add(i);
        }
      }

      return ans;
    }

    private boolean isSub(int pos, String s, Map<String, Integer> wordNum) {
      HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
      if (pos + wordSize * wordLen > s.length()) {
        return false;
      }

      for (int i = 0; i < wordSize; i++) {
        String substring = s.substring(pos + i * wordLen, pos + i * wordLen + wordLen);
        Integer orDefault = stringIntegerHashMap.getOrDefault(substring, 0);
        orDefault += 1;
        stringIntegerHashMap.put(substring, orDefault);
      }

      return stringIntegerHashMap.equals(wordNum);
    }
  }
}
