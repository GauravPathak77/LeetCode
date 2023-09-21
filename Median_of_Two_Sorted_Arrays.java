class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }
    
    int m = nums1.length;
    int n = nums2.length;
    
    int left = 0, right = m;
    
    while (left <= right) {
        int partitionX = (left + right) / 2;
        int partitionY = (m + n + 1) / 2 - partitionX;
        
        int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
        int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
        
        int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
        int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
        
        if (maxX <= minY && maxY <= minX) {
            if ((m + n) % 2 == 0) {
                return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
            } else {
                return Math.max(maxX, maxY);
            }
        } else if (maxX > minY) {
            right = partitionX - 1;
        } else {
            left = partitionX + 1;
        }
    }
    throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
