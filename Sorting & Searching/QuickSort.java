class QuickSort{
    public static void main(String[] args){
        int[] arr={12,8,31,35,37,30};
        quicksort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    } 
    public static void quicksort(int[] arr,int si,int ei){
        if(si>ei){
            return;
        }
        int pidx=partition(arr,si,ei);
        quicksort(arr,si,pidx-1);
        quicksort(arr,pidx+1,ei);
    }
    public static int partition(int[] arr,int si,int ei){
        int idx=si-1;
        int pivot=arr[ei];
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                idx++;
                int temp=arr[idx];
                arr[idx]=arr[j];
                arr[j]=temp;
            }
        }
        idx++;
        int temp=arr[idx];
        arr[idx]=arr[ei];
        arr[ei]=temp;
        return idx;
    }
}