class Solution {
    public int pivotIndex(int[] nums) {
        int pivot=-1;
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int leftsum=0;
        for(int i=0;i<n;i++){
            if(leftsum==sum-leftsum-nums[i]){
                return i;
            }
            leftsum+=nums[i];
        }
        return pivot;
    }
}