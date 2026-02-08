import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Monsters{
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++) grid[i] = br.readLine().toCharArray();

        parentX=new int[n][m];
        parentY=new int[n][m];
        char[][] dir=new char[n][m];
        int[][] MonsterTime=new int[n][m];
        for (int[] row : MonsterTime)
            Arrays.fill(row, Integer.MAX_VALUE);
        int sR=-1;
        int sC=-1;
        Queue<Pair> q= new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    sR = i;
                    sC = j;
                }else if(grid[i][j]=='M'){
                    q.offer(new Pair(i, j));
                    MonsterTime[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.rL;
            int c=curr.cL;
            for(int i=0;i<4;i++){
                int nR=r+dr[i];
                int nC=c+dc[i];
                if(nR>=0 && nC>=0 && nR<n && nC<m && grid[nR][nC]=='.' && grid[nR][nC] != '#' && MonsterTime[nR][nC] > MonsterTime[r][c] + 1){
                    MonsterTime[nR][nC] = MonsterTime[r][c] + 1;
                    q.offer(new Pair(nR, nC));
                }
            }
        }
        
        Queue<Pair> pq=new LinkedList<>();
        int[][] PlayerTime=new int[n][m];
        for (int[] row : PlayerTime)
            Arrays.fill(row, Integer.MAX_VALUE);
        pq.offer(new Pair(sR, sC));
        PlayerTime[sR][sC] = 0;
        int eR=-1;
        int eC=-1;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int r=curr.rL;
            int c=curr.cL;
            if (r == 0 || c == 0 || r == n - 1 || c == m - 1) {
                eR = r;
                eC = c;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
                    grid[nr][nc] != '#' &&
                    PlayerTime[r][c] + 1 < MonsterTime[nr][nc] &&
                    PlayerTime[nr][nc] == Integer.MAX_VALUE) {

                    PlayerTime[nr][nc] = PlayerTime[r][c] + 1;
                    parentX[nr][nc] = r;
                    parentY[nr][nc] = c;
                    dir[nr][nc] = directions[i];
                    pq.offer(new Pair(nr, nc));
                }
            }
        }
        if(eR==-1){
            System.out.println("NO");
            return;
        }
        StringBuilder sb=new StringBuilder();
        int r=eR;
        int c=eC;
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