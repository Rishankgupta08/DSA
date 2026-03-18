// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// class PlanetQueries{
//     static int N=200005;
//     static int log=30;
//     static int[][] up=new int[N][log];
//     public static void main(String[] args)throws Exception {
//         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st=new StringTokenizer(br.readLine());
//         int n=Integer.parseInt(st.nextToken());
//         int q=Integer.parseInt(st.nextToken());
//         int [] teleport=new int[n+1];
//         st=new StringTokenizer(br.readLine());
//         Arrays.fill(teleport,-1);

//         for(int i=1;i<=n;i++){
//             teleport[i]=Integer.parseInt(st.nextToken());
//         }
//         for(int i=0;i<N;i++){
//             for(int j=0;j<log;j++){
//                 up[i][j]=-1;
//             }
//         }
//         for(int i=1;i<=n;i++){
//             up[i][0]=teleport[i];
//         }
//         for(int i=1;i<log;i++){
//             for(int node=1;node<=n;node++){
//                 if(up[node][i-1]!=0){
//                     up[node][i]=up[up[node][i-1]][i-1];
//                 }else{
//                     up[node][i]=-1;
//                 }
//             }
//         }
//         BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
//         for(int i=0;i<q;i++){
//             st=new StringTokenizer(br.readLine());
//             int u=Integer.parseInt(st.nextToken());
//             int v=Integer.parseInt(st.nextToken());
//             bw.write(String.valueOf(lift(u,v))+ "\n");
//         }
//         bw.flush();
//     }
//     public static int lift(int node,int k){
//         for(int i=log-1;i>=0;i--){
//             if((k & (1<<i)) !=0){
//                 node=up[node][i];
//                 if(node == -1) return -1;
//             }
//         }
//         return node;
//     }
// }

import java.io.*;

class PlanetQueries {
    static int N = 200005;
    static int LOG = 30;
    static int[][] up = new int[N][LOG];

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

        // initialize up[][] to -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < LOG; j++) {
                up[i][j] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            up[i][0] = nextInt();  // direct teleport destination
        }

        // build binary lifting table iteratively
        for (int i = 1; i < LOG; i++) {
            for (int node = 1; node <= n; node++) {
                up[node][i] = (up[node][i - 1] != -1) ? up[up[node][i - 1]][i - 1] : -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = nextInt();
            int k = nextInt();
            sb.append(lift(u, k)).append('\n');
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
}