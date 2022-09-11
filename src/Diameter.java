public class Diameter {
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
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1) return null;
            Node newNode= new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;

        }
    }
    // Approach 1 T(n)= O(n^2)

    public static int height(Node root){
        if(root==null) return 0;
        int leftht= height(root.left);
        int rightht= height(root.right);

        return Math.max(leftht,rightht)+1;
    }

    public static int diameter1(Node root) {
          if(root == null) return 0;

          int dia1= diameter1(root.left);
          int dia2= diameter1(root.right);
          int dia3= height(root.left)+height(root.right)+1;

          int myDiameter= Math.max(Math.max(dia1,dia2),dia3);
          return myDiameter;
    }
    //Approach 2 T(n)=O(n)

    static class Treeinfo{
        int ht;
        int dia;

        Treeinfo(int ht,int dia){
            this.ht=ht;
            this.dia=dia;
        }
    }

    public static Treeinfo diameter2(Node root){
        if(root==null) {return  new Treeinfo(0,0);}

      Treeinfo left=diameter2(root.left);
       Treeinfo right=diameter2(root.right);
         int myht= Math.max(left.ht,right.ht)+1;

         int d1= left.dia;
         int d2= right.dia;
         int d3= left.ht+right.ht+1;

         int diameter= Math.max(Math.max(d1,d2),d3);

         Treeinfo treeinfo= new Treeinfo(myht,diameter);

         return treeinfo;

    }
    public static void main(String[] args) {
        int[] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
        Node root= tree.buildTree(nodes);
        System.out.println("Diameter of Tree by approach 1 is: "+diameter1(root));
        System.out.println("Diameter of Tree by approach 2 is: "+diameter2(root).dia);
    }

}
