import java.util.*;

public class BottomView {
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
    static class Pair{
        Node root;
        int hd;
        Pair(Node root, int hd){
            this.root=root;
            this.hd=hd;
        }
    }
    static class BinaryTree{
        static int idx=-1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if(nodes[idx]==-1) return null;
            Node currNode= new Node(nodes[idx]);
            currNode.left= buildTree(nodes);
            currNode.right=buildTree(nodes);

            return currNode;
        }
    }
    public static void main(String[] args) {
        int[] nodes= {1,2,4,5,3,6};
       BinaryTree tree= new BinaryTree();
       Node root= tree.buildTree(nodes);
        System.out.println("Bottom view of tree: "+bottomView(root));

    }

    static ArrayList<Integer> bottomView(Node root) {
         Queue<Pair> q= new ArrayDeque<>();
         Map<Integer,Integer> map= new TreeMap<>();
         q.add(new Pair(root,0));
         while (!q.isEmpty()){
             Pair cur= q.poll();
             map.put(cur.root.data,cur.hd);
             if (cur.root.left!=null){
                 q.add(new Pair(cur.root.left,cur.hd-1));
             }
             if (cur.root.right!=null){
                 q.add(new Pair(cur.root.right,cur.hd+1));
             }
         }
         ArrayList<Integer> ans= new ArrayList<>();
         if (root==null) return ans;
         for (Map.Entry<Integer,Integer> entry: map.entrySet()){
             ans.add(entry.getValue());
         }
         return ans;
    }
}
