/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    private String __author__ = "tangjialiang" ;
    private String __V__ = "test_V" ;

    public void connect(TreeLinkNode root) {
        work(root) ;
    }
    
    private void work(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>() ;
        
        queue.addFirst(null) ;
        queue.addFirst(root) ;
        
        TreeLinkNode lastNode = null ;
        while(queue.size() != 0) {
            TreeLinkNode tempNode = queue.removeLast() ;
            if (tempNode == null && lastNode == null) {break ;}
            
            if (tempNode != null) {
                 tempNode.next = lastNode ;
                if (tempNode.right != null)queue.addFirst(tempNode.right) ;
                if (tempNode.left != null)queue.addFirst(tempNode.left) ;
            } else {
                queue.addFirst(null) ;
            }
            
            lastNode = tempNode ;
        }
    }
}
