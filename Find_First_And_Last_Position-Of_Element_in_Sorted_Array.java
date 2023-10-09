class Solution {
    public static int binarySearchUtil(int[] nums, int first, int last, int target){
        int ans = -1;
        while(first <= last){
            int mid = (first+last)/2;
            if(nums[mid] == target){
                ans = mid;
            }
            if(target < nums[mid]){
                last = mid-1;
            }else{
                first = mid+1;
            }
        }
        return ans;
    }
    public static int binarySearch(int[] nums, int first, int last, int target){
        int ans = -1;
        while(first <= last){
            int mid = (first+last)/2;
            if(nums[mid] == target){
                ans = mid;
            }
            if(target > nums[mid]){
                first = mid+1;
            }else{
                last = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int idx = -1;
        int n = nums.length -1;
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        idx = binarySearch(nums, 0, n, target);
        res[0] = idx;
        if(idx != -1){
            idx = binarySearch(nums, 0, idx-1, target);
            res[0] = idx!=-1 ? idx : res[0];
                idx = binarySearchUtil(nums, res[0]+1, n, target);
                res[1] = idx!=-1 ? idx : res[0];
        }
        return res;
    }
}
