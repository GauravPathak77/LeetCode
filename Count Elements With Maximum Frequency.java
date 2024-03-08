class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int maxfreq = Integer.MIN_VALUE;
        for(Integer key: map.keySet()){
            int freq = map.get(key);
            if(freq == maxfreq){
                ans += freq;
            }
            else if(freq > maxfreq){
                ans = freq;
            }
            maxfreq = Math.max(freq, maxfreq);
        }
        return ans;
    }
}
