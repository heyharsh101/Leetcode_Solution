class Solution {
    int n, m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        n = image.length; 
        m = image[0].length;
        if(oldcolor == color) return image;

        Fillnew(image, sr, sc, oldcolor, color);
        return image;
    }
    public void Fillnew(int[][] image, int r, int c, int oldcolor, int newcolor){
        if(r<0 || c<0 || r>=n || c>=m) return;
        if(image[r][c] != oldcolor) return;

        image[r][c] = newcolor;

        Fillnew(image, r-1, c, oldcolor, newcolor);
        Fillnew(image, r+1, c, oldcolor, newcolor);
        Fillnew(image, r, c+1, oldcolor, newcolor);
        Fillnew(image, r, c-1, oldcolor, newcolor);
    }
}