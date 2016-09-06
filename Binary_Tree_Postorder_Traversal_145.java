/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    String __autho__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    
    public List<Integer> postorderTraversal(TreeNode root) {
        return new Solution1().work(root) ;
    }
}


class Solution1 {
    
    private List<Integer> ans ;
    
    public Solution1() {
        ans = new ArrayList<Integer>() ;
    }
    
    public List<Integer> work(TreeNode root) {
        preTravel(root) ;
        return (List)ans ;
    }
    
    private void preTravel(TreeNode root) {
        if (root == null) {
            return ;
        }
        
        preTravel(root.left) ;
        preTravel(root.right) ;
        ans.add(new Integer(root.val)) ;
    }
}
