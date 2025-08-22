class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n==0) return 0;
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        int totalwater=0;
        leftmax[0]=height[0];
        for(int i=1;i<n;i++){
            if(height[i]>leftmax[i-1]){
                leftmax[i]=height[i];
            }
            else{
                leftmax[i]=leftmax[i-1];
            }
        }
        rightmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            if(height[i]>rightmax[i+1]){
                rightmax[i]=height[i];
            }
            else{
                rightmax[i]=rightmax[i+1];
            }
        }
        for(int i=0;i<n;i++){
            int minheight;
            if(leftmax[i]<rightmax[i]){
                minheight=leftmax[i];
            }
            else{
                minheight=rightmax[i];
            }
            if(minheight>height[i]){
                totalwater+=(minheight-height[i]);
            }
        }
        return totalwater;
        
    }
}