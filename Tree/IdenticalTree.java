class IdenticalTree{
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
    public static Node buildtree(int[] arr){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node root =new Node(arr[idx]);
        root.left=buildtree(arr);
        root.right=buildtree(arr);
        return root;
    }
    public static boolean isIdentical(Node root1,Node root2){
        if(root1==null || root2==null){
            return root1==root2;
        }
        boolean left=isIdentical(root1.left,root2.left);
        boolean right=isIdentical(root1.right,root2.right);
        return left && right && root1.data==root2.data;
    }
    public static void main(String[] args){
        int[] arr1={1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        int[] arr2={1,2,-1,-1,3,4,-1,-1,-1,-1};
        idx=-1;
        Node root1=buildtree(arr1);
        idx=-1;
        Node root2=buildtree(arr2);
        boolean res=isIdentical(root1,root2);
        System.out.println(res);
    }
    

}