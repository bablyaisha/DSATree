import java.util.ArrayList;
import java.util.List;

public class LeftAndRightView {

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
    //Right View
    /*
                  1
              2       3            RV= 1 3 6
            4   5        6
     */
    static List<Integer> rightSideView(Node root){
        List<Integer> result= new ArrayList<>();
        rightView(root,result,0);
        return result;
    }
    static void rightView(Node node,List<Integer> result,int level){
            if(node==null) return;
            if(level==result.size()) {
                result.add(node.data);
            }
            rightView(node.right,result,level+1);
            rightView(node.left,result,level+1);

    }
    //Left View
    /*
                  1
              2       3            LV= 1 2 4
            4   5        6
     */
    static List<Integer> leftSideView(Node root){
        List<Integer> res= new ArrayList<>();
        leftView(root,res,0);
        return res;
    }

    static void leftView(Node root, List<Integer> res, int level) {
        if (root==null) return;
        if(level==res.size()) res.add(root.data);
        leftView(root.left,res,level+1);
        leftView(root.right,res,level+1);

    }

    public static void main(String[] args) {
        int[] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
        Node root= tree.buildTree(nodes);
        System.out.println("Right view of tree: "+rightSideView(root));
        System.out.println("Left view of tree: "+leftSideView(root));
    }
}
