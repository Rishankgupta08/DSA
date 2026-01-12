import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class LittleGirlMaxSum{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] freq=new int[n];
        while(q-- > 0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            freq[l-1]++;
            if(r<n){
                freq[r]--;
            }
        }
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }
        Arrays.sort(arr);
        Arrays.sort(freq);
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=1L*arr[i]*freq[i];
        }
        System.out.println(sum);
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