import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class monster{
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static char[] directions={'U','D','L','R'};
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        char[][] grid=new char[n][m];
        for(int i=0;i<n;i++){
            grid[i]=br.readLine().toCharArray();
        }
        // boolean[][] vis=new boolean[n][m];
        int[][] mnstime=new int[n][m];
        for (int[] row : mnstime)
            Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='M'){
                    q.offer(new int[]{i,j});
                    mnstime[i][j]=0;
                }
            }
        }
        System.out.println("true");
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int i=0;i<4;i++){
                int nR=r+dr[i];
                int nC=c+dc[i];
                if(nR>=0 && nC>=0 && nR<n && nC<m && grid[nR][nC]=='.' && grid[nR][nC]!='#' && mnstime[nR][nC]>mnstime[r][c]+1){
                    mnstime[nR][nC]=mnstime[r][c]+1;
                    q.offer(new int[]{nR,nC});
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mnstime[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}