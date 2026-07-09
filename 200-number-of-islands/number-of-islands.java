class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                count++;
                DFS(grid, i, j);
                }

            }
        }
        return count;
    }
    public void DFS(char[][] grid, int i, int j){
        if( i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        
        DFS(grid, i+1, j); 
        DFS(grid, i-1, j); 
        DFS(grid, i, j+1); 
        DFS(grid, i, j-1); 
    }
}