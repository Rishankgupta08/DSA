import java.util.LinkedList;
import java.util.Queue;
class wallsGates{
    static int n;
    static int m;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    int max=0;
    static class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public static void main(String[] args){
        int grid[][]={{Integer.MAX_VALUE-1,-1,0,Integer.MAX_VALUE-1},
                      {Integer.MAX_VALUE-1,Integer.MAX_VALUE-1,Integer.MAX_VALUE-1,-1},
                      {Integer.MAX_VALUE-1,-1,Integer.MAX_VALUE-1,-1},
                      {0,-1,Integer.MAX_VALUE-1,Integer.MAX_VALUE-1}};
        wall(grid);
    }
    public static void wall(int[][] grid){
        n=grid.length;
        m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new Pair(i,j,1));
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int d=curr.dist;
            for(int i=0;i<4;i++){
                int nR=r+dr[i];
                int nC=c+dc[i];
                if(nR>=0 && nC>=0 && nR<n && nC<m && grid[nR][nC]==Integer.MAX_VALUE-1){
                    grid[nR][nC]=d;
                    q.offer(new Pair(nR,nC,d+1));
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}