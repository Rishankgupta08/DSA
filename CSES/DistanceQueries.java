// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.util.ArrayList;
// import java.util.StringTokenizer;

// class DistanceQueries{
//     static int N=200005;
//     static int log=20;
//     static int[][] up=new int[N][log];
//     static int[] depth=new int[N];
//     static ArrayList<Integer>[] tree=new ArrayList[N];
//     public static void main(String[] args)throws Exception {
//         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st=new StringTokenizer(br.readLine());
//         int n=Integer.parseInt(st.nextToken());
//         int q=Integer.parseInt(st.nextToken());
//         for(int i=1;i<=n;i++){
//             tree[i]=new ArrayList<>();
//         }
//         for(int i=0;i<n-1;i++){
//             st=new StringTokenizer(br.readLine());
//             int u=Integer.parseInt(st.nextToken());
//             int v=Integer.parseInt(st.nextToken());
//             tree[u].add(v);
//             tree[v].add(u);
//         }
//         for(int i=0;i<N;i++){
//             for(int j=0;j<log;j++){
//                 up[i][j]=-1;
//             }
//         }
//         dfs(1,-1);
//         BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
//         for(int i=0;i<q;i++){
//             st=new StringTokenizer(br.readLine());
//             int u=Integer.parseInt(st.nextToken());
//             int v=Integer.parseInt(st.nextToken());
//             bw.write(String.valueOf(distance(u,v))+ "\n");
//         }
//         bw.flush();
//     }
//     private static void dfs(int node,int par){
//         up[node][0]=par;
//         for(int i=1;i<log;i++){
//             if(up[node][i-1]!=-1){
//                 up[node][i]=up[up[node][i-1]][i-1];
//             }
//         }
//         for(int v: tree[node]){
//             if(v==par) continue;
//             depth[v]=1+depth[node];
//             dfs(v,node);
//         }
//     }
//     public static int lift(int node,int k){
//         for(int i=log-1;i>=0;i--){
//             if((k& (1<<i)) !=0){
//                 node=up[node][i];
//             }
//             if(node==-1) return -1;
//         }
//         return node;
//     }
//     public static int LCA(int a,int b){
//         if(depth[a]<depth[b]){
//             int temp=a;
//             a=b;
//             b=temp;
//         }
//         int diff=depth[a]-depth[b];
//         a=lift(a,diff);
//         if(a==b) return a;
//         for(int i=log-1;i>=0;i--){
//             if(up[a][i]!=up[b][i]){
//                 a=up[a][i];
//                 b=up[b][i];
//             }
//         }
//         return up[a][0];
//     }
//     public static int distance(int a,int b){
//         return depth[a]+depth[b]-2*depth[LCA(a,b)];
//     }
// }

import java.io.*;
import java.util.ArrayList;

class DistanceQueries {
    static int N = 200005;
    static int LOG = 20;
    static int[][] up = new int[N][LOG];
    static int[] depth = new int[N];
    static ArrayList<Integer>[] tree = new ArrayList[N];

    // ─── Fast Reader ───────────────────────────────────────────────
    static final int BUFFER_SIZE = 1 << 16;
    static DataInputStream din = new DataInputStream(System.in);
    static byte[] buffer = new byte[BUFFER_SIZE];
    static int bufferPointer = 0, bytesRead = 0;

    static int readByte() throws IOException {
        if (bufferPointer == bytesRead) {
            bytesRead = din.read(buffer, 0, BUFFER_SIZE);
            bufferPointer = 0;
        }
        return (bytesRead == -1) ? -1 : buffer[bufferPointer++];
    }

    static int nextInt() throws IOException {
        int ret = 0;
        int b = readByte();
        while (b < '0' || b > '9') b = readByte();
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = readByte();
        }
        return ret;
    }
    // ───────────────────────────────────────────────────────────────

    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int q = nextInt();

        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        // initialize up[][] to -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < LOG; j++) {
                up[i][j] = -1;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int u = nextInt();
            int v = nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        // ─── Iterative BFS (no recursion → no StackOverflow) ──────
        int[] queue = new int[n + 1];
        int head = 0, tail = 0;
        queue[tail++] = 1;
        depth[1] = 0;
        up[1][0] = -1;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (head < tail) {
            int node = queue[head++];

            // build binary lifting for this node
            for (int i = 1; i < LOG; i++) {
                up[node][i] = (up[node][i - 1] != -1) ? up[up[node][i - 1]][i - 1] : -1;
            }

            for (int v : tree[node]) {
                if (visited[v]) continue;
                visited[v] = true;
                up[v][0] = node;
                depth[v] = depth[node] + 1;
                queue[tail++] = v;
            }
        }
        // ──────────────────────────────────────────────────────────

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = nextInt();
            int v = nextInt();
            sb.append(distance(u, v)).append('\n');
        }

        out.print(sb);
        out.flush();
    }

    public static int lift(int node, int k) {
        for (int i = LOG - 1; i >= 0; i--) {
            if ((k & (1 << i)) != 0) {
                node = up[node][i];
                if (node == -1) return -1;
            }
        }
        return node;
    }

    public static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a; a = b; b = temp;
        }
        a = lift(a, depth[a] - depth[b]);
        if (a == b) return a;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[a][i] != up[b][i]) {
                a = up[a][i];
                b = up[b][i];
            }
        }
        return up[a][0];
    }

    public static int distance(int a, int b) {
        return depth[a] + depth[b] - 2 * depth[LCA(a, b)];
    }
}