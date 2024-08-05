import java.util.*; 
import java.io.*;

// Node class representing a tree node
class Node {
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

// --------------------------------------------------------------------------------(GeeksforGeeks Solution Start)--------------------------------------------------------------------------------


class Solution {
    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> topNode = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node frontNode = temp.node;
            int hd = temp.hd;

            // Put the node data in the map, replacing any existing value
            topNode.put(hd, frontNode.data);

            if (frontNode.left != null) {
                q.add(new Pair(frontNode.left, hd - 1));
            }

            if (frontNode.right != null) {
                q.add(new Pair(frontNode.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : topNode.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}




// --------------------------------------------------------------------------------(GeeksforGeeks Solution end)--------------------------------------------------------------------------------




public class GfG {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length) break;

            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            ArrayList<Integer> res = ob.bottomView(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
        }
    }
}
