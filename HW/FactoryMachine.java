// import java.io.BufferedReader;
import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;
// import java.util.Arrays;
// import java.io.*;

public class FactoryMachine{
    public static void main(String[] args)throws Exception{
        FastScanner sc=new FastScanner();
        int n=sc.nextInt();
        long t=sc.nextLong();
        long[] arr=new long[n];
        long min=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
            min=Math.min(min,arr[i]);
        }
        long i=0;
        long j=min*t;
        while(i < j){
            long mid=i+(j-i)/2;
            long prod=0;
            for(int k=0;k<n;k++){
                prod+=mid/arr[k];
                if(prod>=t){
                    break;
                }
            }
            if(prod>=t){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        System.out.println(i);
    }
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = System.in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') ;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}