import java.util.* ;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return new Solution1().work(numCourses, prerequisites) ;
    }
}

class Solution1 {  
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    LinkedList<Integer> ansList = new LinkedList<Integer>() ;
    
    public int[] work(int numCourses, int[][] prerequisites) {    
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
            ansList.addFirst(k) ;
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
        int[] ans = new int[ansList.size()] ;
        for(int i=0; i<ansList.size() ;i++) {
            ans[i] = ansList.get(i) ;
        }
        if (count == numCourses)
            return ans ;
        return new int[0] ;
    }  
}  
