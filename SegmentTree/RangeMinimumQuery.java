import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RangeMinimumQuery {
    static long[] seg;
    static long[] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        arr=new long[n];
        // Tree size 4*n guarantees no index overflow for any n
        seg=new long[4*n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        buildSegmentTree(0,0,n-1);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int queryL=Integer.parseInt(st.nextToken());
            int queryR=Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(queryMin(0,queryL-1,queryR-1,0,n-1))+"\n");
        }
        bw.flush();
        bw.close();
    }
    // Time- O(n)
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
    // Time-O(log(n))
    public static long queryMin(int idx,int rangeL,int rangeR,int l,int r){
        // Out-of-range node contributes identity element for min
        if(r<rangeL || l>rangeR) return Long.MAX_VALUE;  //No Overlapping
        if(l>=rangeL && r<=rangeR) return seg[idx]; //Fully Overlapping
        // Partial Overlapping
        int mid=l+(r-l)/2;
        long left=queryMin(2*idx+1, rangeL, rangeR, l, mid);
        long right=queryMin(2*idx+2, rangeL, rangeR, mid+1, r);
        return Math.min(left,right);
    }
}
