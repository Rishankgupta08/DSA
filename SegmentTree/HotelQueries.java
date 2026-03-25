import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HotelQueries{
    static long[] tree;
    static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        tree=new long[4*n];
        arr=new long[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        build(0,0,n-1,arr);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int query=Integer.parseInt(st.nextToken());
            int finalIdx=querySeg(0,0,n-1,query)+1;
            bw.write(String.valueOf(finalIdx)+" ");
        }
        bw.flush();
        bw.close();
    }
    public static void build(int idx,int start,int end,long[] arr){
        if(start==end){
            tree[idx]=arr[start];
            return;
        }
        int mid=start+(end-start)/2;
        build(2*idx+1,start,mid,arr);
        build(2*idx+2,mid+1,end,arr);
        tree[idx]=Math.max(tree[2*idx+1],tree[2*idx+2]);
    }
    // public static void update(int idx,int changeIdx, long value, int rangeL,int rangeR){
    //     if(rangeL==rangeR){
    //         tree[idx]=value;
    //         return;
    //     }
    //     int mid=rangeL+(rangeR-rangeL)/2;
    //     if(changeIdx<=mid){
    //         update(2*idx+1,changeIdx,value,rangeL,mid);
    //     }else{
    //         update(2*idx+2,changeIdx,value,mid+1,rangeR);
    //     }
    //     tree[idx]=Math.max(tree[2*idx+1],tree[2*idx+2]);
    // }

    public static int querySeg(int idx,int rangeL,int rangeR,int query){
        if(tree[idx]<query){
            return -1;
        }
        // base Case
        if(rangeL==rangeR){
            arr[rangeL]-=query;
            tree[idx]-=query;
            return rangeL;
        }
        int ans=0;
        int mid=rangeL+(rangeR-rangeL)/2;
        if(tree[2*idx+1]<query){
            ans= querySeg(2*idx+2,mid+1,rangeR,query);
        }
        else{ ans= querySeg(2*idx+1,rangeL,mid,query);
        }

        tree[idx]=Math.max(tree[2*idx+1],tree[2*idx+2]);
        return ans;


    }
}