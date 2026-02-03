package Graph;
// void bfs(){
//         Queue<Integer> q= new LinkedList<>();
//         boolean[] visited=new boolean[V];
//         q.offer(0);
//         visited[0]=true;
//         while(q.size()>0){
//             int u=q.poll();
//             System.out.print(u+" ");
//             for(int v: l.get(u)){
//                 if(!visited[v]){
//                     visited[v]=true;
//                     q.offer(v);
//                 }
//             }
//         }

//     }

//!   Time- O(V+E);
class BFS{
    public static void main(String[] args){
        Graph g=new Graph(5);
        g.addEdges(0,1);
        g.addEdges(1,2);
        g.addEdges(1,3);
        g.addEdges(2,3);
        g.addEdges(2,4);

        g.bfs();
    }
}