
class Solution {
    private static int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int islandCounter = 0;

        for(int row =0; row < rows; row++){
            for(int col =0; col< cols; col++){
                if(grid[row][col]=='1'){
                    islandCounter++;
                    bfs(grid, row, col);
                }
            }
        }

    return islandCounter;
    }

    private void bfs(char[][] grid, int row, int col){
        int rows = grid.length, cols = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curRow = current[0], curCol = current[1];
            for(int[]dir: DIR){
                int newRow = curRow + dir[0], newCol = curCol + dir[1];

                if(newRow<0||newRow>= rows || newCol<0 || newCol>= cols) continue;
                if(grid[newRow][newCol]!='1') continue;
                queue.offer(new int[]{newRow, newCol});
                grid[newRow][newCol] = '0';
                
            }
        }

    }
}
