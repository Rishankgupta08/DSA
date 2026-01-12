class MS1{
    public static void main(String[] args){
        int[] arr={6,3,9,5,8,2,4};

        divide(arr,0,arr.length-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void divide(int[] arr,int st,int end){
        if(st>=end){
            return;
        }
        int mid=(st+end)/2;
        divide(arr,st,mid);
        divide(arr,mid+1,end);
        conquer(arr,st,mid,end);
    }
    public static void conquer(int[] arr,int st,int mid,int end){
        int[] merged=new int[end-st+1];
        int idx1=st;
        int idx2=mid+1;
        int x=0;
        while(idx1<=mid && idx2<=end){
            if(arr[idx1]<=arr[idx2]){
                merged[x++]=arr[idx1++];
            }else{
                merged[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=end){
            merged[x++]=arr[idx2++];
        }
        for(int i=0;i<merged.length;i++){
            arr[st+i]=merged[i];
        }
    }
}