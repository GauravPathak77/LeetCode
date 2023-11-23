class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int idx=0;
        List<Boolean> ans = new ArrayList<>();
        while(idx < l.length){
            ans.add(isArthimetic(nums, l[idx], r[idx]));
            idx++;
        }
        return ans;
    }
    boolean isArthimetic(int nums[], int i, int j){
        int temp[] = new int[j-i+1];
        for(int m=0; m<temp.length; m++){
            temp[m] = nums[i];
            i++;
        }
        Arrays.sort(temp);
        int diff = temp[1] - temp[0];
        for(int m=1; m<temp.length; m++){
            if(temp[m] - temp[m-1] != diff){
                return false;
            }
        }
        return true;
    }
}
