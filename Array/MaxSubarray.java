class MaxSubarray{
    public static void main(String[] args){
        int arr[]={3,-4,5,4,-1,7,-8};
        int n=arr.length;
        //! Print all Subarrays   Time Complexity==O(n^3);
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         for(int k=i;k<=j;k++){
        //             System.out.print(arr[k]);
        //         }
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        // }

        //* Print the maximum subarray Sum (Brute Force Approach) 
        //! Time Complexity==O(n^2);
        int max=0;
        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=i;j<n;j++){
                curr+=arr[j];
                max=Math.max(curr,max);
            }
        }
        System.out.println(max);
    }
}