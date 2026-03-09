import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.StringTokenizer;

public class StringRotation{
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();

            int cnt=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)!=s.charAt((i+1)%n)){
                    cnt++;
                }
            }
            if(cnt==n){
                System.out.println(cnt);
            }else{
                System.out.println(cnt+1);
            } 
        }
    }
}