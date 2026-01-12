class BuySellStock{
    public static void main(String[] a){
        int[] arr={7,1,5,3,6,4};
        int max=buysell(arr);
        System.out.println(max);
    }
    public static int buysell(int[] arr){
        int n=arr.length;
        int max=0;
        int best=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>best){
                max=Math.max(max,arr[i]-best);
            }
            best=Math.min(best,arr[i]);
        }
        return max;
    }
}