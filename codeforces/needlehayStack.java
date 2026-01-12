import java.util.*;
public class needlehayStack{
    public static String hayStack(String s , String t){
         int[] freq=new int[26];
         for(int i=0;i<t.length();i++){
            freq[t.charAt(i) - 'a']++;
         }
         for(int i=0;i<s.length();i++){
			freq[s.charAt(i)-'a']--;
		 }
		 for(int f: freq){
			if(f<0){
				return "Impossible";
			}
		 }
		 StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 26 ; i++){
            for(int j = 0 ; j < freq[i] ; j++){
                sb.append((char)('a' + i));
            }
        }
		int f1=0;
		int f2=0;
		StringBuilder res=new StringBuilder();
		while(f1<s.length() && f2<sb.length()){
			if(s.charAt(f1)<=sb.charAt(f2)){
				res.append(s.charAt(f1));
				f1++;
			}else{
				res.append(sb.charAt(f2));
				f2++;
			}
		}
		while(f1<s.length()){
			res.append(s.charAt(f1));
			f1++;
		}
		while(f2<sb.length()){
			res.append(sb.charAt(f2));
			f2++;
		}
		return res.toString();
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n --> 0){
		    String s = sc.next();
		    String t = sc.next();
		    System.out.println(hayStack(s,t));
		}
		sc.close();
	}
}