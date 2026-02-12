import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class ShortestRoute1{
    static class Pair{
        int sr;
        long dist;
        public Pair(int sr,long dist){
            this.sr=sr;
            this.dist=dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Long.parseLong(st.nextToken());;
            adj.get(u).add(new Pair(v,w));
        }
        long[] dis=new long[n+1];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[1]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.dist,b.dist));
        pq.offer(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int r=p.sr;
            long d=p.dist;
            if(d>dis[r]){   //Most IMPORTANT Line (DECREASE KEY via LAZY DELETION)
                 continue;
            }
            for(Pair curr: adj.get(r)){
                int v=curr.sr;
                Long costU_V=curr.dist;
                if(dis[v]>dis[r]+costU_V){
                    dis[v]=dis[r]+costU_V;
                    pq.offer(new Pair(v,dis[v]));
                }
            }
        }
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=n;i++){
            bw.write(dis[i]+" ");
        }
        bw.flush();
    }
}