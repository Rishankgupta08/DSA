import java.util.*;

public class ABCChallenge {
    public static int countShifts(char[] original, char[] target) {
        int n = original.length;
        char[] orig = new char[n];
        System.arraycopy(original, 0, orig, 0, n);
        int shifts = 0;
        for (int i = 0; i < n; i++) {
            if (orig[i] == target[i]) {
                continue;
            }
            int j = i + 1;
            while (j < n && orig[j] != target[i]) {
                j++;
            }
            if (j == n) {
                return Integer.MAX_VALUE;  
            }
            char element = orig[j];
            for (int k = j; k > i; k--) {
                orig[k] = orig[k - 1];
            }
            orig[i] = element;
            shifts++;
        }
        
        return shifts;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] itemsStr = sc.nextLine().split(" ");
        char[] items = new char[n];
        for (int i = 0; i < n; i++) {
            items[i] = itemsStr[i].charAt(0);
        }
        
        String[] fixedPosStr = sc.nextLine().split(" ");
        int[] fixedPositions = new int[fixedPosStr.length];
        for (int i = 0; i < fixedPosStr.length; i++) {
            fixedPositions[i] = Integer.parseInt(fixedPosStr[i]) - 1; 
        }
        int countA = 0, countB = 0, countC = 0;
        for (char c : items) {
            if (c == 'A') countA++;
            else if (c == 'B') countB++;
            else if (c == 'C') countC++;
        }
        Map<Integer, Character> fixedChars = new HashMap<>();
        for (int pos : fixedPositions) {
            fixedChars.put(pos, items[pos]);
        }
        String[] orderings = {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};
        int minShifts = Integer.MAX_VALUE;
        
        for (String order : orderings) {
            char[] target = new char[n];
            int idx = 0;
            
            for (char c : order.toCharArray()) {
                int count = 0;
                if (c == 'A') count = countA;
                else if (c == 'B') count = countB;
                else if (c == 'C') count = countC;
                
                for (int i = 0; i < count; i++) {
                    target[idx++] = c;
                }
            }
            boolean valid = true;
            for (Map.Entry<Integer, Character> entry : fixedChars.entrySet()) {
                if (target[entry.getKey()] != entry.getValue()) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                int shifts = countShifts(items, target);
                minShifts = Math.min(minShifts, shifts);
            }
        }
        
        if (minShifts == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(minShifts);
        }
        sc.close();
    }
}
