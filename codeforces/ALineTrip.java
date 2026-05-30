import java.util.Scanner;

public class ALineTrip{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int x=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int low=1;
            int high=2*x;
            int ans=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(isPossible(arr,mid,x)){
                    ans=mid;
                    high=mid-1;
                } else {
                    low=mid+1;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
    public static boolean isPossible(int[] arr,int mid,int x){
        if (arr[0] > mid) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > mid) {
                return false;
            }
        }
        if (2 * (x - arr[arr.length - 1]) > mid) {
            return false;
        }
        return true;
    }
}