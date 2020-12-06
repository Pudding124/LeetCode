/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(root);
        BFS(queue);
        return root;
    }
    
    public void BFS(ArrayList<Node> queue) {
        
        ArrayList<Node> newQueue = new ArrayList<>();
        for(int i = 0;i<queue.size();i++) {
            if(i+1 < queue.size()) {
                queue.get(i).next = queue.get(i+1);
            } else {
                queue.get(i).next = null;
            }
            
            if(queue.get(i).left != null) {
                newQueue.add(queue.get(i).left);
            }
            if(queue.get(i).right != null) {
                newQueue.add(queue.get(i).right);
            }
        }
        
        if(newQueue.size() != 0) {
            BFS(newQueue);
        }
    }
}