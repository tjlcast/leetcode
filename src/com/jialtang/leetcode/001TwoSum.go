package main

import "fmt"

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		rest := target - v
		if val, ok := m[rest]; ok {
			return []int {val, i}
		} else {
			m[v] = i
		}
	}
	return nil
}

func main() {
	var target = 5
	var nums = []int{1, 2, 3, 4}
	sum := twoSum(nums, target)
	fmt.Println(sum)
}
