public class BST_Delete {
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

    public static Node build(Node root,int value){
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
    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left= delete(root.left,val);
        }else if(root.data<val){
            root.right=delete(root.right,val);
        }else {  //root.data=val
            //case1
            if(root.left==null && root.right==null){
                return null;
            }
            //case2
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //case3
            Node IS= inorderSuccessor(root);
            root.data= IS.data;
            root.right= delete(root.right,IS.data);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int[] values={8,1,3,5,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root= build(root,values[i]);
        }
        System.out.print("Before deletion: ");
        inorder(root);
        System.out.println();
        System.out.print("After deletion: ");
        delete(root,4);
        inorder(root);
    }
}
