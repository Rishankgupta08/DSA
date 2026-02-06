package Graph;

class ConnectedCompnentinGrid{
    static int[] dr = {-1,1,0,0}; //! up, down , left right
    static int[] dc = {0,0,-1,1};
    static int row;
    static int col;
    public static void main(String[] args){
        int[][] grid={{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,1,1}};
        row=grid.length;    //*row length
        col=grid[0].length; //*column length
        boolean[][] vis=new boolean[row][col];
        int components=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    dfs(i,j,vis,grid);
                    components++;
                }
            }
        }
        System.out.println(" No. of Components: "+ components);
    }
    private static void dfs(int r, int c, boolean[][] vis, int[][] grid) {
        //*  edge case
        if(r<0 || c<0 || r>=row || c>=col || grid[r][c]==0)
            return;
        if(vis[r][c]==true)
            return;
        vis[r][c]=true;
        // dfs(r-1, c, vis, grid); //*  up
        // dfs(r+1, c, vis, grid); //* down
        // dfs(r, c-1, vis, grid); //* left
        // dfs(r, c+1, vis, grid); //* right
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],vis,grid);
        }
    }
}