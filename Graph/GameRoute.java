package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Arrays;
import java.util.StringTokenizer;

class GameRoute{
    static Long[]dp;
    static int n;
    static int MOD=1_000_000_007;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        dp=new Long[n+1];
        int[] indegree=new int[n+1];
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            indegree[v]++;
        }

        long max=dfs(1,adj);
        if(max==0){
            System.out.println(0);
            return;
        }
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        // Queue<Integer> q=new LinkedList<>();
        // for(int i=1;i<=n;i++){
        //     if(indegree[i]==0){
        //         q.offer(i);
        //     }
        // }
        // while(!q.isEmpty()){
        //     int temp=q.poll();
        //     for(int v: adj.get(temp)){
        //         if(dp[temp]>0 && dp[temp]+dp[v]>dp[v]){
        //             dp[v]=(dp[v]+dp[temp])%MOD;
        //         }
        //         indegree[v]--;
        //         if(indegree[v]==0){
        //             q.offer(v);
        //         }
        //     }
        // }
        // if (dp[n] == 0) {
        //     System.out.println(0);
        //     return;
        // }
        // BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        // bw.write(String.valueOf(dp[n]));
        // bw.flush();
    }
    private static long dfs(int r, ArrayList<ArrayList<Integer>> adj) {
        if(r==n){
            return 1;
        }
        if(dp[r]!=null){
            return dp[r];
        }
        long max=0;
        for(int v: adj.get(r)){
            max=(max+dfs(v,adj))%MOD;
        }
        return dp[r]=max;
    }

}