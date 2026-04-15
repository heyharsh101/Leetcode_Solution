class CustomStack {
    int[] stack;
    int[] inc;
    int size;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
        size = -1;    
    }
    
    public void push(int x) {
        if(size < stack.length -1){
            size++;
            stack[size] = x;
        }
    }
    
    public int pop() {
        if(size == -1) return -1;

        int res = stack[size] + inc[size];

        if(size > 0){
            inc[size -1] += inc[size];
        }
        inc[size] = 0;
        size--;

        return res;
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k - 1, size);
        if(limit >= 0){
            inc[limit] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */