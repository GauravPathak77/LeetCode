class CustomStack {
    private int[] stack;
    private int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        int result = stack[top];
        top--;
        return result;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, top + 1); i++) {
            stack[i] += val;
        }
    }
}

/* Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
