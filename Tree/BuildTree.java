import java.util.Queue;
import java.util.LinkedList;
class BuildTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    static int idx=-1;
    
    public static Node buildtree(int[] arr){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node root=new Node(arr[idx]);
        root.left=buildtree(arr);
        root.right=buildtree(arr);
        return root;
    }
    public static void preTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        preTraversal(root.left);
        preTraversal(root.right);
    }
    public static void inTraversal(Node root){
        if(root == null){
            return;
        }
        inTraversal(root.left);
        System.out.print(root.data +" ");
        inTraversal(root.right);
    }
    public static void  postTraversal(Node root){
         if(root == null){
            return;
        }
        postTraversal(root.left);
        postTraversal(root.right);
        System.out.print(root.data +" ");
    }
    public static void levelTraversal(Node root){
        if (root == null) return;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node curr=q.peek();
            q.poll();
            if(curr==null){
                if(!q.isEmpty()){
                    System.out.println();
                    q.offer(null);
                    continue;
                }else{
                    break;
                }
            }
            System.out.print(curr.data +" ");
            if(curr.left != null){
                q.offer(curr.left);
            }
            if (curr.right !=null) {
                q.offer(curr.right);
            }

        }
    }
    public static void main(String[] a){
        int[] arr={1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root=buildtree(arr);
        System.out.println(root.data);
        preTraversal(root);
        System.out.println();
        inTraversal(root);
        System.out.println();
        postTraversal(root);
        System.out.println();
        levelTraversal(root);
    }

}