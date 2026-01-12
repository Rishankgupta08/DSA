import java.util.ArrayList;
import java.util.Arrays;
class sort{
    public static void main(String[] args){
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(3,1,4,2,5));
        solve(arr);
        System.out.println(arr);
    }
    public static void  solve(ArrayList<Integer> arr){
        if(arr.size()==1){
            return;
        }
        int last=arr.remove(arr.size()-1);
        solve(arr);
        insert(arr,last); 
    }
    public static void insert(ArrayList<Integer> arr,int last){
        if(arr.size()==0 || arr.get(arr.size()-1)<=last){
            arr.add(last);
            return;
        }
        int val=arr.remove(arr.size()-1);
        insert(arr,last);
        arr.add(val);
    }
}