class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int currentsum=0;
        for(int i=0;i<k;i++){
            currentsum+=nums[i];
        }
        int maxsum=currentsum;
        for(int i=k;i<n;i++){
            currentsum+=nums[i]-nums[i-k];
            if(currentsum>maxsum){
                maxsum=currentsum;
            }
        }
        return (double)maxsum/k;

    }
}