import java.util.ArrayList;
import java.util.List;

class SubsetSum{
    public static void main(String[] args){
        int[] arr= {10, 7, 5, 18, 12, 20, 15};
        int target=35;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        solve(arr,target,0,0,ans,res);
        for(List<Integer> temp: res){
            System.out.println(temp);
        }
    }
    public static void solve(int[] arr, int target, int idx, int sum,List<Integer> ans,List<List<Integer>> res){
        if(sum==target){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(idx==arr.length || sum>target){
            return;
        }

        ans.add(arr[idx]);
        solve(arr,target,idx+1,sum+arr[idx],ans,res);
        ans.remove(ans.size()-1);
        solve(arr,target,idx+1,sum,ans,res);
        
    }
}