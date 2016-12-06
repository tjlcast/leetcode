public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    int directions[][] = {{0, -1}, {-1, 0}, {0, +1}, {+1, 0}} ;
    
    public int islandPerimeter(int[][] grid) {
        return work(grid) ;
    }
    
    public int work(int[][] grid) {
        int perimeter = 0 ;
        int width = grid[0].length; 
        int height = grid.length; 
        
        for(int h=0; h<height; h++) {
            for(int w=0; w<width; w++) {
                if (grid[h][w] == 1) {
                    for(int k=0; k<directions.length; k++) {
                        int newH = h + directions[k][0] ;
                        int newW = w + directions[k][1] ;
                        
                        try{
                            if (grid[newH][newW]==0) {
                                perimeter++ ;
                            }
                        } catch(Exception e) {
                            perimeter++ ;
                        }
                    }
                }
            }
        }
        
        return perimeter ;
    }
}
