class Solution {

     private static int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};   
        private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length ==0 || heights[0].length==0) return new ArrayList<List<Integer>>();
        this.heights = heights;

        int rows =  heights.length , cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int c=0; c< cols; c++){
            dfs(0,c, pacific);
        }
        for(int r =0; r<rows; r++){
            dfs(r,0,pacific);
        }

        for(int c=0; c< cols; c++){
            dfs(rows-1,c, atlantic);
        }
        for(int r =0; r<rows; r++){
            dfs(r,cols-1,atlantic);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }

            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] ocean){
         int rows = heights.length , cols = heights[0].length;
            ocean[row][col] = true;

            for(int[]dir:DIR){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr<0 ||nr>= rows || nc<0||nc>=cols) continue;
                if(ocean[nr][nc]) continue;

                if(heights[nr][nc]>=heights[row][col]){
                    dfs(nr,nc,ocean);
                }

            }
    }
}
