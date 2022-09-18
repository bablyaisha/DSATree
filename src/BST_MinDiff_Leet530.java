import java.util.ArrayList;

public class BST_MinDiff_Leet530 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null) {
            root= new Node(val);
            return root;
        }
        if(root.data<val){
            root.right= insert(root.right,val);
        }else {
            root.left=insert(root.left,val);
        }
        return root;
    }
    public static void inorder(Node root, ArrayList<Integer> a){
        if(root==null) return;
        inorder(root.left,a);
        a.add(root.data);
        inorder(root.right,a);
    }
    public static int getMinimumDifference(Node root) {
        ArrayList<Integer> arr= new ArrayList<>();
        int min= Integer.MAX_VALUE;

        inorder(root,arr);
        for(int i=0;i<arr.size()-1;i++){
            if((arr.get(i+1)-arr.get(i))<min){
                min= arr.get(i+1)-arr.get(i);
            }

        }

        return min;
    }
    public static void main(String[] args) {
        int[] values={8,1,3,5,4,6,10,11,14};
       Node root=null;
        for(int i=0;i<values.length;i++){
            root= insert(root,values[i]);
        }
        System.out.println("Minimum difference of BST is: "+getMinimumDifference(root));
    }
}
