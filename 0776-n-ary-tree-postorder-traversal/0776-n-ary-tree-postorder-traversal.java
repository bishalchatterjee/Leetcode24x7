/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if(root == null)
            return list;


        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            List<Node> child = node.children;
            list.addFirst(node.val);
            for(Node n:child){
                stack.push(n);
            }
        }
        return list;
    }
}