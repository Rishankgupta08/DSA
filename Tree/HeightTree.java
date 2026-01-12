class HeightTree{
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

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args){
        int[] arr={1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root=buildtree(arr);
        System.out.println("Height of Tree: "+height(root));
    }
    
}