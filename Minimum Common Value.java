class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for(int i=0; i<nums1.length; i++){
            int first = 0, last = nums2.length - 1;
            while(first <= last){
                int mid = (first + last)/2;
                if(nums2[mid] == nums1[i]){
                    return nums1[i];
                }
                else if(nums2[mid] < nums1[i]){
                    first = mid+1;
                }
                else{
                    last = mid-1;
                }
            }
        }
        return -1;
    }
}
