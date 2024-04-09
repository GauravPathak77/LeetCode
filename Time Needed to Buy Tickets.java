class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        while(tickets[k] != 0){
            for(int i=0; i<tickets.length; i++){
                if(tickets[k] == 0){
                    break;
                }
                if(tickets[i] != 0){
                    tickets[i]--;
                    ans++;
                }
            }
        }
        return ans;
    }
}
