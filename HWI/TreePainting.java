// package HWI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreePainting{
    static long[] dist;
    static long[] subtree;
    static long[] ans;
    static long N;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        subtree=new long[n+1];
        dist=new long[n+1];
        ans=new long[n+1];
        N=n;
        tree=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1,-1);
        ans[1]=dist[1];
        reRoot(1,-1);
        long max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            max=Math.max(max,ans[i]);
        }
        System.out.println(max+n);
    }
    public static void dfs(int src,int par){
        subtree[src]=1;
        for(int v: tree[src]){
            if(v==par) continue;
            dfs(v,src);
            subtree[src]+=subtree[v];
            dist[src]+=dist[v]+subtree[v];
        }
    }
    public static void reRoot(int src,int par){
        for(int v: tree[src]){
            if(v==par) continue;
            ans[v]=ans[src]+N-2*subtree[v];
            reRoot(v,src);
        }
    }
}