package Graph;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class FlightRoute{
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        int[] parent=new int[n+1];
        Arrays.fill(parent,-1);
        int[] indegree=new int[n+1];
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int v: adj.get(temp)){
                if(dp[temp]>0 && 1+dp[temp]>dp[v]){
                    dp[v]=1+dp[temp];
                    parent[v]=temp;
                }
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }

        if (dp[n] == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> res=new ArrayList<>();
        for(int i= n;i!=-1;i=parent[i]){
            res.add(i);
        }
        Collections.reverse(res);
        bw.write(String.valueOf(res.size()));
        bw.newLine();
        for (int x : res) {
            bw.write(x+" ");
        }
        bw.newLine();
        bw.flush();

    }
    // public static int  dfs(int r,ArrayList<ArrayList<Integer>> adj){
    //     if(r==n){
    //         return 1;
    //     }
    //     if(dp[r]!=null){
    //         return dp[r];
    //     }
    //     int max=-1;
    //     for(int v: adj.get(r)){
    //         int val=1+dfs(v,adj);
    //         if(val != -1 && val>max){
    //             max = val;
    //             parent[r] = v;
    //         }
             
    //     }
    //     return dp[r]=max;
    // }
}