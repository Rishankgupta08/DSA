class Kadane_Algo{
    public static void main(String[] args){
        //! ime Complexity==O(n); optimal Approach
        int arr[]={3,-4,5,4,-1,7,-8};
        int maxsum=0;
        int curr=0;
        for(int i=0;i<arr.length;i++){
            curr=curr+arr[i];
            maxsum=Math.max(curr,maxsum);
            if(curr<0){
                curr=0;
            }
        }
        System.out.println(maxsum);
    }
}