class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int longestChain = 1;
        for(String word : words){
            int maxChain = 1;
            for(int i=0; i<word.length(); i++){
                StringBuilder pred = new StringBuilder(word);
                pred.deleteCharAt(i);
                String predStr = pred.toString();
                if(dp.containsKey(predStr)){
                    maxChain = Math.max(maxChain, dp.get(predStr)+1);
                }
            dp.put(word, maxChain);
            longestChain = Math.max(longestChain, maxChain);
            }
        }
        return longestChain;
    }
}
