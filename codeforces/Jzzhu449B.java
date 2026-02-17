import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jzzhu449B{
    static class Pair{
        int sr;
        long dist;
        Pair(int sr,long dist){
            this.sr=sr;
            this.dist=dist;
        }
    }
    static class State{
        int sr;
        long dist;
        int state;
        State(int sr,long dist,int state){
            this.sr=sr;
            this.dist=dist;
            this.state=state;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        long k=Long.parseLong(st.nextToken());
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Long.parseLong(st.nextToken());

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        long[] dis= new long[n+1];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[1]=0; 
        int remove=0;
        PriorityQueue<State> pq=new PriorityQueue<>((a,b) -> Long.compare(a.dist, b.dist));
        pq.offer(new State(1,0,0));
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            long y=Long.parseLong(st.nextToken());
            pq.offer(new State(x, y, 1));
        }
        boolean[] vis=new boolean[n+1];
        while(!pq.isEmpty()){
            State curr=pq.poll();
            int r=curr.sr;
            long d=curr.dist;
            int flag=curr.state;
            if(d>=dis[r] && flag==1) {
                remove++;
                continue;
            }else if(dis[r]> d && flag == 1){
                dis[r]=d;
            }
            if(vis[r]) continue;
            vis[r]=true;
            if(d > dis[r]) continue;

            for(Pair p: adj.get(r)){
                int v=p.sr;
                long cost=p.dist;
                if(dis[v]>cost+dis[r]){
                    dis[v]=cost+dis[r];
                    pq.offer(new State(v, dis[v], 0));
                }
            }
        }
        System.out.println(remove);
    }
}