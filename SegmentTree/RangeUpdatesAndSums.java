// // package SegmentTree;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.util.StringTokenizer;

// public class RangeUpdatesAndSums{
//     static long[] tree;
//     static long[] lazy1;
//     static long[] lazy2;
//     public static void main(String[] args) throws Exception{
//         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st=new StringTokenizer(br.readLine());
//         int n=Integer.parseInt(st.nextToken());
//         int q=Integer.parseInt(st.nextToken());
//         int[] arr=new int[n];
//         tree=new long[4*n];
//         lazy1=new long[4*n];
//         lazy2=new long[4*n];
//         st=new StringTokenizer(br.readLine());
//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(st.nextToken());
//         }
//         for (int i = 0; i < 4 * n; i++) lazy2[i] = Long.MIN_VALUE;
//         StringBuilder sb=new StringBuilder();
//         build(0,0,n-1,arr);
//         for(int i=0;i<q;i++){
//             st=new StringTokenizer(br.readLine());
//             int type=Integer.parseInt(st.nextToken());
            
//             if(type==1){
//                 int left=Integer.parseInt(st.nextToken());
//                 int right=Integer.parseInt(st.nextToken());
//                 int value=Integer.parseInt(st.nextToken());
//                 updateAdd(0,0,n-1,left-1,right-1,value);
//             }else if(type==2){
//                 int left=Integer.parseInt(st.nextToken());
//                 int right=Integer.parseInt(st.nextToken());
//                 int value=Integer.parseInt(st.nextToken());
//                 updateSet(0,0,n-1,left-1,right-1,value);
//             }else{    
//                 int left=Integer.parseInt(st.nextToken());
//                 int right=Integer.parseInt(st.nextToken());
//                 sb.append(query(0,0,n-1,left-1,right-1)).append("\n");
//             }
//         }
//         BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
//         bw.write(sb.toString());
//         bw.flush();
//         bw.close();
//     }
//     // Time O(log(n))
//     public static long query(int node ,int leftR,int rightR,int querySt,int queryEnd){
//         int leftChild=2*node+1;
//         int rightChild=2*node+2;
//         push(node, leftR, rightR);
//         if(leftR>queryEnd || rightR<querySt){
//             return 0;
//         }
//         if(leftR>=querySt && rightR <=queryEnd){
//             return tree[node];
//         }
//         int mid=leftR+((rightR-leftR)>>1);
//         long left=query(leftChild, leftR, mid, querySt,queryEnd);
//         long right=query(rightChild, mid+1, rightR, querySt,queryEnd);
//         return left+right;
        
//     }
//     public static void updateAdd(int node,int leftR,int rightR,int querySt,int queryEnd,int value){
//         int leftChild=2*node+1;
//         int rightChild=2*node+2;
//         push(node,leftR,rightR);
//         if(rightR<querySt || leftR> queryEnd){
//             return;
//         }
//         if(leftR>=querySt && rightR<=queryEnd){
//             lazy1[node]+=value;
//             push(node, leftR, rightR);
//             return;
//         }
//         int mid=leftR+((rightR-leftR)>>1);
//         updateAdd(leftChild, leftR, mid, querySt, queryEnd, value);
//         updateAdd(rightChild,mid+1,rightR, querySt, queryEnd, value);
//         tree[node]=tree[leftChild]+tree[rightChild];
//     }
//     public static void updateSet(int node,int leftR,int rightR,int querySt,int queryEnd,int value){
//         int leftChild=2*node+1;
//         int rightChild=2*node+2;
//         push(node,leftR,rightR);
//         if(rightR<querySt || leftR> queryEnd){
//             return;
//         }
//         if(leftR>=querySt && rightR<=queryEnd){
//             lazy2[node]=value;
//             lazy1[node]=0; //clear lazy1 value
//             push(node, leftR, rightR);
//             tree[node] += (rightR - leftR + 1) * value;
//             return;
//         }
//         int mid=leftR+((rightR-leftR)>>1);
//         updateSet(leftChild, leftR, mid, querySt, queryEnd, value);
//         updateSet(rightChild,mid+1,rightR, querySt, queryEnd, value);
//         tree[node]=tree[leftChild]+tree[rightChild];
//     }
//     // Propagates pending lazy value to current node and its children
//     // Time - O(1)
//     public static void push(int node,int leftR,int rightR){
//         int leftChild=2*node+1;
//         int rightChild=2*node+2;
//         // First -SET
//         if (lazy2[node] != Long.MIN_VALUE) {
//             tree[node] = (rightR - leftR + 1) * lazy2[node];

//             if (leftR != rightR) {
//                 lazy2[leftChild] = lazy2[node];
//                 lazy2[rightChild] = lazy2[node];

//                 lazy1[leftChild] = 0;
//                 lazy1[rightChild] = 0;
//             }

//             lazy2[node] = Long.MIN_VALUE;
//         }
//         // Second -ADD
//         if(lazy1[node]!=0){
//             tree[node]+=(rightR-leftR+1)*lazy1[node];
//             if(leftR!=rightR){
//                 lazy1[leftChild]+=lazy1[node];
//                 lazy1[rightChild]+=lazy1[node];
//             }
//             lazy1[node]=0;
//         }
//     }
//     public static void build(int node,int leftR,int rightR,int[] arr){
//         if(leftR==rightR){
//             tree[node]=arr[leftR];
//             return;
//         }
//         int leftChild=2*node+1;
//         int rightChild=2*node+2;
//         int mid=leftR+((rightR-leftR)>>1);
//         build(leftChild, leftR, mid, arr);
//         build(rightChild, mid+1, rightR, arr);
//         tree[node]=tree[leftChild]+tree[rightChild];
//     }

// }

// package SegmentTree;

import java.io.*;
import java.util.*;

public class RangeUpdatesAndSums {

    static long[] tree, lazyAdd, lazySet;
    static boolean[] hasSet;

    // ─── Fast I/O ────────────────────────────────────────────────
    static DataInputStream in = new DataInputStream(System.in);

    static long readLong() throws Exception {
        long ret = 0;
        int b = in.read();
        boolean neg = false;
        while (b < '0' || b > '9') {
            if (b == '-') neg = true;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }

    static int readInt() throws Exception {
        return (int) readLong();
    }
    // ─────────────────────────────────────────────────────────────

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = readInt();
        int q = readInt();

        int[] arr = new int[n];
        tree    = new long[4 * n];
        lazyAdd = new long[4 * n];
        lazySet = new long[4 * n];
        hasSet  = new boolean[4 * n];

        for (int i = 0; i < n; i++) arr[i] = readInt();

        build(0, 0, n - 1, arr);

        while (q-- > 0) {
            int type = readInt();
            int l = readInt() - 1;
            int r = readInt() - 1;

            if (type == 1) {
                long val = readLong();
                updateAdd(0, 0, n - 1, l, r, val);
            } else if (type == 2) {
                long val = readLong();
                updateSet(0, 0, n - 1, l, r, val);
            } else {
                out.println(query(0, 0, n - 1, l, r));
            }
        }

        out.flush();
    }

    static void build(int node, int l, int r, int[] arr) {
        if (l == r) { tree[node] = arr[l]; return; }
        int mid = (l + r) >> 1;
        build(2 * node + 1, l, mid, arr);
        build(2 * node + 2, mid + 1, r, arr);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    static void push(int node, int l, int r) {
        if (l == r) return;
        int left = 2 * node + 1, right = 2 * node + 2;
        int mid = (l + r) >> 1;
        int lLen = mid - l + 1, rLen = r - mid;

        if (hasSet[node]) {
            tree[left]  = (long) lLen * lazySet[node];
            tree[right] = (long) rLen * lazySet[node];
            hasSet[left]  = hasSet[right]  = true;
            lazySet[left] = lazySet[right] = lazySet[node];
            lazyAdd[left] = lazyAdd[right] = 0;
            hasSet[node]  = false;
            lazySet[node] = 0;
        }

        if (lazyAdd[node] != 0) {
            tree[left]  += (long) lLen * lazyAdd[node];
            tree[right] += (long) rLen * lazyAdd[node];

            if (hasSet[left])  lazySet[left]  += lazyAdd[node];
            else               lazyAdd[left]  += lazyAdd[node];

            if (hasSet[right]) lazySet[right] += lazyAdd[node];
            else               lazyAdd[right] += lazyAdd[node];

            lazyAdd[node] = 0;
        }
    }

    static void updateAdd(int node, int l, int r, int ql, int qr, long val) {
        if (r < ql || l > qr) return;

        if (l >= ql && r <= qr) {
            tree[node] += (long)(r - l + 1) * val;
            if (hasSet[node]) lazySet[node] += val;
            else              lazyAdd[node] += val;
            return;
        }

        push(node, l, r);
        int mid = (l + r) >> 1;
        updateAdd(2 * node + 1, l, mid, ql, qr, val);
        updateAdd(2 * node + 2, mid + 1, r, ql, qr, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    static void updateSet(int node, int l, int r, int ql, int qr, long val) {
        if (r < ql || l > qr) return;

        if (l >= ql && r <= qr) {
            tree[node]    = (long)(r - l + 1) * val;
            hasSet[node]  = true;
            lazySet[node] = val;
            lazyAdd[node] = 0;
            return;
        }

        push(node, l, r);
        int mid = (l + r) >> 1;
        updateSet(2 * node + 1, l, mid, ql, qr, val);
        updateSet(2 * node + 2, mid + 1, r, ql, qr, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    static long query(int node, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) return 0;
        if (l >= ql && r <= qr) return tree[node];

        push(node, l, r);
        int mid = (l + r) >> 1;
        return query(2 * node + 1, l, mid, ql, qr)
             + query(2 * node + 2, mid + 1, r, ql, qr);
    }
}