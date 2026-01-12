import java.util.Stack;
import java.util.Arrays;
class NGER{
    public static void main(String[] args){
        int[] arr={6,8,0,1,3};
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=arr[st.peek()];
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
}