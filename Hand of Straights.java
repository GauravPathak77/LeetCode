class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        } 
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for(int i=0; i<hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }

        for(int data: hand){
            if(map.getOrDefault(data, 0) != 0) {
                for(int i=0; i<groupSize; i++){
                    if(map.getOrDefault(data+i, 0) == 0) {
                        return false;
                    }
                    map.put(data+i, map.get(data+i)-1);
                }
            }
        }
        return true;
    }
}
