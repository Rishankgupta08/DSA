import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SubArray1{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        long x=sc.nextLong();
        long[] arr=new long[n+1];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        int sum=0;
        int count=0;
        int left=0;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>x && left<=right){
                sum-=arr[left];
                left++;
            }
            if(sum==x){
                count++;
            }
        }
        System.out.println(count);
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