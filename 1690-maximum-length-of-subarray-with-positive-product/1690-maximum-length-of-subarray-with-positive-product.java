class Solution {
    public int getMaxLen(int[] nums) {
        int start = 0;
        int maxlength = 0;
        int negativecount =0;
        int firstnegative = -1;

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == 0){
                start = i+1;
                negativecount = 0;
                firstnegative = -1;
            }else{
                if(nums[i]<0){
                    negativecount++;
                
                if(firstnegative == -1){
                    firstnegative = i;
                }
                }
            
            if(negativecount %2==0){
                maxlength = Math.max(maxlength , i-start+1);
            }else{
                maxlength = Math.max(maxlength , i-firstnegative);
            }
            }
        }
        return maxlength;
    }
}