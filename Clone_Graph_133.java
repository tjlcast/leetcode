/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Solution_1 s = new Solution_1() ;
        return s.work(node) ;
    }
    
}


class Solution_1 {
    private List<UndirectedGraphNode> nodes; 
    private List<UndirectedGraphNode> newNodes;
    
    public Solution_1() {
        this.nodes = new List<UndirectedGraphNode>() ;
        this.newNodes = new List<UndirectedGraphNode>() ;
    }
    
    private void work(UndirectedGraphNode node) {
        dfs(node) ;
        foreach(UndirectedGraphNode curNode: this.nodes) {
            UndirectedGraphNode builtNode = new UndirectedGraphNode(curNode.label) ; 
            this.newNodes.add(builtNode) ;
            foreach(UndirectedGraphNode neighbor: curNode.neighbors) {
                int label = neighbor.label ;
                UndirectedGraphNode tempNode = findNode(label, this.newNodes) ;
                builtNode.neighbors.add(tempNode) ;
            }
        }
        return this.newNodes;
    }
    
    private void dfs(UndirectedGraphNode root) {
        if (root == NULL) {return ;}
        this.nodes.add(root) ;
        foreach(UndirectedGraphNode neighbor: root.neighbors) {
            dfs(neighbor) ; 
        }
    }
    
    private UndirectedGraphNode findNode(int flag) {
        foreach(UndirectedGraphNode curNode : this.newNodes) {
            if (curNode.label == flag) {
                return curNode ;
            }
            UndirectedGraphNode tempNode = new UndirectedGraphNode(flag) ;
            this.newNodes.add(tempNode) ;
            return tempNode ;
        }
    }
}
