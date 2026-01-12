// import java.util.Arrays;
class Majority_Element{
    public static void main(String[] args){
        int[] arr={1,2,2,2,1};
        int res=majority(arr);
        System.out.println(res);
    }
    //! Brute force Approach  O(n^2)
    // public static int majority(int[] arr){
    //     int n=arr.length;
    //     for(int i: arr){
    //         int count=0;
    //         for(int j:arr){
    //             if(i==j){
    //                 count++;
    //             }
    //         }
    //         if(count >n/2){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // ! Optimized Approach O(nlogn)
    // public static int majority(int[] arr){
    //     int n=arr.length;
    //     Arrays.sort(arr);
    //     int count=1;
    //     int ans=arr[0];
    //     for(int i=1;i<n;i++){
    //         if(arr[i]==arr[i-1]){
    //             count++;
    //         }else{
    //             count=1;
    //             ans=arr[i];
    //         }
    //         if(count>n/2){
    //             return ans;
    //         }
    //     }
    //     return -1;
    // } 

    //! Moore's Algorithm O(n)
    public static int majority(int[] arr){
        int count=0;
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(count==0){
                ans=arr[i];
            }
            if(ans==arr[i]){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    } 
}