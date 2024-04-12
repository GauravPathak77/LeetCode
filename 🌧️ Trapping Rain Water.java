class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans[] = new int[n];
        int max = 0;
        for(int i=n-1; i>=0; i--)
        {
            if(max<height[i]){
                max = height[i];
            }
            ans[i] = max;
        }
        max = 0;
        int res = 0;
        for(int i=0;i<n;i++)
        {   if(max<height[i]){
            max = height[i];
        }
            res += Math.min(max,ans[i]) - height[i];
        }

        return res;
    }
}
