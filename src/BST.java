public class BST {
    static class Node{

        int data;
        Node left;
        Node right;

        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }
    //Insertion in Binary Search Tree
    public static Node insert(Node root, int value){
        if(root==null){
            root = new Node(value);
            return root;
        }
        if(root.data>value){
            //insert in left subtree
            root.left= insert(root.left,value);
        }else{
            //insert in right subtree
            root.right= insert(root.right,value);
        }
        return  root;
    }

    //Inorder Traversal to see whether BST is build or not
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    public static void main(String[] args) {
        int[] values= {8,1,3,5,4,6,10,11,14};
        Node root= null;

        //to traverse all values and insert in BST
        for (int i = 0; i < values.length; i++) {
            root= insert(root,values[i]);
        }
        //verifying BST
        inorder(root);
        System.out.println();


    }
}
