package JPMC;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] boxes=new long[n];
        long[] UnitPrBoxes=new long[n];
        for(int i=0;i<n;i++){
            boxes[i]=sc.nextLong();
        }
        for(int i=0;i<n;i++){
            UnitPrBoxes[i]=sc.nextLong();
        }
        long size=sc.nextLong();
        long ans=getMaxUnit(n,boxes,UnitPrBoxes,size);
        System.out.println(ans);
    }

    private static long getMaxUnit(int n, long[] boxes, long[] unitPrBoxes,long size) {
        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b) -> Long.compare(b[1],a[1]));
        for(int i=0;i<n;i++){
            pq.offer(new long[]{boxes[i],unitPrBoxes[i]});
        }
        long total=0;
        long remaining=size;
        while(!pq.isEmpty() && remaining>0){
            long[] curr=pq.poll();
            long avail=curr[0];
            long unit=curr[1];
            long take=Math.min(avail,remaining);
            total+=take*unit;
            remaining-=take;
        }
        return total;
    }
}
