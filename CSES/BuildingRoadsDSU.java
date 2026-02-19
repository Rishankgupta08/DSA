import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BuildingRoadsDSU{
    static int comp;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int ed=Integer.parseInt(st.nextToken());
        int[] parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        comp=n;
        int[] rank=new int[n+1];
        for(int i=0;i<ed;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            if(!union(u,v,parent,rank)){

            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i==parent[i]){
                ans.add(i);
            }
        }
        System.out.println(comp-1);
        for(int i=0;i<ans.size()-1;i++){
            System.out.println (ans.get(i)+" "+ans.get(i+1));
        }

    }
    public static boolean union(int x,int y,int[] parent,int[] rank){
        int px=find(x,parent);
        int py=find(y,parent);
        if(px==py) return false;
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[px]<rank[py]){
            parent[px]=py;
        }else{
            parent[px]=py;
            rank[py]++;
        }
        comp--;
        return true;
    }
    public static int find(int x,int[] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x],parent);
    }
}