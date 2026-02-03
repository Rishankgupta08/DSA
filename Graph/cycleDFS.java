package Graph;
// boolean hasCycledfs(){
//         boolean[] visited=new boolean[V];
//         for(int i=0;i<V;i++){
//             if(!visited[i]){
//                 if(dfscycle(i,-1,visited)){
//                     return true;
//                 }

//             }
//         }
//         return false;
//     }
//     private boolean dfscycle(int u, int parent, boolean[] visited) {

//         visited[u]=true;
//         for(int v: l.get(u)){
//             if(!visited[v]){
//                 dfscycle(v, u, visited);
//             }else{
//                 if(v!=parent){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
class cycleDFS{
    public static void main(String[] args){
        Graph g=new Graph(5);
        g.addEdges(0, 1);
        g.addEdges(0, 2); //! if we remove this edge then there is no cycle 
        g.addEdges(0, 3);
        g.addEdges(1, 2);
        g.addEdges(3, 4);
        
        g.display();

        System.out.println(g.hasCycledfs());
    }
}