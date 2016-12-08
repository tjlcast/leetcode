public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
	class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	final int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	boolean isV[][];
	int[][] result;

	public List<int[]> pacificAtlantic(int[][] matrix) {
	    ArrayList<int[]> res = new ArrayList<int[]>(); 
	    if (matrix==null || matrix.length==0 || matrix[0].length==0) return res ;
	    
		// pre work
		int rows = matrix.length;
		int cols = matrix[0].length;

		isV = new boolean[rows][cols];
		result = new int[rows][cols];

		// left
		LinkedList<Pointer> queueLeft = new LinkedList<Pointer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || j == 0) {
					queueLeft.add(new Pointer(i, j));
					isV[i][j] = true;
					result[i][j] += 1 ;
				} else isV[i][j] = false ;
			}
		}
		bfs(queueLeft, matrix) ;
		
//		result = new int[rows][cols];
		// right
		LinkedList<Pointer> queueRight = new LinkedList<Pointer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == rows-1 || j == cols-1) {
					queueRight.add(new Pointer(i, j));
					isV[i][j] = true;
					result[i][j] += 1 ;
				} else isV[i][j] = false ;
			}
		}
		bfs(queueRight, matrix) ;
		
		// count 
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (result[i][j] == 2) {
					int[] t = {i, j};
					res.add(t);
				} 
			}
		}
		
		return res ;
	}

	public void bfs(LinkedList<Pointer> queue, int[][] matrix) {
		// pre dfs
		int rows = matrix.length;
		int cols = matrix[0].length;

		while (queue.size() != 0) {
			Pointer curPointer = queue.pollLast();
			if (isV[curPointer.x][curPointer.y] == false)result[curPointer.x][curPointer.y] += 1;
			isV[curPointer.x][curPointer.y] = true;

			for (int k = 0; k < directions.length; k++) {
				int newRow = curPointer.x + directions[k][0];
				int newCol = curPointer.y + directions[k][1];

				if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols
						|| matrix[curPointer.x][curPointer.y] > matrix[newRow][newCol]) {
					continue;
				}
				if (isV[newRow][newCol] == true)
					continue;

				queue.addFirst(new Pointer(newRow, newCol));
			}
		}

		return;
	}
}
