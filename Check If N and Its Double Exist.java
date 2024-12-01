class Solution {
    public boolean checkIfExist(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int zeroCount = 0;

        for(int num : arr) {
            list.add(num);
            if(num == 0) zeroCount++;
        }

        for(int num : arr) {
            if(num == 0 && zeroCount > 1) {
                return true;
            }
            if(num != 0 && list.contains(2*num)) {
                return true;
            }
        }

        return false;
    }
}
