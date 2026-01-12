import java.util.Arrays;
class RotateArrayLeft{
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        int k=3;
        for(int i=0;i<k;i++){
            int first=arr[0];
            for(int j=1;j<arr.length;j++){
                
                arr[j-1]=arr[j];
                
            }
            arr[arr.length-1]=first;
        }
        System.out.println(Arrays.toString(arr));
    }
}