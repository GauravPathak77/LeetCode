class Solution {
    public List<String> buildArray(int[] target, int n) {
     List<String> result = new ArrayList<>();
        int targetIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (targetIndex >= target.length) {
                break;
            }

            if (i == target[targetIndex]) {
                result.add("Push");
                targetIndex++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }

        return result;   
    }
}
