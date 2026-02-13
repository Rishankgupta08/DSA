import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
// import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class MessageRoute {
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
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        long[] dis=new long[n+1];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[1]=0;

        int[] parent=new int[n+1];
        Arrays.fill(parent,-1);

        long[] dp=new long[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=1;

        // long min[]=new long[n+1];
        //  Arrays.fill(min,Long.MAX_VALUE);
        // min[1]=0;

        // long max[]=new long[n+1];
        //  Arrays.fill(max,Long.MIN_VALUE);
        // max[1]=0;
        boolean[] vis=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int temp=q.poll();
            vis[temp]=true;
            for(int v: adj.get(temp)){
                if(!vis[v] & dp[v]>1+dp[temp]){
                    q.offer(v);
                    dp[v]=1+dp[temp];
                    parent[v]=temp;
                }
            }
        }
        for(int i=0;i<=n;i++){
            if(dp[i]==Integer.MAX_VALUE){
                dp[i]=-1;
            }
        }
        // for(int i=0;i<=n;i++){
        //     System.out.print(dp[i]+" ");
        // }
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=n;i!=-1;i=parent[i]){
            ans.add(i);
        }
        Collections.reverse(ans);
        if(dp[n]==-1){
            System.out.println("IMPOSSIBLE");
            return;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(dp[n]+" \n"));
        for(int i: ans){
            bw.write(String.valueOf(i+" "));
        }
        bw.flush();
    }
}