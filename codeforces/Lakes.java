import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
public class Lakes{
    static int n;
    static int m;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-- > 0){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            int[][] grid=new int[n][m];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<m;j++){
                    grid[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            long max=0;
            boolean[][] vis=new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]>0 && !vis[i][j]){
                        max=Math.max(max,bfs(i, j, vis, grid));
                    }
                }
            }
            System.out.println(max);
            
        }
    }
    public static long bfs(int r,int c, boolean[][] vis, int[][] grid){
        Queue<Pair> q=new LinkedList<>();
        long sum=0;
        vis[r][c]=true;
        q.offer(new Pair(r,c));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int R=curr.row;
            int C=curr.col;
            sum+=grid[R][C];
            for(int i=0;i<4;i++){
                int nR=R+dr[i];
                int nC=C+dc[i];

                if(nR >=0 && nC>=0 && nR<n && nC<m && !vis[nR][nC] && grid[nR][nC]>0){
                    vis[nR][nC]=true;
                    q.offer(new Pair(nR,nC));
                }
            }
        }
        return sum;
    }
}