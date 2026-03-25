package HWI;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

class HWI2_1{
    public static void main(String[] args) throws IOException{
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        int q=sc.nextInt();
        

    }

    static class FastScanner {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        FastScanner(InputStream is) {
            din = new DataInputStream(is);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, 0, BUFFER_SIZE);
                bufferPointer = 0;
            }
            return buffer[bufferPointer++];
        }

        int nextInt() throws IOException {
            int ret = 0;
            byte b = read();
            while (b <= ' ') b = read();
            boolean neg = (b == '-');
            if (neg) b = read();
            while (b >= '0' && b <= '9') {
                ret = ret * 10 + (b - '0');
                b = read();
            }
            return neg ? -ret : ret;
        }

        long nextLong() throws IOException {
            long ret = 0;
            byte b = read();
            while (b <= ' ') b = read();
            boolean neg = (b == '-');
            if (neg) b = read();
            while (b >= '0' && b <= '9') {
                ret = ret * 10 + (b - '0');
                b = read();
            }
            return neg ? -ret : ret;
        }
    }
}