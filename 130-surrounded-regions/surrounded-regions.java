class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int cols = board[0].length;

        for(int i=0; i<row; i++){
            DFS(board, i, 0);
            DFS(board, i, cols-1);
        }
        for(int j=0; j<cols; j++){
            DFS(board, 0, j);
            DFS(board, row -1, j);
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    public void DFS(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return;
        }
        if(board[i][j] != 'O')
            return;
        
        board[i][j] = '#';

        DFS(board, i+1, j);
        DFS(board, i-1, j);
        DFS(board, i, j+1);
        DFS(board, i, j-1);
    }
}