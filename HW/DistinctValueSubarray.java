import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class DistinctValueSubarray{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        int left=0;
        long total=0;
        HashSet<Long> hs=new HashSet<>();
        for(int right=0;right<n;right++){
            while(hs.contains(arr[right])){
                hs.remove(arr[left]);
                left++;
            }
            hs.add(arr[right]);
            total+=right-left+1;
        }
        System.out.println(total);
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