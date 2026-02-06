import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import java.util.Scanner;
import java.util.StringTokenizer;

public class Party{
    static int ans=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            if(arr[i]!=-1){
                adj.get(arr[i]).add(i);
            }
        }

        for(int i=1;i<=n;i++){
            if(arr[i]==-1){
                dfs(i,adj,1);
            }
        }
        System.out.println(ans);
        
    }

    private static void dfs(int r, ArrayList<ArrayList<Integer>> adj, int count) {
        ans=Math.max(ans,count);
        for(int v: adj.get(r)){
            dfs(v,adj,count+1);
        }
    }
}