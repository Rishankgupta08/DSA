import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FencePaint{
    static long[] tree;
    static long[] lazy;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int uq=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        tree=new long[4*n];
        lazy=new long[4*n];

        for(int i=0;i<uq;i++){
            st=new StringTokenizer(br.readLine());
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            long val=Long.parseLong(st.nextToken());
            update(0,0,n-1,left-1,right-1,val);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(st.nextToken())-1;
            sb.append(query(0,0,n-1,idx)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void update(int node,int leftR,int rightR,int left,int right,long val){
        if(leftR>right || rightR<left){
            return;
        }
       int leftChild=2*node+1;
        int rightChild=2*node+2;
        if(lazy[node] != 0 && leftR!=rightR){
            tree[leftChild]=lazy[node];
            tree[rightChild]=lazy[node];
            lazy[leftChild]=lazy[node];
            lazy[rightChild]=lazy[node];
            lazy[node]=0;
        }
        if(leftR>=left && rightR<=right){
            tree[node]=val;
            if(leftR!=rightR){
                lazy[leftChild]=val;
                lazy[rightChild]=val;
            }
            return;
        }
        int mid=leftR+((rightR-leftR)>>1);
        update(leftChild, leftR, mid, left, right, val);
        update(rightChild, mid+1, rightR, left, right, val);
    }
    public static long query(int node,int leftR,int rightR,int idx){
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        if(lazy[node] != 0 && leftR!=rightR){
            tree[node]=lazy[node];
            if(leftR!=rightR){
                lazy[leftChild]=lazy[node];
                lazy[rightChild]=lazy[node];
            }
            lazy[node]=0;
        }
        if(leftR==rightR){
            return tree[node];
        }
        long ans=0;
        int mid=leftR+((rightR-leftR)>>1);
        if(idx<=mid){
            ans=query(2*node+1, leftR, mid, idx);
        }else{
            ans=query(2*node+2, mid+1, rightR, idx);
        }
        return ans;
    }
}