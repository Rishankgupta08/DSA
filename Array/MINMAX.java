class MINMAX{
    public static void main(String[] args){
        int[] arr={4,9,12,36,54};
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("Minimum value: "+min);
        System.out.println("Maximum value: "+max);
    }
}