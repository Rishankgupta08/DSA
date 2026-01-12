import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
class TopView{
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
    public static void main(String[] args){
        int[] arr={1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root =buildtree(arr);
        topview(root);
    }
    public static void topview(Node root){
        if(root==null){
            return;
        }
        class Pair {
            Node node;
            int hd;
            Pair(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int minHd = 0, maxHd = 0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;
            if(!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            if(node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
                minHd = Math.min(minHd, hd - 1);
            }
            if(node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
                maxHd = Math.max(maxHd, hd + 1);
            }
        }
        // Print top view
        for(int i = minHd; i <= maxHd; i++) {
            if(map.containsKey(i)) {
                System.out.print(map.get(i) + " ");
            }
        }
        System.out.println();
    }
}