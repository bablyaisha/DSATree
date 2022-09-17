public class BST_Seach {
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
    //Searching in BST
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data>key){  //search in left subtree
            return search(root.left,key);
        }else if(root.data==key){
            return true;
        }
        else{   //search in right subtree
            return search(root.right,key);
        }
    }
    public static void main(String[] args) {
        int[] values= {8,1,3,5,4,6,10,11,14};
        Node root= null;

        //to traverse all values and insert in BST
        for (int i = 0; i < values.length; i++) {
            root= insert(root,values[i]);
        }
        if(search(root,1)){
            System.out.println("Key Found");
        }else{
            System.out.println("Key not Found");
        }

    }
}
