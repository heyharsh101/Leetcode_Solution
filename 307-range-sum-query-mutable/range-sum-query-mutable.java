class NumArray {
    int n;
    int[] SegmentTree;

    void build(int i, int l, int r, int[] nums){
        if(l == r){
            SegmentTree[i] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * i+1, l, mid, nums);
        build(2 * i+2, mid+1, r, nums);
        
        SegmentTree[i] = SegmentTree[2*i+1] + SegmentTree[2*i+2];
    }

    void Segmentupdate(int index, int val, int i, int l, int r){
        if(l == r){
            SegmentTree[i] = val;
            return;
        }
        
        int mid = l + (r - l) / 2;
        if(index <= mid){
            Segmentupdate(index, val, 2*i+1, l, mid);
        } else {
            Segmentupdate(index, val, 2*i+2, mid +1, r);
        }
        SegmentTree[i] = SegmentTree[2 * i +1] + SegmentTree[2 * i +2];
    }

    int querySum(int start, int end, int i, int l, int r){
        if(l > end || r < start){
            return 0;
        }

        if(l >= start && r <= end){
            return SegmentTree[i];
        }
        int mid = l + (r - l) / 2;
        int sum = querySum(start, end, 2*i+1, l, mid) + querySum(start, end, 2*i+2, mid+1, r);
        return sum;
    }
    public NumArray(int[] nums) {
        n = nums.length;
        SegmentTree = new int[4*n];
        build(0, 0, n-1, nums);    
    }
    
    public void update(int index, int val) {
        Segmentupdate(index, val, 0, 0, n-1);
    }
    
    public int sumRange(int left, int right) {
        return querySum(left, right, 0, 0, n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */