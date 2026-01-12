class QS1{
    public static void main(String[] args){
        int[] arr={8,2,7,3,4,5,9,0};
        quicksort(arr,0,arr.length-1);

        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void quicksort(int[] arr,int st,int end){
        if(st>=end){
            return;
        }
        int pidx=partition(arr,st,end);
        quicksort(arr,st,pidx-1);
        quicksort(arr,pidx+1,end);
        
    }
    public static int partition(int[] arr,int st,int end){
        int pivot=arr[end];
        int idx=st-1;
        for(int j=st;j<end;j++){
            if(arr[j]<pivot){
                idx++;
                int temp=arr[idx];
                arr[idx]=arr[j];
                arr[j]=temp;
            }
        }
        idx++;
        int temp=arr[end];
        arr[end]=arr[idx];
        arr[idx]=temp;

        return idx;
    }

}