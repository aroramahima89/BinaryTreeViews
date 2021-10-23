import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TopView {

    /*
    
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        Map<Integer,ArrayList> h=new  HashMap<Integer,ArrayList>();

        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(root.data);
        h.put(0,a);

        Queue<Node> q=new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp=q.peek();
            q.remove();
            int val=0;
            for (Map.Entry<Integer, ArrayList> set : h.entrySet()) {
                if(set.getValue().contains(temp.data)){
                    val=set.getKey();
                }
            }

            if(temp.left!=null){
                if(h.containsKey(val-1)){
                    for (Map.Entry<Integer, ArrayList> set : h.entrySet()) {
                        if(set.getKey()==val-1){
                            set.getValue().add(temp.right.data);
                        }
                    }
                }
                else{
                    ArrayList<Integer> arr=new ArrayList<Integer>();
                    arr.add(temp.left.data);
                    h.put(val-1,arr);
                }
                q.add(temp.left);
            }
            if(temp.right!=null){
                if(h.containsKey(val+1)){
                    for (Map.Entry<Integer, ArrayList> set : h.entrySet()) {
                        if(set.getKey()==val+1){
                            set.getValue().add(temp.right.data);
                        }
                    }
                    //  h.get(val+1).add(temp.right.data);
                }
                else{
                    ArrayList<Integer> arr=new ArrayList<Integer>();
                    arr.add(temp.right.data);
                    h.put(val+1,arr);
                }
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer, ArrayList> set : h.entrySet()) {
            System.out.print(set.getValue().get(0)+" ");
        }
      
 /*     while(!q.isEmpty()){
          Node temp=q.peek();
          q.remove();
          if(temp.left!=null){
              h.put(temp.left.data,h.get(temp.data)-1);
              q.add(temp.left);
          }
          if(temp.right!=null){
            h.put(temp.right.data,h.get(temp.data)+1);
            q.add(temp.right); 
          }
      }
      */

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}