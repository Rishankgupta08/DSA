import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation2 {
    public static void  getperm(int[] nums,boolean[] used,List<Integer> temp,List<List<Integer>> l){
        if(temp.size()==nums.length){
            l.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
           if(used[i]){
            continue;
           }
           if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
            continue;
           }
           used[i]=true;
           temp.add(nums[i]);
           getperm(nums, used, temp, l);

           used[i]=false;
           temp.remove(temp.size()-1);
        }
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l=new ArrayList<>();
        getperm(nums,new boolean[nums.length],new ArrayList<>(),l);
        return l;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2};
        List<List<Integer>> list=permute(arr);
        System.out.println(list);
    }
}


