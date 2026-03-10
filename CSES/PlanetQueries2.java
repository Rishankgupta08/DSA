import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class PlanetQueries2{
    static int N=200005;
    static int log=30;
    static int[][] up=new int[N][log];
    static int[] depth=new int[N];
    static ArrayList<Integer>[] tree=new ArrayList[N];
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int [] teleport=new int[n+1];
        st=new StringTokenizer(br.readLine());
        Arrays.fill(teleport,-1);
        for(int i=1;i<=n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=1;i<=n;i++){
            teleport[i]=Integer.parseInt(st.nextToken());
            tree[teleport[i]].add(i);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<log;j++){
                up[i][j]=-1;
            }
        }
        for(int i=1;i<=n;i++){
            up[i][0]=teleport[i];
        }
        dfs(1,-1);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(LCA(u,v))+ "\n");
        }
        bw.flush();
    }
    public static void dfs(int node,int par){
        for(int i=1;i<log;i++){
            if(up[node][i-1]!=0){
                up[node][i]=up[up[node][i-1]][i-1];
            }else{
                up[node][i]=-1;
            }    
            for(int v: tree[node]){
                if(v==par) continue;
                depth[v]=depth[node]+1;
                dfs(v,node);
            }
        }
    }
    public static int lift(int node,int k){
        for(int i=log-1;i>=0;i--){
            if((k & (1<<i)) !=0){
                node=up[node][i];
                if(node == -1) return -1;
            }
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
}