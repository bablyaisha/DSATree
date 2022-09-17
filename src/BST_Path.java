import java.util.ArrayList;

public class BST_Path {
    static class Node{
        int data;
       Node left;
       Node right;

        Node(int data){
            this.data=data;
        }
    }
    public static Node build(Node root, int value){
        if(root==null){
            root= new Node(value);
            return root;
        }
        if(root.data>value){
            root.left= build(root.left,value);
        }else{
            root.right= build(root.right,value);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {

            System.out.print(path.get(i)+" ");

        }
        System.out.println();
    }
    public static void printRoot2Path(Node root, ArrayList<Integer> path){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null) printPath(path);
        else {
            printRoot2Path(root.left,path);
            printRoot2Path(root.right,path);
        }

       path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int[] values={8,1,3,5,4,6,10,11,14};
      Node root=null;
        for(int i=0;i<values.length;i++){
            root= build(root,values[i]);
        }
        inorder(root);
        System.out.println();

        printRoot2Path(root,new ArrayList<>());
    }
}
