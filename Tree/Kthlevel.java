class Kthlevel{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int idx=-1;
    public static Node buildTree(int[] arr){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node root=new Node(arr[idx]);
        root.left=buildTree(arr);
        root.right=buildTree(arr);
        return root;
    }
    public static void klevel(Node root,int k){
        if(root==null){
            return;
        }
        if(k==1){
            System.out.print(root.data+" ");
        }
        klevel(root.left,k-1);
        klevel(root.right,k-1);
    }
    void main(){
        int[] arr={1,2,7,-1,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root=buildTree(arr);
        klevel(root, 2);

    }
}