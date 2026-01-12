import java.util.*;
class BackTracking{
    public static void PrintPerm(String str,String perm,int idx){
        if ("".equals(str)){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            char CurrChar=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            PrintPerm(newStr,perm+CurrChar,idx+1);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        PrintPerm(str,"",0);
        sc.close();
    }
    
}