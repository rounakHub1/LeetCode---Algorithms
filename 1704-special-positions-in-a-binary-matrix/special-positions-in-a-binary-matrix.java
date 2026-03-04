class Solution {
    private int m, n;
    private int[][] mat;
    private boolean isSpecial(int cm, int cn) {

        for(int i=0; i<m; i++) {
            if(i != cm && mat[i][cn] == 1) return false;
        }
        for(int j=0; j<n; j++) {
            if(j != cn && mat[cm][j] == 1) return false;
        } return true;
    }
    public int numSpecial(int[][] mat) {

        this.m = mat.length;
        this.n = mat[0].length;
        this.mat = mat;

        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1 && isSpecial(i, j)) count++;
            }
        } return count;
    }
}