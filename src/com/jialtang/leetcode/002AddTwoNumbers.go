package main

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var root = &ListNode{}
	var tail = root

	var carry = 0
	for l1 != nil || l2 != nil {
		var node = &ListNode{}
		var val1 = 0
		var val2 = 0
		if l1 != nil {
			val1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			val2 = l2.Val
			l2 = l2.Next
		}
		node.Val = (val1 + val2 + carry) % 10
		carry = (val1 + val2 + carry) / 10

		tail.Next = node
		tail = tail.Next
	}

	if carry != 0 {
		node := newANode(carry)
		tail.Next = node
		tail = tail.Next
	}

	return root.Next
}

func newANode(val int) *ListNode {
	l := &ListNode{}
	l.Val = val
	return l
}

type ListNode struct {
	Val  int
	Next *ListNode
}
