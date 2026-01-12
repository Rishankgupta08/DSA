import java.util.Scanner;
public class Name{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(q-- >0){
            String s=sc.next();
            String t=sc.next();
            int[]  freq=new int[26];
            for(int i=0;i<s.length();i++){
                freq[s.charAt(i)-'a']++;
            }
            for(int i=0;i<t.length();i++){
                freq[t.charAt(i)-'a']--;
            }
            boolean same = true;
            for(int i=0;i<26;i++){
                if(freq[i]!=0){
                    same = false;
                    break;
                }
            }
            if (same) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}