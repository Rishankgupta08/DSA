import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class CompanyQueries2{
    static int N=200005;
    static int log=20;
    static int[] depth=new int[N];
    static int[][] up=new int[N][log];
    static ArrayList<Integer>[] tree=new ArrayList[N];
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int[] par=new int[n+1];
        Arrays.fill(par,-1);
        for(int i=1;i<=n;i++){
            tree[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine());
        for(int i=2;i<=n;i++){
            par[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=2;i<=n;i++){
            tree[par[i]].add(i);
        }
        for(int i=1;i<=n;i++){
            up[i][0]=par[i];
        }
        dfs(1,-1);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(LCA(u,v)) +"\n");
        }
        bw.flush();

    } 
    private static void dfs(int node,int par){
        for(int i=1;i<log;i++){
            if(up[node][i-1]!=-1){
                up[node][i]=up[up[node][i-1]][i-1];
            }else{
                up[node][i]=-1;
            }
        }
        for(int v: tree[node]){
            if(v==par){
                continue;
            }
            depth[v]=1+depth[node];
            dfs(v,node);
        }
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
    public  static int lift(int node,int k){
        for(int i=log-1;i>=0;i--){
            if((k & (1<<i)) != 0){
                node=up[node][i];
                if(node==-1) return -1;
            }
        }
        return node;
    }

}