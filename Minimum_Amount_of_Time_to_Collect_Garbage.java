class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int gIdx=0, pIdx=0, mIdx=0;
        int ans = 0;

        for(int i=0; i<garbage.length; i++){
            ans += garbage[i].length();
            if(garbage[i].contains("P")){
                pIdx = i;
            }
            if(garbage[i].contains("G")){
                gIdx = i;
            }
            if(garbage[i].contains("M")){
                mIdx = i;
            }
        }

        for(int i=0; i<pIdx; i++){
            ans += travel[i];
        }

        for(int i=0; i<gIdx; i++){
            ans += travel[i];
        }

        for(int i=0; i<mIdx; i++){
            ans += travel[i];
        }

        return ans;
    }
}
