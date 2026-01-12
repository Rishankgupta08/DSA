import java.util.Stack;
class Validparenthesis{
    public static boolean isvalid(String s){
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.peek();
                if ((top == '(' && s.charAt(i) == ')') ||
                    (top == '{' && s.charAt(i)  == '}') ||
                    (top == '[' && s.charAt(i)  == ']')) {
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void  main(String[] args){
        String s="({)";
        System.out.println(isvalid(s));
    }
}