class NumArray {
    int segment[];
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        segment=new int[4*n];
        build(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        updateNode(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
        
    }
    public void build(int node,int l,int r,int nums[]){
        if(l==r){
            segment[node]=nums[l];
            return;
        }

        int mid=l+(r-l)/2;
        build(2*node+1,l,mid,nums);
        build(2*node+2,mid+1,r,nums);
        segment[node]=segment[2*node+1]+segment[2*node+2];
    }
    public int query(int node,int l,int r,int ql,int qr){
        if(l>qr || r<ql) return 0;
        if(l>=ql && r<=qr) return segment[node];

        int mid=l+(r-l)/2;
        return (query(2*node+1,l,mid,ql,qr)+query(2*node+2,mid+1,r,ql,qr));
    }
    public void updateNode(int node,int l,int r,int idx,int val){
        if(l==idx && r==idx){
            segment[node]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(idx<=mid){
            updateNode(2*node+1,l,mid,idx,val);
        }else{
            updateNode(2*node+2,mid+1,r,idx,val);
        }

        segment[node]=segment[2*node+1]+segment[2*node+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */