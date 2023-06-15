class Node {
    String url;
    Node left;
    Node right;

    public Node(String url) {
        this.url = url;
    }
}
class BrowserHistory {
    Node head;
    Node tail;
    Node curr;
    
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        tail = head;
        curr = head;
    }
    
    public void visit(String url) {
        Node temp = new Node(url);
        curr.right = temp;
        temp.left = curr;
        curr = temp;
        tail = temp;
    }
    
    public String back(int steps) {
        while (curr != null && steps > 0) {
            curr = curr.left;
            steps--;
        }
        if (curr == null) {
            curr = head;
            return head.url;
        }
        else {
            return curr.url;
        }
    }
    
    public String forward(int steps) {
        while (curr != null && steps > 0) {
            curr = curr.right;
            steps--;
        }
        if (curr == null) {
            curr = tail;
            return tail.url;
        }
        else {
            return curr.url;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */