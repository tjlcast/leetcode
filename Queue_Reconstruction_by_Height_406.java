public class Solution {  
    
    private String __author__ = "network" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "http://blog.csdn.net/u012985132/article/details/52690290" ;
    
    public int[][] reconstructQueue(int[][] people) {  
         
        Arrays.sort(people,new Comparator<int[]>(){  
           @Override  
           public int compare(int[] o1, int[] o2){  
           //compare  1-2 升序排列  2-1 降序排列  
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];  
           }  
        });  
        
        List<int[]> res = new LinkedList<>();  
        for(int[] cur : people){  
            res.add(cur[1],cur);         
        }  
        
        return res.toArray(new int[people.length][]);  
    }  
}  
