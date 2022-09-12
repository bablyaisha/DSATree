import java.util.*;

public class TopView {

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
    static class Pair{
          Node root;
          int hd;
          Pair(Node root,int hd){
              this.root=root;
              this.hd=hd;
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

     static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
         Map<Integer,Integer> map = new TreeMap<>();
         Queue<Pair> q= new LinkedList<Pair>();
         q.add(new Pair(root,0));
         while (!q.isEmpty()){
             Pair it= q.remove();
             int hd= it.hd;
             Node temp= it.root;
             if(map.get(hd)==null) map.put(hd,temp.data);
             if(temp.left!=null){
                 q.add(new Pair(temp.left,hd-1));
             }
             if(temp.right!=null){
                 q.add(new Pair(temp.right,hd+1));
             }

         }
         for (Map.Entry<Integer,Integer> entry: map.entrySet()){
             ans.add(entry.getValue());
         }
         return ans;

    }
    //Code 2
    static ArrayList<Integer> topView2(Node root) {
    Map<Integer,Integer> map = new TreeMap<>();
    Queue<Pair> q= new ArrayDeque<>();
         q.add(new Pair(root,0));
         while (!q.isEmpty()){
        Pair curr= q.poll();
        if(!map.containsKey(curr.hd)){map.put(curr.hd,curr.root.data);}
        if(curr.root.left!=null){
            q.add(new Pair(curr.root.left,curr.hd-1));
        }
        if(curr.root.right!=null){
            q.add(new Pair(curr.root.right,curr.hd+1));
        }

    }
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
         for (Map.Entry<Integer,Integer> entry: map.entrySet()){
        ans.add(entry.getValue());
    }
         return ans;

}
    public static void main(String[] args) {
        int[] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
       Node root= tree.buildTree(nodes);
        System.out.println("Top view of tree: "+topView(root));
        System.out.println("Top view2 of tree: "+topView2(root));

    }


}
