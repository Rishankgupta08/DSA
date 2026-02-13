import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Investigation {
    static class Pair{
        int sr;
        long dist;
        Pair(int sr,long dist){
            this.sr=sr;
            this.dist=dist;
        }
    }
    static long MOD=1_000_000_007;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Long.parseLong(st.nextToken());
            adj.get(u).add(new Pair(v,w));
        }
        long[] dis=new long[n+1];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[1]=0;

        long[] dp=new long[n+1];
        dp[1]=1;

        long min[]=new long[n+1];
        // Arrays.fill(min,Long.MAX_VALUE);
        min[1]=0;

        long max[]=new long[n+1];
        // Arrays.fill(max,Long.MIN_VALUE);
        max[1]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.dist,b.dist));
        pq.offer(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int r=curr.sr;
            long d=curr.dist;
            if(d>dis[r]) continue;

            for(Pair p: adj.get(r)){
                int v=p.sr;
                long cost=p.dist;

                if(dis[v]>dis[r]+cost){
                    dp[v]=dp[r];
                    dis[v]=dis[r]+cost;
                    min[v]=min[r]+1;
                    max[v]=max[r]+1;
                    pq.offer(new Pair (v,dis[v]));
                }else if(dis[v]==dis[r]+cost){
                    dp[v]=(dp[r]+dp[v])%MOD;
                    max[v]=Math.max(max[v],1+max[r]);
                    min[v]=Math.min(min[v],1+min[r]);
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(dis[n]+" "));
        bw.write(String.valueOf(dp[n]+" "));
        bw.write(String.valueOf(min[n]+" "));
        bw.write(String.valueOf(max[n]+" "));
        bw.flush();
    }
}