/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    
    public void connect(TreeLinkNode root) {
        if(root == null) {return ;}
        
        bfs(root) ;
    }
    
    private void bfs(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>() ;
        TreeLinkNode tempNullNode = new TreeLinkNode(-1) ;
        TreeLinkNode lastNode = null ;
        
        queue.addFirst(root) ;
        queue.addFirst(tempNullNode) ;
        
        while(queue.size() != 0) {
            TreeLinkNode curNode = queue.removeLast() ;
            System.out.println(curNode.val + " " + queue.size()) ;
            
            if (curNode == tempNullNode) {
                if (queue.size() == 0) break ;
                lastNode = null ;
                queue.addFirst(curNode) ;
            } else {
                curNode.next = lastNode ;
                lastNode = curNode ;
            }
            
            if(curNode.right != null) queue.addFirst(curNode.right) ;
            if(curNode.left != null) queue.addFirst(curNode.left) ;
        }
    }
    
}
