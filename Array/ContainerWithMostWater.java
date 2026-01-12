class ContainerWithMostWater{
    public static void main(String[] a){
        int[] arr={1,8,6,2,5,4,8,3,7};
        int max=MaxArea(arr);
        System.out.println(max);
    }
    public static int MaxArea(int[] arr){
        int max=0;
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int area=Math.min(arr[left],arr[right])*(right-left);
            max=Math.max(area,max);
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}