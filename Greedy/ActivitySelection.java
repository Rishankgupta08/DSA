package Greedy;

import java.util.Arrays;

class ActivitySelection{
    public static void main(String[]args){
        int[] st={1,3,0,5,8,5};
        int[] end={2,4,6,7,9,9};
        int n=st.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b) -> end[a]-end[b]);

        int last=-1;
        int count=0;
        for(int i=0;i<n;i++){
            int id=idx[i];
            if(st[id]>=last){
                System.out.println(st[id]+" "+end[id]);
                last=end[id];
                count++;
            }
        }
        System.out.println("Total: "+ count);
    }
}