// import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;
class CarbonEmission{
    public static void main(String[] args){
        int[] arr={31,26,33,21,40};
        int n=arr.length;
        PriorityQueue<Integer> res=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            res.offer(arr[i]);
        }
        while(res.size()>1){
            int first=res.poll();
            int second=res.poll();
            res.offer(first-second);
        }    
            
        
        if(res.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(res.peek());
        }
    }
}