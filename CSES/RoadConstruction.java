import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
// import java.util.HashMap;
// import java.io.OutputStreamWriter;
// import java.util.ArrayList;
import java.util.StringTokenizer;

class RoadConstruction{
    static long comp;
    static long max;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int  n=Integer.parseInt(st.nextToken());
        int  ed=Integer.parseInt(st.nextToken());
        long[][] ans=new long[ed][2];
        int[] parent=new int[n+1];
        for(int j=1;j<=n;j++){
            parent[j]=j;
        }
        comp=n;
        long[] size =new long[n+1];
        Arrays.fill(size,1);
        max=1;
        for(int i=0;i<ed;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            
            union(u,v,parent,size);

            ans[i][0]=comp;
            ans[i][1]=max;
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<ed;i++){
            bw.write(String.valueOf(ans[i][0])+" "+String.valueOf(ans[i][1])+"\n");
        }
        bw.flush();


    }
    public static void union(int x,int y,int[] parent,long[] size){
        int px=find(x,parent);
        int py=find(y,parent);
        if(px==py) return;
        if(size[px]>size[py]){
            int temp=px;
            px=py;
            py=temp;
        }
        parent[py]=px;
        size[px]+=size[py];
        comp--;
        max=Math.max(max,size[px]);
        return;
    }
    public static int find(int x,int[] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x],parent);
    }
}