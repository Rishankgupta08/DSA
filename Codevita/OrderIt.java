import java.util.*;
import java.util.Arrays;

public class OrderIt {
    
    // Find length of Longest Increasing Subsequence
    public static int findLIS(int[] arr) {
        if (arr.length == 0) return 0;
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of instructions
        int n = sc.nextInt();
        sc.nextLine();
        
        // Read "shuffled" keyword
        sc.nextLine();
        
        // Read shuffled instructions
        String[] shuffled = new String[n];
        for (int i = 0; i < n; i++) {
            shuffled[i] = sc.nextLine();
        }
        
        // Read "original" keyword
        sc.nextLine();
        
        // Read original instructions
        String[] original = new String[n];
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextLine();
        }
        
        // Map each instruction in original to its position
        Map<String, Integer> originalPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            originalPos.put(original[i], i);
        }
        
        // Convert shuffled array to position array
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = originalPos.get(shuffled[i]);
        }
        
        // Find LIS length
        int lisLength = findLIS(positions);
        
        // Minimum operations = total elements - LIS length
        int minOperations = n - lisLength;
        
        System.out.println(minOperations);
        
        sc.close();
    }
}
