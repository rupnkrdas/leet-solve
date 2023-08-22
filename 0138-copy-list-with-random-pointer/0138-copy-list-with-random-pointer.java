/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node copyNode = new Node(curr.val);
            map.put(curr, copyNode);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            Node copyRandom = map.get(curr.random);
            copy.random = copyRandom;
            copy.next = map.get(curr.next);
            curr = curr.next;
        }

        return map.get(head);
    }
}