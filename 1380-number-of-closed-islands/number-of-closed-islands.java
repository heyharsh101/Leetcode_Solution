class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;
        int count=0;

        for(int i=0; i<row; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0 && DFS(i, j, grid)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean DFS(int i, int j, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return false;
        }
        if(grid[i][j] == 1){
            return true;
        }
        grid[i][j] = 1;

        boolean left = DFS(i, j-1, grid);
        boolean right = DFS(i, j+1, grid);
        boolean up = DFS(i-1, j, grid);
        boolean down = DFS(i+1, j, grid);

        return left && right && up && down;
    }
}