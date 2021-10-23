import java.util.*;
class VerticalOrder
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> val=new ArrayList<Integer>();
        ArrayList<Integer> fre=new ArrayList<Integer>();
        ArrayList<Integer> res=new ArrayList<Integer>();

        Stack<Node> q=new Stack<Node>();
        q.push(root);
        val.add(root.data);
        a.add(0);
        fre.add(0);

        while(!q.isEmpty()){
            Node temp=q.pop();
            int in=fre.get(val.indexOf(temp.data));

            if(temp.right!=null){
                q.push(temp.right);
                if(!a.contains(in+1)){
                    a.add(in+1);
                }
                val.add(temp.right.data);
                fre.add(in+1);
            }

            if(temp.left!=null){
                q.push(temp.left);
                if(!a.contains(in-1)){
                    a.add(in-1);
                }
                val.add(temp.left.data);
                fre.add(in-1);
            }
        }

        Collections.sort(a);

        for(int i=0;i<a.size();i++){
            while(fre.contains(a.get(i))){
                int index=fre.indexOf(a.get(i));
                fre.set(index,Integer.MIN_VALUE);
                res.add(val.get(index));
            }
        }
        return res;
    }
}