import java.util.* ;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return new Solution3().work(numCourses, prerequisites) ;
    }
}


class Solution3 {  
    public boolean work(int numCourses, int[][] prerequisites) {  
        int[] map = new int[numCourses];  
          
        for(int i=0;i<prerequisites.length; i++) {  
            map[ prerequisites[i][1] ] ++;  
        }  
          
        Queue<Integer> que = new LinkedList<Integer>();  
          
        for(int i=0; i<map.length; i++) {  
            if(map[i]==0) que.add(i);  
        }  
          
        int count = que.size();  
        while(!que.isEmpty() ) {  
            int k = que.remove();  
            for(int i=0; i<prerequisites.length; i++) {  
                if(k == prerequisites[i][0]) {  
                    int l = prerequisites[i][1];  
                    map[l]--;  
                    if(map[l]==0) {  
                        que.add(l);  
                        ++count;  
                    }  
                }  
            }  
        }  
        return count == numCourses;  
    }  
}  

class Solution2 {
    private int[] nodeInput ;
    private LinkedList<Integer> zeroNodes = new LinkedList<Integer>() ;
    
    private int isConnect(int s, int l, int[][] prerequisites) {
        int num = 0 ;
        for(int k=0; k<prerequisites.length; k++) {
            try{
                if (prerequisites[k][0]==s && prerequisites[k][1]==l) num++ ;
            }catch (Exception e){
                
            }
        }
        return num ;
    }
    
    private void build(int numCourses, int[][] prerequisites) {
        nodeInput = new int[numCourses] ;
        
        HashMap<Integer, HashSet<Integer>> countInput = new HashMap<Integer, HashSet<Integer>>() ;
        for (int k=0; k<prerequisites.length; k++) {
            int curNode = prerequisites[k][1] ;
            if (countInput.get(curNode)==null) {
                // add 
                HashSet<Integer> tempSet = new HashSet<Integer>() ;
                tempSet.add(prerequisites[k][0]) ;
                countInput.put(new Integer(curNode), tempSet) ;
            } else {
                //++
                countInput.get(curNode).add(prerequisites[k][0]) ;
            }
            
        }
        
        for(Integer key : countInput.keySet()) {
            nodeInput[key] = countInput.get(key).size();
        }
        for(int k=0; k<numCourses; k++) {
            if (nodeInput[k] == 0) {
                zeroNodes.add(k) ;
            }
        }
    }
    
    public boolean work(int numCourses, int[][] prerequisites) {
        build(numCourses, prerequisites) ;
        return topologicalSorting(numCourses, prerequisites) ;
    }
    
    private boolean topologicalSorting(int numCourses, int[][] prerequisites) {
        while(zeroNodes.size() != 0) {
            Integer zeroNode = zeroNodes.poll() ;
            for(int k=0; k<numCourses; k++) {
                if (isConnect(zeroNode, k, prerequisites)>0 && k!=zeroNode) {
                    nodeInput[k]-=1;
                    if (nodeInput[k]==0) {
                        zeroNodes.add(k) ;
                    }
                }
            }
        }
        for(int k=0; k<numCourses; k++) {
            if (nodeInput[k] > 0) {
                return false ;
            }
        }
        return true ;
    }
    
    
}

// class Solution1 {
    
//     private boolean[] isVisited ;
//     private int[][] map ;
//     private HashSet<Integer> contridutionNode = new HashSet<Integer>() ;
    
    
//     private void build(int numCourses, int[][] prerequisites) {
//         map = new int[numCourses][numCourses] ;
        
//         for(int k=0; k<prerequisites.length; k++) {
//             map[prerequisites[k][0]][prerequisites[k][1]] = 1 ;
//             contridutionNode.add(prerequisites[k][0]) ;
//             contridutionNode.add(prerequisites[k][1]) ;
//             System.out.println("build: " + prerequisites[k][0] + "-" + prerequisites[k][1]) ;
//         }
//     }
    
//     private void initial(int numCourses) {
//         System.out.println("initial") ;
//         for(int i=0; i<numCourses; i++) {
//             isVisited[i] = false ;
//             if (contridutionNode.contains(i)==false) {
//                 isVisited[i] = true ;
//             }
//             System.out.println(i + "-" + isVisited[i]) ;
//         }
//     }
    
//     private boolean allFinish(int numCourses) {
//         System.out.println("allFinish") ;
//         for(int i=0; i<numCourses; i++) {
//             System.out.println("i: " + i + " val: " + isVisited[i]) ;
//             if (isVisited[i] == false) {
//                 return false ;
//             }
//         }
//         return true ;
//     }
    
//     private boolean bfs(int s, int numCourses) {
//         System.out.println("bfs");
//         initial(numCourses) ;
//         LinkedList<Integer> queue = new LinkedList<Integer>() ;
        
//         queue.addLast(s) ;
//         isVisited[s] = true ;
        
//         while(queue.size() != 0) {
//             Integer node = queue.removeFirst() ;
//             System.out.println("node: " + node) ;
//             for(int i=0; i<numCourses; i++) {
//                 if (map[node][i]==1 && i!=node && isVisited[i]==true) {
//                     return false ;
//                 }
//                 if (map[node][i]==1 && i!=node && isVisited[i]==false) {
//                     queue.addLast(i) ;
//                     isVisited[node] = true ;
//                 }
//             }
//         }
        
//         return true ;
//     }
    
//     public boolean work(int numCourses, int[][] prerequisites) {
        
//         if (prerequisites.length == 0) {
//             return true ;
//         }
        
//         build(numCourses, prerequisites) ;
//         isVisited = new boolean[numCourses] ;
//         boolean ans = true ;
//         for(int s=0; s<numCourses; s++) {
//             ans = bfs(s, numCourses) ;
//             if (ans == false) {
//                 return false ;
//             }
//         }
//         return ans ;
//     }
// }
