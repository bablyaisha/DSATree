public class PreOrder {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= null;
            this.right= null;
        }
    }

    static class BinaryTree1{
        static int idx=-1;
        public static Node buildTree1(int[] nodes){
            idx++;
            if(nodes[idx]== -1){
                return null;
            }
            Node newNode= new Node(nodes[idx]);
            newNode.left= buildTree1(nodes);
            newNode.right= buildTree1(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root){
          if(root==null){
              return;
          }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {

        int[] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree1 tree= new BinaryTree1();
        Node root= tree.buildTree1(nodes);
        preOrder(root);
    }
}
