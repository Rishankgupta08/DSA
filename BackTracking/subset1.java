import java.util.*;

class subset1{
    public static void main(String[] args){
        int[] arr={1,2,3};
        List<List<Integer>> sub=allsubset(arr);
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
        // Exclude 
        printsub(arr, l1, i+1,l);
        
    }
    public static List<List<Integer>> allsubset(int[] arr){
        List<List<Integer>> l=new ArrayList<>();
        printsub(arr,new ArrayList<>(), 0,l);
        return l;
    }

}