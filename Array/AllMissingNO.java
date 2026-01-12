import java.util.*;
class AllMissingNO{
    public static void main(String[] args){
        int[] arr={4,3,2,7,8,2,3,1};
        List<Integer>res=miss(arr);
        System.out.println(res);
    }
    public static List<Integer> miss(int[] arr){
        int n=arr.length;
        ArrayList<Integer>res=new ArrayList<>();
        boolean[] nums=new boolean[n+1];
        for(int i: arr){
            if(i>=1 && i<=n){
                nums[i]=true;
            }
        }
    
        for(int i=1;i<n;i++){
            if(!nums[i]){
                res.add(i);
            }
        }
        return res;
    }
}