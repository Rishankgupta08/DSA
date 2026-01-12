import java.util.Scanner;
public class BeautifulAverage{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();  
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int count = maxavg(arr);
            System.out.println(count);
        }
        sc.close();
    }
    public static int maxavg(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }
        return max;
    }
}