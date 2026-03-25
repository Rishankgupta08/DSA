import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class RMQ{
    static long[] tree;
    static long[] lazy;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        long[] arr=new long[n];
        tree=new long[4*n];
        lazy=new long[4*n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        build(0,0,n-1,arr);
        StringBuilder sb=new StringBuilder();
        while(q-- >  0){
            st=new StringTokenizer(br.readLine());
            int type=Integer.parseInt(st.nextToken());
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            if(type==1){
                long val=Long.parseLong(st.nextToken());
                update(0,0,n-1,left-1,right-1,val);
            }else{
                long ans=query(0,0,n-1,left-1,right-1);
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static void build(int node,int leftR,int rightR,long[] arr){
        if(leftR==rightR){
            tree[node]=arr[leftR];
            return;
        }
        int mid=leftR+((rightR-leftR)>>1);
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        build(leftChild, leftR, mid, arr);
        build(rightChild, mid+1, rightR, arr);
        tree[node]=Math.max(tree[leftChild],tree[rightChild]);
    }
    public static void update(int node,int leftR,int rightR,int querySt,int queryEnd,long value){
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        if(lazy[node]!=0){
            tree[node]+=(rightR-leftR+1)*lazy[node];
            if(leftR!=rightR){
                lazy[leftChild]+=lazy[node];
                lazy[rightChild]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(leftR>queryEnd || rightR<querySt){
            return;
        }
        if(leftR>=querySt && rightR<=queryEnd){
            tree[node]+=(rightR-leftR+1)*value;
            if(leftR!=rightR){
                lazy[leftChild]+=lazy[node];
                lazy[rightChild]+=lazy[node];
            }
            lazy[node]=0;
            return;
        }
        int mid=leftR+((rightR-leftR)>>1);
        update(leftChild, leftR, mid, querySt, queryEnd, value);
        update(rightChild, mid+1, rightR, querySt, queryEnd, value);
        tree[node]=Math.max(tree[leftChild],tree[rightChild]);
    }
    public static long query(int node,int leftR,int rightR,int querySt,int queryEnd){
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        if(lazy[node] != 0){
            tree[node]+=(rightR-leftR+1)*lazy[node];
            if(leftR!=rightR){
                lazy[leftChild]+=lazy[node];
                lazy[rightChild]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(leftR>queryEnd || rightR<querySt){
            return 0;
        }
        if(leftR>=querySt &&  rightR<=queryEnd){
            return tree[node];
        }
        int mid=leftR+((rightR-leftR)>>1);
        return Math.max(query(leftChild, leftR, mid, querySt, queryEnd),query(rightChild, mid+1, rightR, querySt, queryEnd));
    }
}