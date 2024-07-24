class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
    if (n <= 1) {
        return nums;
    }

    int max = 1;
    for (int num : nums) {
        if (num > max) {
            max = num;
        }
    }

    int[] res = new int[n];
    int[] dig = new int[n];

    for (int p10 = 1; p10 <= max; p10 *= 10) {
        final int tp10 = (p10 == 1) ? 0 : p10;
        int[] freq = new int[10];

        for (int i = n - 1; i >= 0; i--) {
            dig[i] = (nums[i] < tp10) ? 0 : mapping[(nums[i] / p10) % 10];
            freq[dig[i]]++;
        }

        for (int i = 1; i < 10; i++) {
            freq[i] += freq[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            res[--freq[dig[i]]] = nums[i];
        }

        int[] tmp = res;
        res = nums;
        nums = tmp;
    }
    return nums;
    }
}
