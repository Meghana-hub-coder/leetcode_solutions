class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int h;
            if(height[left]<height[right]){
                h=height[left];
            }
            else{
                h=height[right];
            }
            int w=right-left;
            int area=h*w;
            if(area>max){
                max=area;
            }
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
        
    }
}