import java.util.*;
class Add2DArr{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number of Rows: ");
        int rows=sc.nextInt();
        System.out.print("Enter the Number of Columns: ");
        int cols=sc.nextInt();
        System.out.println("Enter the elements: ");
        int arr1[][]=new int [rows][cols];
        int arr2[][]=new int [rows][cols];
        System.out.println("Enter the Array 1 elements: ");
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr1[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the Array 2 elements: ");
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr2[i][j]=sc.nextInt();
            }
        }
        int [][]res=new int[arr1.length][arr1[0].length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                res[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        System.out.println("Addition of 2D Array is: ");
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}