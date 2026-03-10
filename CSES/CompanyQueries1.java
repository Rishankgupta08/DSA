import java.io.DataInputStream;
// import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CompanyQueries1 {
    static int N = 200005;
    static int log = 20;
    static int[][] up = new int[N][log];

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        
        for (int i = 2; i <= n; i++) {
            parent[i] = sc.nextInt();
        }
        
        for (int i = 0; i <= n; i++) {
            Arrays.fill(up[i], -1);
        }
        
        for (int i = 1; i <= n; i++) {
            up[i][0] = parent[i];
        }
        
        for (int i = 1; i < log; i++) {
            for (int node = 1; node <= n; node++) {
                if (up[node][i - 1] != -1)
                    up[node][i] = up[up[node][i - 1]][i - 1];
                else
                    up[node][i] = -1;
            }
        }

        for (int i = 0; i < k; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            out.println(lift(u, v));
        }
        
        // Don't forget to flush the PrintWriter!
        out.flush();
        out.close();
    }
    
    private static int lift(int node, int k) {
        for (int i = log - 1; i >= 0; i--) {
            if ((k & (1 << i)) != 0) {
                node = up[node][i];
                if (node == -1) return -1;
            }
        }
        return node;
    }

    // Custom Fast Reader to prevent Runtime Errors from bad spacing
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}