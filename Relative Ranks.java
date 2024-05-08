class Solution {
    public class Athelete{
        int idx;
        int value;
        public Athelete(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        String ans[] = new String[score.length];
        List<Athelete> list = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            list.add(new Athelete(i, score[i]));
        }

        Collections.sort(list, (o1, o2) -> o2.value - o1.value);
        
        if(list.size() != 0){
            ans[list.get(0).idx] = "Gold Medal";
            list.remove(0);
        }
        if(list.size() != 0){
            ans[list.get(0).idx] = "Silver Medal";
            list.remove(0);
        }
        if(list.size() != 0){
            ans[list.get(0).idx] = "Bronze Medal";
            list.remove(0);
        }       

        int val = 4;
        while(list.size() != 0){
            ans[list.get(0).idx] = String.valueOf(val++);
            list.remove(0);
        }
        return ans;
    }
}
