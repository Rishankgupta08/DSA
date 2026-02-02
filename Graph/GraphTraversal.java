package Graph;
import java.util.ArrayList;

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
