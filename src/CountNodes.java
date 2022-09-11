public class CountNodes {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data ){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int index=-1;
        public static Node tree(int[] nodes){
            index++;
            if(nodes[index]== -1){
                return null;
            }
            Node newNode= new Node(nodes[index]);
            newNode.left= tree(nodes);
            newNode.right= tree(nodes);

            return newNode;

        }
    }

    public static int countOfNodes(Node root){
           if(root==null) return 0;
           int leftCount= countOfNodes(root.left);
           int rightCount= countOfNodes(root.right);

           return leftCount+rightCount+1;
    }
    public static void main(String[] args) {
        int[] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

       BinaryTree trees= new BinaryTree();
        Node root= trees.tree(nodes);
        System.out.println("Count of Nodes is: "+countOfNodes(root));

    }
}
