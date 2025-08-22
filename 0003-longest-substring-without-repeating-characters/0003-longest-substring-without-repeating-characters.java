class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int[] lastseen=new int[256];
        for(int i=0;i<256;i++){
            lastseen[i]=-1;
        }
        int maxlen=0;
        int start=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(lastseen[ch]>=start){
                start=lastseen[ch]+1;
            }
            lastseen[ch]=i;
            int windowlen=i-start+1;
            if(windowlen>maxlen){
                maxlen=windowlen;
            }
        }
        return maxlen;
        
    }
}