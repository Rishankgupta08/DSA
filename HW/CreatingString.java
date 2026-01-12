import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CreatingString{
    public static void main(String[] args){
        FastScanner sc=new FastScanner(System.in);
        String s=sc.next();
        List<String> res=new ArrayList<>();
        char[] str=s.toCharArray();
        boolean[] visit=new boolean[str.length];
        StringBuilder curr=new StringBuilder();
        Arrays.sort(str);
        printperm(str,visit,curr,res);
        System.out.println(res.size());
        for(String i: res){
            System.out.println(i);
        }
    }
    public static void printperm(char[] str, boolean[] visit, StringBuilder curr, List<String> res) {
        if(curr.length()==str.length){
            res.add(curr.toString());
            return;
        }
        for(int i=0;i<str.length;i++){
            if(visit[i]){
                continue;
            }
            if(i>0 && str[i]==str[i-1] && !visit[i-1]){
                continue;
            }
            visit[i]=true;
            curr.append(str[i]);
            printperm(str, visit, curr, res);
            curr.deleteCharAt(curr.length() - 1);
            visit[i]=false;
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
