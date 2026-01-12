import java.io.*;
import java.util.*;

class LPS {
    public static void main(String[] args) {
        FastScanner sc=new FastScanner();
        String s=sc.next();

        int n=s.length();
        char[] str=new char[2*n+1];
        int j=0;
        str[j++]='#';
        for(char c:s.toCharArray()){
            str[j++]=c;
            str[j++]='#';
        }

        int[] p=new int[2*n+1];
        int centre=0;
        int right=0;
        int longcentre=0;
        int longlen=0;
        for(int i=0;i<str.length;i++){
            int mirror=2*centre - i;
            if(right > i){
                p[i]=Math.min(p[mirror],right-i);
            }
            int a=i+(p[i]+1);
            int b=i-(p[i]+1);
            while(b>=0 && a<str.length && str[a]==str[b]){
                b--;
                a++;
                p[i]++;
            }
            if(p[i]>=longlen){
                longcentre=i;
                longlen=p[i];
            }
            if(i+p[i]>right){
                centre=i;
                right=i+p[i];
            }
        }
        String st=new String(str);
        System.out.println(st.substring(longcentre-longlen,longcentre+longlen).replace("#",""));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (Exception e) { return null; }
            }
            return st.nextToken();
        }
    }
}
