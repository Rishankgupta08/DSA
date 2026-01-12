import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset2 {
    public static void main(String[] args){
        int[] arr={1,2,2};
        List<List<Integer>> sub=subwithdup(arr);
        System.out.print(sub);
        
    }
    public static void printsub(int[] arr, List<Integer> l1,int i,List<List<Integer>> l){
        if(i==arr.length){
            l.add(new ArrayList<>(l1));
            return;
        }
        // Include     
        l1.add(arr[i]);
        printsub(arr, l1, i+1,l);
        // BackTrack
        l1.remove(l1.size()-1);

        // checking for duplicate
        int idx=i+1;
        while(idx<arr.length && arr[idx]==arr[idx-1]){
            idx++;
        }
        
        // Exclude 
        printsub(arr, l1, idx,l);
        
    }
    public static List<List<Integer>> subwithdup(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> l=new ArrayList<>();
        printsub(arr,new ArrayList<>(), 0,l);
        return l;
    }
}
