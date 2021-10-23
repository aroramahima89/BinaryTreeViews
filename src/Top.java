import java.util.*;

class Top {
    public static void topView(Node root) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> val = new ArrayList<Integer>();
        ArrayList<Integer> fre = new ArrayList<Integer>();
        //  ArrayList<Integer> res=new ArrayList<Integer>();

        Stack<Node> s = new Stack<Node>();
        s.push(root);
        a.add(0);
        val.add(root.data);
        fre.add(0);

        while (!s.isEmpty()) {
            Node temp = s.pop();
            int x = fre.get(val.indexOf(temp.data));

            if (temp.right != null) {
                s.push(temp.right);
                if (!a.contains(x + 1)) {
                    a.add(x + 1);
                }
                val.add(temp.right.data);
                fre.add(x + 1);
            }
            if (temp.left != null) {
                s.push(temp.left);
                if (!a.contains(x - 1)) {
                    a.add(x - 1);
                }
                val.add(temp.left.data);
                fre.add(x - 1);
            }
        }

        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            int in = fre.indexOf(a.get(i));
            //   res.add(val.get(in));
            System.out.print(val.get(in) + " ");
        }


    }
}
