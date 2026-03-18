import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class XeniaAndTree{
    static int N=200005;
    static int log=20;
    static int[] depth=new int[N];
    static ArrayList<Integer>[] tree=new ArrayList[N];
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        Arrays.fill(depth,Integer.MAX_VALUE);
        depth[1]=0;
        for(int i=1;i<=n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        bfs(1);
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int type=Integer.parseInt(st.nextToken());
            if(type==2){
                int node=Integer.parseInt(st.nextToken());
                System.out.println(depth[node]);
            }else{
                int v=Integer.parseInt(st.nextToken());
                depth[v]=0;
                bfs(v);
            }
        }
    }
    public static void bfs(int node){

        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int v : tree[curr]) {

                if (depth[v] > depth[curr] + 1) {

                    depth[v] = depth[curr] + 1;
                    q.add(v);
                }
            }
        }
    }

}