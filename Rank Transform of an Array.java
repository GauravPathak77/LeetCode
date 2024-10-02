class Solution {
    public class Pair implements Comparable<Pair> {
        int value;
        int idx;
        int rank;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
            rank = 0;
        }

        @Override
        public int compareTo(Pair p) {
            return this.value - p.value;  
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        List<Pair> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            list.add(new Pair(arr[i], i));
        }

        Collections.sort(list);

        int rank = 1;

        for(int i=0; i<n; i++) {
            Pair p = list.get(i);
            if(i == 0) {
                p.rank = 1;
            } else {
                Pair prevPair = list.get(i-1);
                if(p.value == prevPair.value) {
                    p.rank = prevPair.rank;
                } else {
                    p.rank = prevPair.rank + 1;
                }
            }
        }

        for(Pair p : list) {
            arr[p.idx] = p.rank;
        }

        return arr;
    }
}
