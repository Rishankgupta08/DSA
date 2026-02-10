import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BuildingRoads{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int ed=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<ed;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[n+1];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                ans.add(i);
                dfs(i,vis,adj);
            }
        }
        System.out.println(ans.size()-1);
        for(int i=0;i<ans.size()-1;i++){
            System.out.println (ans.get(i)+" "+ans.get(i+1));
        }
    }
    public static void dfs(int src,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        for(int v: adj.get(src)){
            if(!vis[v]){
                dfs(v,vis,adj);
            }
        }
    }
}