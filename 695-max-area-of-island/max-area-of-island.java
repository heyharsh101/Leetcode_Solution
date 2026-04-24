class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[row][cols];

        int max = 0;
        for(int i=0;i <row; i++){
            for(int j=0; j<cols; j++){
                if(!vis[i][j]){
                    vis[i][j] = true;
                    int area = DFS(grid, i, j);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }
    public int DFS(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0;
        int area = 1;

        area += DFS(grid, i+1, j);
        area += DFS(grid, i-1, j);
        area += DFS(grid, i, j+1);
        area += DFS(grid, i, j-1);

        return area;
    }
}