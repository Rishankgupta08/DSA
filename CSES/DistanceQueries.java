import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class DistanceQueries{
    static int N=200005;
    static int log=20;
    static int[][] up=new int[N][log];
    static int[] depth=new int[N];
    static ArrayList<Integer>[] tree=new ArrayList[N];
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<log;j++){
                up[i][j]=-1;
            }
        }
        dfs(1,-1);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(distance(u,v))+ "\n");
        }
        bw.flush();
    }
    private static void dfs(int node,int par){
        up[node][0]=par;
        for(int i=1;i<log;i++){
            if(up[node][i-1]!=-1){
                up[node][i]=up[up[node][i-1]][i-1];
            }
        }
        for(int v: tree[node]){
            if(v==par) continue;
            depth[v]=1+depth[node];
            dfs(v,node);
        }
    }
    public static int lift(int node,int k){
        for(int i=log-1;i>=0;i--){
            if((k& (1<<i)) !=0){
                node=up[node][i];
            }
            if(node==-1) return -1;
        }
        return node;
    }
    public static int LCA(int a,int b){
        if(depth[a]<depth[b]){
            int temp=a;
            a=b;
            b=temp;
        }
        int diff=depth[a]-depth[b];
        a=lift(a,diff);
        if(a==b) return a;
        for(int i=log-1;i>=0;i--){
            if(up[a][i]!=up[b][i]){
                a=up[a][i];
                b=up[b][i];
            }
        }
        return up[a][0];
    }
    public static int distance(int a,int b){
        return depth[a]+depth[b]-2*depth[LCA(a,b)];
    }
}