package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class DijkstraWays{
    static class Pair{
        int sr;
        long dis;
        Pair(int sr,long dis){
            this.sr=sr;
            this.dis=dis;
        }
    }
    static int  MOD=1_000_000_007;
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
            adj.get(v).add(new Pair(u,w));
        }
        long [] dist=new long[n+1];
        int[] dp=new int[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        dp[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.dis,b.dis));
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int r=curr.sr;
            long d=curr.dis;
            if(d>dist[r]) continue;
            for(Pair p: adj.get(r)){
                int v=p.sr;
                long cost=p.dis;
                if(dist[v]>cost+dist[r]){
                    dp[v]=dp[r];
                    dist[v]=cost+dist[r];
                    pq.offer(new Pair(v, dist[v]));
                }else if(dist[v]==cost+dist[r]){
                    dp[v]=(dp[v]+dp[r])%MOD;
                }
            }
        }
        for(int i=0;i<=n;i++){
            if(dist[i] == Long.MAX_VALUE)
                System.out.println(-1 + " " + 0);
            else
                System.out.println(dist[i] + " " + dp[i]);
            }
    }
}