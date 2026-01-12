import java.util.Scanner;
public class goodArray1777A{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int count = goodarray(arr);
            System.out.println(count);
        }
        sc.close();
    }
    public static int goodarray(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            if((arr[i] % 2) == (arr[i + 1] % 2)) {
                count++; 
            }
        }
        return count;
    }
}