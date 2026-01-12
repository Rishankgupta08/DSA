import java.util.ArrayList;
import java.util.List;

public class permutation1 {
    public static void  getperm(int[] nums,int idx,List<List<Integer>> l){
        if(idx==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int i: nums){
                temp.add(i);
            }
            l.add(temp);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,idx,i);
            getperm(nums,idx+1,l);

            swap(nums,idx,i);
        }
    }
    public static void swap(int[] nums,int idx,int i){
        int temp=nums[idx];
        nums[idx]=nums[i];
        nums[i]=temp;
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        getperm(nums,0,l);
        return l;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> list=permute(arr);
        System.out.println(list);
    }
}

