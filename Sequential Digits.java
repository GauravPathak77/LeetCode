class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for(int digit=1; digit<=9; digit++){
            int num = digit;
            int nextdigit = digit + 1;
        
            while(num <= high && nextdigit <= 9){
                num = num * 10 + nextdigit;
                if(num >= low && num <= high){
                    result.add(num);
                }
                nextdigit++;
            }
        }
        Collections.sort(result);
        return result;
    }
}
