class StackNode {
    int val;
    int currMin;
    StackNode next;

    StackNode(){

    }

    StackNode(int val, int currMin, StackNode next){
        this.val = val;
        this.currMin = currMin;
        this.next = next;
    }
}
class MinStack {
    
    StackNode head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null){
            head = new StackNode(val, val, null);
        }else{
            StackNode nextNode = head;
            head = new StackNode(val, Math.min(val, head.currMin), nextNode);
        }
    }
    
    public void pop() {
        head = head.next;   
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.currMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */