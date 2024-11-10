int n = nums.length;
        int[] bitCount = new int[32];
        int currentOR = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentOR |= nums[right];
            
            for (int bit = 0; bit < 32; bit++) {
                if ((nums[right] & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
            
            while (left <= right && currentOR >= k) {
                minLength = Math.min(minLength, right - left + 1);
                
                int updatedOR = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if ((nums[left] & (1 << bit)) != 0) {
                        bitCount[bit]--;
                    }
                    if (bitCount[bit] > 0) {
                        updatedOR |= (1 << bit);
                    }
                }
                currentOR = updatedOR;
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
