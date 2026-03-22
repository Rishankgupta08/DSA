package SegmentTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SalaryQueries{
    static int[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        tree=new int[4*n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        build(0,0,n-1,arr);
        
    }
    private static void build(int idx, int leftR, int rightR, int[] arr) {
        if(leftR==rightR){
            tree[idx]=arr[leftR];
            return;
        }
        int mid=leftR+(rightR-leftR)/2;
        int leftChild=2*idx+1;
        int rightChild=2*idx+2;
        build(leftChild, leftR, mid, arr);
        build(rightChild,mid+1,rightR, arr);
        tree[idx]=tree[leftChild]+tree[rightChild];
    }

}