import java.util.*;
class BinarySearch{
    public static int  binarySearch(int arr[],int key){
        int left=0;
        int right=arr.length-1;
        while(left<=right){

            int mid=(left+right)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]<key){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int size=sc.nextInt();
        int arr[]=new int[size];
        for (int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter element to search: ");
        int key=sc.nextInt();
        int result=binarySearch(arr,key);
        if (result==-1){
            System.out.println("Element not found.");
        }
        else{
            System.out.println("Element at index: "+ result);
        }
        sc.close();
        
    }
}