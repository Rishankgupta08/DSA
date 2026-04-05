package HWI;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
class PeakElimination{
    static int[] arr;
    static int N;
    static boolean[] vis;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        N=n;
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int ans=elimination(arr);
        System.out.println(ans);
    }
    public static int elimination(int[] arr){
        int n=arr.length;
        int count=0;
        vis=new boolean[n];
        Arrays.fill(vis,true);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for(int i=0;i<n;i++){
            if(peak(i)){
                pq.offer(new int[] {arr[i],i});
            }
        }

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int idx=curr[1];
            if(!vis[idx] || !peak(idx)) continue;


            int left=getLeft(idx);
            int right=getRight(idx);

            vis[idx]=false;
            count++;
            if(left!=-1 && peak(left)){
                pq.offer(new int[]{arr[left],left});
            }
            if(right!=N && peak(right)){
                pq.offer(new int[]{arr[right],right});
            }
        }
        return count;
    }
    public static boolean peak(int idx){
        if(!vis[idx]) return false;
        int left=getLeft(idx);
        int right=getRight(idx);
        if(left==-1 || right==N) return false;
        return arr[left]<arr[idx] && arr[idx]>arr[right];
    }

    public static int getLeft(int idx){
        int i=idx-1;
        while(i>=0 && !vis[i]){
            i--;
        }
        return i;
    }
    public static int getRight(int idx){
        int i=idx+1;
        while(i<N && !vis[i]){
            i++;
        }
        return i;
    }
}