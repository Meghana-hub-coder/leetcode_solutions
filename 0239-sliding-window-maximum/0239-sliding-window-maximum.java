class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n==0) return new int[0];
        int[] result=new int[n-k+1];
        int[] deque=new int[n];
        int front=0,back=-1;
        int resindex=0;
        for(int i=0;i<n;i++){
            while(back>=front && nums[deque[back]]<=nums[i]){
                back--;
            }
            back++;
            deque[back]=i;
            if(deque[front]<=i-k){
                front++;
            }
            if(i>=k-1){
                result[resindex]=nums[deque[front]];
                resindex++;
            }
        }
        return result;
        
    }
}