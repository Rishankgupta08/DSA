package Graph;
// void dfsHelper(int u,boolean[] visited){
//         System.out.print(u+" ");
//         visited[u]=true;
//         for(int v: l.get(u)){
//             if(!visited[v]){
//                 dfsHelper(v,visited);
//             }
//         }
//     }
//     void dfs(){
//         int src=0;
//         boolean[] visited=new boolean[V];
//         dfsHelper(src, visited);
//     }
//! Time- O(V+E);
class DFS{
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdges(0,1);
        g.addEdges(1,2);
        g.addEdges(1,3);
        g.addEdges(2,4);
       
        g.dfs();

    }
}