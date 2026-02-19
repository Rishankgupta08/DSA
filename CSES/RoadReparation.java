import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class RoadReparation{
    static class Edges{
        int u;
        int v;
        long w;
        Edges(int u,int v,long w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    public static void main(String[] args) throws IOException{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        long sum=0;
        int[] rank= new int[n+1];
        ArrayList<Edges> ad=  new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Long.parseLong(st.nextToken());
            ad.add(new Edges(u, v, w));
        }
        Collections.sort(ad,(a,b)->Long.compare(a.w, b.w));
        int count=0;
        for(Edges e: ad){
            if(union(e.u,e.v,parent,rank)){
                sum+=e.w;
                count++;
            }
        }
        if(count!=n-1){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(sum);
        }
    }
    public static boolean union(int x,int y, int[] parent,int[] rank){
        int p_x=find(x,parent);
        int p_y=find(y,parent);
        if(p_x==p_y) return false;
        if(rank[p_x]<rank[p_y]){
            parent[p_x]=p_y;
        }else  if(rank[p_x]>rank[p_y]){
            parent[p_y]=p_x;
        }else{
            parent[p_x]=p_y;
            rank[p_y]++;
        }
        return true;
    }
    public static int find(int x, int[] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x],parent);
    }
}