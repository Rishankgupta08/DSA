import java.io.IOException;
import java.util.*;
public class Quack{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t--> 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                int height = arr[i];
                for(int j = i + 1; j < n; j++){
                    if(height < arr[j]){
                        arr[j] = height;
                        break;
                    }
                }
            }
            long ans = 0;
            for(int i = 0; i < n; i++){
                ans += arr[i];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}