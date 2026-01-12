import java.util.Arrays;
class RotateArrayRight{
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        int k=3;
        for(int i=0;i<k;i++){
            int end=arr[arr.length-1];
            for(int j=arr.length-1;j>0;j--){
                
                arr[j]=arr[j-1];
                
            }
            arr[0]=end;
        }
        System.out.println(Arrays.toString(arr));
    }
}