import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class StringGame{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        String p=sc.next();
        String t=sc.next();
         int n=p.length();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
       
        int count=0;
        StringBuilder sb=new StringBuilder(p);
        for(int i=0;i<n;i++){
            if(match(p,t)){
                sb.deleteCharAt(arr[i]-1);
                count++;
            }else{
                break;
            }
        }
        System.out.println(count);
    }
    public static boolean match(String p,String t){
        return false;
        
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