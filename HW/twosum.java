import java.util.*;
import java.io.*;
public class twosum{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[]a =new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int target=x-a[i];
            if(hm.containsKey(target)){
                System.out.println(hm.get(target)+" "+(i+1));
                return;
            }
            hm.put(a[i],i+1);
        }
        System.out.println("IMPOSSIBLE");
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
