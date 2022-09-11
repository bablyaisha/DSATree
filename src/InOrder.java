public class InOrder {
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

    static class BinaryTree3{
        static int idx=-1;
        public static Node tree3(int[] nodes){
            idx++;

            if(nodes[idx]==-1) return null;
            Node newNode= new Node(nodes[idx]);
            newNode.left= tree3(nodes);
            newNode.right= tree3(nodes);

            return newNode;
        }
    }

    public static void inOrder(Node root){
        if (root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
       int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
       BinaryTree3 trees= new BinaryTree3();
       Node root= trees.tree3(nodes);

       inOrder(root);

    }
}
