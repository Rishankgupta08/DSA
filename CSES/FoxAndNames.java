import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class FoxAndNames{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new  StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        String[] words=new String[n];
        for(int i=0;i<n;i++){
            words[i]=br.readLine();
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[26];
        for(int j=1;j<n;j++){
            String s1=words[j-1];
            String s2=words[j];
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                System.out.println("Impossible");
                return;
            }
            for(int i=0;i<Math.min(s1.length(),s2.length());i++){
                int a=s1.charAt(i);
                int b=s2.charAt(i);
                if(a!=b){
                    int u=a-'a';
                    int v=b-'a';
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                        indegree[v]++;
                    }
                    break;
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();
            ans.add(temp);
            for(int v: adj.get(temp)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        if(ans.size()!=26){
            System.out.println("Impossible");
            return;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ans.size();i++){
            sb.append((char)(ans.get(i)+'a'));
        }
        System.out.println(sb.toString());
    }
}