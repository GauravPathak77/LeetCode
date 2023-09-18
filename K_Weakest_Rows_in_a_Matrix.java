class Solution {
    public static class Row implements Comparable<Row>{
        int s;
        int idx;
        public Row(int s, int idx){
            this.s = s;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r){
            if(this.s == r.s){
                return this.idx - r.idx;
            }
            return this.s - r.s;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[0].length; j++){
                count += mat[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }
        int result[] = new int[k];
        for(int i=0; i<k; i++){
            result[i] = pq.remove().idx;
        }
        return result;
    }
}
