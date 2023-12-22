class Solution {
    public int maxScore(String s) {
       int ans = Integer.MIN_VALUE;

       for(int i=1; i<s.length(); i++){
           int zeroes = 0, ones = 0;
           for(int k=i-1; k>=0; k--){
               if(s.charAt(k) == '0'){
                   zeroes++;
               }
           }
           for(int j=i; j<s.length(); j++){
               if(s.charAt(j) == '1'){
                   ones++;
               }
           }
           ans = Math.max(ans, (zeroes+ones));
       }
       return ans;
    }
}
