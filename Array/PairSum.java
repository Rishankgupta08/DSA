import java.util.ArrayList;
class PairSum{
    public static void main(String[] args){
        int [] arr={2,7,11,15};
        int target=9;
        int n=arr.length;
        ArrayList<Integer>res=new ArrayList<>();
        //*Brute Force Approach */
        // //! Time Complexity==O(n^2);
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]+arr[j]==target){
        //             res.add(i);
        //             res.add(j);
        //         }
        //     }
        // }
        // System.out.print(res);

        //* Two-Pointer Approach */
        int st=0;
        int end=n-1;
        while(st<end){
            if(arr[st]+arr[end]==target){
                res.add(st);
                res.add(end);
                break;
            }else if(arr[st]+arr[end]>target){
                end--;
            }else{
                st++;
            }
        } 
        System.out.print(res);
    }
}