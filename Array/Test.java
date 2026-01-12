class Test{
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        int n=arr.length;
        //! print subarrays sum 
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }
}