package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph{
    int V;
    ArrayList<ArrayList<Integer>> l;
    Graph(int V){
        this.V=V;
        l=new ArrayList<>(); 
        for(int i = 0; i < V; i++){
            l.add(new ArrayList<>());
        }
    }
    void addEdges(int u, int v){
        l.get(u).add(v);
        l.get(v).add(u);
    }
    void display(){
        for(int i = 0; i < V; i++){
            System.out.print(i + " --> ");
            System.out.println(l.get(i));
        }
    }
    void bfs(){
        Queue<Integer> q= new LinkedList<>();
        boolean[] visited=new boolean[V];
        q.offer(0);
        visited[0]=true;
        while(q.size()>0){
            int u=q.poll();
            System.out.print(u+" ");
            for(int v: l.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    q.offer(v);
                }
            }
        }

    }

    void dfsHelper(int u,boolean[] visited){
        System.out.print(u+" ");
        visited[u]=true;
        for(int v: l.get(u)){
            if(!visited[v]){
                dfsHelper(v,visited);
            }
        }
    }
    void dfs(){
        int src=0;
        boolean[] visited=new boolean[V];
        dfsHelper(src, visited);
    }


    boolean hasCycledfs(){
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfscycle(i,-1,visited)){
                    return true;
                }

            }
        }
        return false;
    }
    private boolean dfscycle(int u, int parent, boolean[] visited) {

        visited[u]=true;
        for(int v: l.get(u)){
            if(!visited[v]){
                dfscycle(v, u, visited);
            }else{
                if(v!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}

class GraphTraversal{
    public static void main(String[] args){
        Graph g=new Graph(5);
        g.addEdges(0,1);
        g.addEdges(1,2);
        g.addEdges(1,3);
        g.addEdges(2,3);
        g.addEdges(2,4);

        g.display();
    }
}
