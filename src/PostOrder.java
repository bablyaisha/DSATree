public class PostOrder {
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

    static class BinaryTreee{
        static int idx=-1;
        public static Node treee(int[] nodes){
            idx++;

            if(nodes[idx]==-1) return null;
             Node newNode= new Node(nodes[idx]);
            newNode.left= treee(nodes);
            newNode.right= treee(nodes);

            return newNode;
        }
    }

    public static void postOrder(Node root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");

    }
    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
       BinaryTreee tree1= new BinaryTreee();
        Node root = tree1.treee(nodes);
       postOrder(root);

    }
}
