import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class non_repeating {
    // Function to return the first non-repeating character at each point in the stream
    public String FirstNonRepeating(String A) {
        int[] freq = new int[26]; // Frequency array for lowercase letters
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            // Update frequency
            freq[ch - 'a']++;
            // Add to queue
            q.offer(ch);
            // Remove characters from queue that are repeating
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // Append first non-repeating character or '#' if none
            if (!q.isEmpty()) {
                ans.append(q.peek());
            } else {
                ans.append('#');
            }
        }

        return ans.toString();
    }
}

public class FirstNonRepeatingCharacterOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        sc.nextLine();         // Consume newline

        while (tc-- > 0) {
            String A = sc.nextLine();
            non_repeating obj = new non_repeating();
            String ans = obj.FirstNonRepeating(A);
            System.out.println(ans);
        }

        sc.close();
    }
}
