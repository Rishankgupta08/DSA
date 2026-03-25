import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DyMinSum {
    static long[] seg;
    static long[] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        arr=new long[n];
        seg=new long[4*n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        buildSegmentTree(0,0,n-1);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int type=Integer.parseInt(st.nextToken());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            if(type==1){
                update(0,u-1,v,0,n-1);
            }else{
                
                bw.write(String.valueOf(querySum(0,u-1,v-1,0,n-1))+"\n");
            }
        }
        bw.flush();
    }
    public static void buildSegmentTree(int idx,int l,int r){
        if(l==r){
            seg[idx]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildSegmentTree(2*idx+1, l, mid);
        buildSegmentTree(2*idx+2,mid+1,r);
        seg[idx]=Math.min(seg[2*idx+1],seg[2*idx+2]);
    }
    public static void update(int idx,int i,int val,int l,int r){
        if(l==r){
            seg[idx]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(i<=mid){
            update(2*idx+1, i, val, l, mid);
        }else{
            update(2*idx+2, i, val, mid+1, r);
        }
        seg[idx]=Math.min(seg[2*idx+1],seg[2*idx+2]);
    }
    public static long querySum(int idx,int qs,int qe,int l,int r){
        if(r<qs || l>qe) return Integer.MAX_VALUE;
        if(l>=qs && r<=qe) return seg[idx];

        int mid=l+(r-l)/2;
        long left=querySum(2*idx+1, qs, qe, l, mid);
        long right=querySum(2*idx+2, qs, qe, mid+1, r);
        return Math.min(left,right);
    }
}
