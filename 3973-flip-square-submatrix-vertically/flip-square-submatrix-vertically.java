class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for(int col = y; col < y + k; col++){
            int top = x;
            int bottom = x + k - 1;

            while(top < bottom){
                swap(grid, top, bottom , col);
                top++;
                bottom--;
            }
        }
        return grid;
    }

    public void swap(int mat[][], int l, int r, int m){
    int temp = mat[l][m];
    mat[l][m] = mat[r][m];
    mat[r][m] = temp;
    }
}