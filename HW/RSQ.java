import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class RSQ{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[] arr=new int[n];
        while(q-- > 0){
            int type=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            if(type==1){
                arr[l-1]=r;
            }else{
                int sum=0;
                for(int i=l-1;i<=r-1;i++){
                    sum+=arr[i];
                }
                System.out.println(sum);
            }
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}