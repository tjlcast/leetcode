/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    private LinkedList<TreeNode> queue ;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<TreeNode>() ;
        
        TreeNode goNode = root ;
        while(goNode != null) {
            queue.add(goNode) ;
            goNode = goNode.left ;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (queue.size()!=0) {
            return true ;
        }
        return false ;
    }

    /** @return the next smallest number */
    public int next() {
        if (queue.size()==0) {
            return -1 ;
        }
        TreeNode tailNode = queue.removeLast() ;
        
        int val = tailNode.val ;
        
        TreeNode childRightNode = tailNode.right ;
        while(childRightNode != null) {
            queue.add(childRightNode) ;
            childRightNode = childRightNode.left ;
        }
        
        return val ;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
