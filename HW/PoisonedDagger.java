import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PoisonedDagger{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            long h=sc.nextLong();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            long low=1;
            long high=h;
            long ans=h;
            while(low<=high){
                long mid=low+(high-low)/2;
                long damage=0;
                for(int i=0;i<n-1;i++){
                    int gap=arr[i+1]-arr[i];
                    damage+=Math.min(mid,gap);
                }
                damage+=mid;

                if(damage>=h){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            System.out.println(ans);
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