import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RangeUpdateQueries{
    static long[] tree;
    static long[] lazy;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        long[] arr=new long[n];
        tree=new long[4*n];
        lazy=new long[4*n];
        st=new StringTokenizer(br.readLine());
        for(int  i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        build(0,0,n-1,arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int type=Integer.parseInt(st.nextToken());
            if(type==1){
                int left=Integer.parseInt(st.nextToken());
                int right=Integer.parseInt(st.nextToken());
                long value=Long.parseLong(st.nextToken());
                update(0,0,n-1,left-1,right-1,value);
            }else{
                int position=Integer.parseInt(st.nextToken())-1;
                sb.append(query(0, 0, n-1, position)).append("\n");
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    // Time O(n)
    public static void build(int idx,int leftR,int rightR,long[] arr){
        if(leftR==rightR){
            tree[idx]=arr[leftR];
            return;
        }
        int leftChild=2*idx+1;
        int rightChild=2*idx+2;
        int mid=leftR+((rightR-leftR)>>1);
        build(leftChild,leftR,mid,arr);
        build(rightChild, mid+1, rightR, arr);
        tree[idx]=tree[leftChild]+tree[rightChild];
    }
    // Time - O(log(n))
    public static void update(int idx,int leftR,int rightR,int querySt,int queryEnd,long value){
        int leftChild=2*idx+1;
        int rightChild=2*idx+2;
        push(idx,leftR,rightR);
        if(rightR<querySt || leftR> queryEnd){
            return;
        }
        if(leftR>=querySt && rightR<=queryEnd){
            lazy[idx]+=value;
            push(idx, leftR, rightR);
            return;
        }
        int mid=leftR+((rightR-leftR)>>1);
        update(leftChild, leftR, mid, querySt, queryEnd, value);
        update(rightChild,mid+1,rightR, querySt, queryEnd, value);
        tree[idx]=tree[leftChild]+tree[rightChild];
    }
    // Time O(log(n))
    public static long query(int idx,int leftR,int rightR,int querySt){
        int leftChild=2*idx+1;
        int rightChild=2*idx+2;
        push(idx, leftR, rightR);
        if(leftR==rightR){
            return tree[idx];
        }
        int mid=leftR+((rightR-leftR)>>1);
        if(querySt<=mid){
            return query(leftChild, leftR, mid, querySt);
        }else{
            return query(rightChild, mid+1, rightR, querySt);
        }
    }
    // Propagates pending lazy value to current node and its children
    // Time - O(1)
    public static void push(int idx,int leftR,int rightR){
        int leftChild=2*idx+1;
        int rightChild=2*idx+2;
        if(lazy[idx]!=0){
            tree[idx]+=(rightR-leftR+1)*lazy[idx];
            if(leftR!=rightR){
                lazy[leftChild]+=lazy[idx];
                lazy[rightChild]+=lazy[idx];
            }
            lazy[idx]=0;
        }
    }
}