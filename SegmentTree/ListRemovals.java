package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ListRemovals {
    static long[] seg;
    static long[] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        arr=new long[n];
        seg=new long[4*n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        buildSegmentTree(0,0,n-1);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int u=Integer.parseInt(st.nextToken());
            int ans=queryRemove(0, u, 0, n-1);
            bw.write(String.valueOf(arr[ans])+" ");
        }
        bw.flush();
    }
    public static void buildSegmentTree(int idx,int l,int r){
        if(l==r){
            seg[idx]=1;
            return;
        }
        int mid=l+(r-l)/2;
        buildSegmentTree(2*idx+1, l, mid);
        buildSegmentTree(2*idx+2,mid+1,r);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    // public static void update(int idx,int i,int l,int r){
    //     if(l==r){
    //         seg[idx]=0;
    //         return;
    //     }
    //     int mid=l+(r-l)/2;
    //     if(i<=mid){
    //         update(2*idx+1, i, l, mid);
    //     }else{
    //         update(2*idx+2, i, mid+1, r);
    //     }
    //     seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    // }
    public static int queryRemove(int idx,long qs,int l,int r){
        if(l==r){
            seg[idx]=0;
            return l;
        }
        int mid=l+(r-l)/2;
        int ans;
        if(seg[2*idx+1]>=qs){
            ans=queryRemove(2*idx+1, qs, l, mid);
        }else{
            ans=queryRemove(2*idx+2, qs-seg[2*idx+1], mid+1, r);
        }
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
        return ans;
    }
}
