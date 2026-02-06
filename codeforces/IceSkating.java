import java.util.ArrayList;
import java.util.Scanner;

public class IceSkating{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] edges=new int[n][2];
        for(int i=0;i<n;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edges[i][0]==edges[j][0] || edges[i][1]==edges[j][1]){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,adj);
                count++;
            }
        }
        System.out.println(count-1);
    }

    private static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i]=true;
        for(int v: adj.get(i)){
            if(!visited[v]){
                dfs(v, visited, adj);
            }
        }
    }
}