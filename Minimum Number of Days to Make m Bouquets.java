class Solution {
    public boolean minDaysUtil(int[] arr, int m, int k, int mid){
		int i = 0, j = 0;

		for(int idx=0; idx<arr.length; idx++){
			if(arr[idx] <= mid) {
				j++;
				if(j == k){
					i++;
					if(i == m){
						return true;
					}
					j = 0;
				}
			}
			else {
				j = 0;
			}
		}
		return false;
	}
    public int minDays(int[] arr, int m, int k){
        if(m*k > arr.length){
			return -1;
		}

		int l = arr[0], h = arr[0], mid;

		for (int i=0; i<arr.length; i++){
			if(arr[i] < l){
				l = arr[i];
			}
			if(arr[i]>h){
				h = arr[i];
			}
		}
        
		int min = -1;
		while(l <= h){
			mid = (l+h)/2;
			if(minDaysUtil(arr, m, k, mid)){
				min = mid;
				h = mid-1;
			}
			else {
				l = mid+1;
			}
		}
		return min;
	}
}
