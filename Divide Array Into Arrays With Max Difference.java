class Solution {
    public int[][] divideArray(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i % 3 == 0) {
                if (i != 0) {
                    list.add(temp);
                    if(temp.get(2) - temp.get(1) > k || temp.get(2) - temp.get(0) > k || temp.get(1) - temp.get(0) > k){
                        return new int[0][0];
                    }
                }
                temp = new ArrayList<>();
            }
            
            temp.add(nums[i]);
        }
        
        list.add(temp);
        if(temp.get(2) - temp.get(1) > k || temp.get(2) - temp.get(0) > k || temp.get(1) - temp.get(0) > k){
            return new int[0][0];
        }
        
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                ans[i][j] = list.get(i).get(j);
            }
        }
        
        return ans;
    }
}
