class Solution {
    public int totalMoney(int n) {
        int ans = 0, prev = 0, itr = 1;
        for(int i=1; i<=n; i++){
            if((i-1)%7 == ){
                itr = prev+1;
                ans += itr;
                prev++;
            }else{
                itr++;
                ans += itr;
            }
        }
        return ans;
    }
}
