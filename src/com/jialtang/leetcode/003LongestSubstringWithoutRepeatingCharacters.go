package main

import "fmt"

func main() {
	//var s = "abcabcbb"
	//var s = "abcdef"
	//var s = "abcabcbb"
	var s = "abba"
	substring := lengthOfLongestSubstring(s)
	fmt.Println(substring)
}

func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}

	var longestLen = 1
	var lastIdx = 0
	var m = make(map[rune]int)
	for i, v := range s {
		if _,ok := m[v]; ok {
			if lastIdx < m[v] + 1 {
				lastIdx = m[v] + 1
			}
		}
		m[v] = i
		if longestLen <= i - lastIdx + 1 {
		    longestLen = i - lastIdx + 1
		}
	}
	return longestLen
}

