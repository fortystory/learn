/*
 * @lc app=leetcode.cn id=232 lang=java
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了70.37% 的用户
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    private Stack<Integer> sin;
    private Stack<Integer> sout;
    /** Initialize your data structure here. */
    public MyQueue() {
        sin = new Stack<Integer>();
        sout = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        sin.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(sout.isEmpty()){
            inToOut();
        }
        return sout.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(sout.isEmpty()){
            inToOut();
        }
        return sout.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return sin.isEmpty() && sout.isEmpty();
    }

    private void inToOut(){
        while(!sin.isEmpty()){
            sout.push(sin.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

