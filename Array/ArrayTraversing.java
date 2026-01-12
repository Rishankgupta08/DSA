import java.util.*;
class ArrayTraversing{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for (int i=0;i<size;i++){
            arr[i]=sc.nextInt();

        }
        //* */ reverse array
        for (int j=size-1;j>=0;j--){
            System.out.print(arr[j]+" ");
        }
        sc.close();
        
    }
}