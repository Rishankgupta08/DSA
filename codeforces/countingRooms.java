import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class countingRooms{
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int n;
    static int m;
    static class Pair{
        int rL;
        int cL;
        Pair(int rL,int cL){
            this.rL=rL;
            this.cL=cL;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        char[][] grid=new char[n][m];
        for(int i=0;i<n;i++){
            grid[i]=br.readLine().toCharArray();
        }
        int count=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='.'){
                    if(!vis[i][j]){
                        bfs(i,j,vis,grid);
                        count++;
                    } 
                }
            }
        }
        System.out.println(count);
    }
    public static void bfs(int r,int c, boolean[][] vis, char[][] grid){
        Queue<Pair> q=new LinkedList<>();
        vis[r][c]=true;
        q.offer(new Pair(r,c));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int R=curr.rL;
            int C=curr.cL;
            for(int i=0;i<4;i++){
                int nR=R+dr[i];
                int nC=C+dc[i];

                if(nR >=0 && nC>=0 && nR<n && nC<m && !vis[nR][nC] && grid[nR][nC]=='.'){
                    vis[nR][nC]=true;
                    q.offer(new Pair(nR,nC));
                }
            }
        }
    }
}