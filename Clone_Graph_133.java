/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
public class Solution {
    
    private String author = 'tangjialiang' ;
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Solution_1 s = new Solution_1() ;
        return s.work(node) ;
    }
    
}


class Solution_1 {
    private ArrayList<UndirectedGraphNode> nodes; 
    private ArrayList<UndirectedGraphNode> newNodes;
    
    public Solution_1() {
        this.nodes = new ArrayList<UndirectedGraphNode>() ;
        this.newNodes = new ArrayList<UndirectedGraphNode>() ;
    }
    
    public UndirectedGraphNode work(UndirectedGraphNode node) {
        if (node == null) {return null ;}
        
        dfs(node) ;
        for (UndirectedGraphNode curNode : this.nodes) {
            UndirectedGraphNode builtNode = findNode(curNode.label) ;
            this.newNodes.add(builtNode) ;
            for (UndirectedGraphNode neighbor: curNode.neighbors) {
                int label = neighbor.label ;
                UndirectedGraphNode tempNode = findNode(label) ;
                builtNode.neighbors.add(tempNode) ;
            }
        }
        return findNode(node.label);
    }
    
    private void dfs(UndirectedGraphNode root) {
        if (root == null) {return ;}
        this.nodes.add(root) ;
        for (UndirectedGraphNode neighbor: root.neighbors) {
            if (this.nodes.contains(neighbor)) {continue; }
            dfs(neighbor) ; 
        }
    }
    
    private UndirectedGraphNode findNode(int flag) {
        for (UndirectedGraphNode curNode : this.newNodes) {
            if (curNode.label == flag) {
                return curNode ;
            }
        }
        UndirectedGraphNode tempNode = new UndirectedGraphNode(flag) ;
        this.newNodes.add(tempNode) ;
        return tempNode ;
    }
}
