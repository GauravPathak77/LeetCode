class Solution {
    public static class Bits implements Comparable<Bits>{
        int num;
        int count;
        public Bits(int num, int count){
            this.num = num;
            this.count = count;
        }
        @Override
        public int compareTo(Bits b){
            if(this.count == b.count){
                return this.num - b.num;
            }
            return this.count - b.count;
        }
    }
    public static int countBinary(int num){
        int count = 0;
        for(int i=0; num > 0; i++){
            int rem = num % 2;
            num /= 2;
            if(rem == 1){
                count++;
            }
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Bits> pq = new PriorityQueue<>();
        int res[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int count = countBinary(arr[i]);
            pq.add(new Bits(arr[i], count));
        }
        for(int i=0; !pq.isEmpty(); i++){
            res[i] = pq.remove().num;
        }
        return res;
    }
}
