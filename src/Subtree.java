
 //Leet Code 572
public class Subtree {
    static class Node{
         int val;
         Node left;
         Node right;

         Node(int val){
             this.val=val;
             this.left=null;
             this.right=null;
         }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1) return null;
            Node newNode= new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
    }
    public static boolean isIdentical(Node root, Node subroot){
        if(root==null && subroot==null) return true;
        if (root==null || subroot==null) return false;

        if(root.val==subroot.val){
            return isIdentical(root.left,subroot.left)&&isIdentical(root.right,subroot.right);
        }
        return false;
    }

    public static boolean isSubtree(Node root, Node subroot){
          if(subroot==null) return true;
          if(root==null) return false;

          if(root.val==subroot.val){
              if(isIdentical(root,subroot)){
                  return true;
              }
          }
          return isSubtree(root.left,subroot)|| isSubtree(root.right,subroot);
    }

    public static void main(String[] args) {
        int[] nodes= {9,7,8,1,2,3,4,5,6};

        BinaryTree tree= new BinaryTree();
        Node root= tree.buildTree(nodes);
    }
}
