class MergeSort{
    public static void main(String[] args){
        int[] arr={12,31,8,32,17,35};
        System.out.println("Original Array: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        divide(arr,0,arr.length-1);
        System.out.println("\nSorted Array: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void divide(int[] arr,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            divide(arr,low,mid);
            divide(arr,mid+1,high);
            conquer(arr,low,mid,high);
        }
    }
    public static void conquer(int[] arr,int low,int mid,int high){
         int temp[]=new int[high-low+1];
         int i=low;
         int j=mid+1;
         int x=0;
         while(i<=mid & j<=high){
            if(arr[i]<=arr[j]){
                temp[x++]=arr[i++];
            }else{
                temp[x++]=arr[j++];
            }
         }
         while(i<=mid){
            temp[x++]=arr[i++];
         }
         while(j<=high){
            temp[x++]=arr[j++];
         }
         for(int k=0;k<temp.length;k++){
            arr[low+k]=temp[k];
         }
    }

}
