class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int length=nums.length+1;//max length
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                sum-=nums[i];
                length = Math.min(length, j - i + 1);
                i++;
            }
            j++;
        }
        return (length==nums.length+1)?0:length;
    }
}