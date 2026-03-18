import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MysteriousPresent{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int h=sc.nextInt();

        int[][] env=new int[n+1][3]; // added 3rd column for original index
        
        for(int i=1;i<=n;i++){
            env[i][0]=sc.nextInt();
            env[i][1]=sc.nextInt();
            env[i][2]=i; // store original index before sorting
        }
        
        Arrays.sort(env,(a,b) -> {if(a[0]!=b[0]) return a[0]-b[0]; else return b[1]-a[1];} );
        env[0][0]=w; env[0][1]=h; env[0][2]=0;

        int[] arr=new int[n+1];
        HashMap<Integer,Integer> heightToIdx=new HashMap<>(); 
        for(int i=0;i<=n;i++){
            arr[i]=env[i][1];
            heightToIdx.put(env[i][1], env[i][2]); 
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(arr[0]);
        for(int i=1;i<=n;i++){
            if(arr[i]>ans.get(ans.size()-1)){
                ans.add(arr[i]);
            }else{
                ans.set(lb(ans,arr[i]),arr[i]);
            }
        }

        ans.remove(0); // remove card height — your idea
        System.out.println(ans.size());
        
        // map each height to its original index — your idea
        StringBuilder sb=new StringBuilder();
        for(int val:ans) sb.append(heightToIdx.get(val)).append(" ");
        System.out.println(sb.toString().trim());
    }
    public static int lb(ArrayList<Integer> ans,int target){
        int low=0; int high=ans.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ans.get(mid)>=target){ high=mid-1; }
            else{ low=mid+1; }
        }
        return low;
    }
}