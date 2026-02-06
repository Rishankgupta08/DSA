import java.util.Queue;
// import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Labyrinth{
    static int n;
    static int m;
    static int[][] parentX;
    static int[][] parentY;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static char[] directions={'U','D','L','R'};
    static class Pair{
        int rL;
        int cL;
        Pair(int rL,int cL){
            this.rL=rL;
            this.cL=cL;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++) grid[i] = br.readLine().toCharArray();
        parentX=new int[n][m];
        parentY=new int[n][m];
        char[][] dir=new char[n][m];
        int sR=0;
        int sC=0;
        int er=0;
        int ec=0;
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='A'){
                    sR=i;
                    sC=j;
                    grid[i][j] = 'V'; 
                    q.offer(new Pair(i, j));
                }else if(grid[i][j]=='B'){
                    er=i;
                    ec=j;
                }
            }
        }
        boolean found=false;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.rL;
            int c=curr.cL;
            if(r==er && c==ec){
                found=true;
                break;
            }
            for(int i=0;i<4;i++){
                int nR=r+dr[i];
                int nC=c+dc[i];
                if(nR>=0 && nC>=0 && nR<n && nC<m && (grid[nR][nC]=='.' || grid[nR][nC]=='B')){
                    if(grid[nR][nC]=='.' || grid[nR][nC]=='B'){
                        grid[nR][nC]='V';
                    }
                    parentX[nR][nC]=r;
                    parentY[nR][nC]=c;
                    dir[nR][nC]=directions[i];
                    q.offer(new Pair(nR, nC));
                }   
            }
        }
        if(!found){
            System.out.println("NO");
            return;
        }
        StringBuilder sb=new StringBuilder();
        int r=er;
        int c=ec;
        while(r!=sR || c !=sC){
            sb.append(dir[r][c]);
            int pX = parentX[r][c];
            int pY = parentY[r][c];
            r = pX;
            c = pY;
        }
        System.out.println("YES");
        System.out.println(sb.length());
        System.out.println(sb.reverse().toString());
    }
}