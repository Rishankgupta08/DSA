import java.util.*;
class Array2D{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number of Rows: ");
        int rows=sc.nextInt();
        System.out.print("Enter the Number of Columns: ");
        int cols=sc.nextInt();
        System.out.println("Enter the elements: ");
        int arr[][]=new int [rows][cols];
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("2D Array is: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}