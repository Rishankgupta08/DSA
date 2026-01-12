import java.util.Scanner;

public class CountVowel{
    private static int countvowels(String s,int i) {
        if (i== s.length()) return 0;
        if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u') {
            return 1 + countvowels(s, i + 1);
        } else {
            return countvowels(s, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume end of line after the integer

        while (t-- > 0) {
            String s = sc.nextLine(); // read full line (may contain spaces)
            if (s == null) s = "";
            s = s.toLowerCase();
            System.out.println(countvowels(s, 0));
        }

        sc.close();
    }
}
