class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        String target = "123450";

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }

        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{1, 3});
        map.put(1, new int[]{0, 2, 4});
        map.put(2, new int[]{1, 5});
        map.put(3, new int[]{0, 4});
        map.put(4, new int[]{1, 3, 5});
        map.put(5, new int[]{2, 4});

        Queue<String> q = new LinkedList<>();
        q.add(start.toString());

        Set<String> vis = new HashSet<>();
        vis.add(start.toString());

        int level = 0;

        while(!q.isEmpty()) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                String curr = q.poll();

                if(curr.equals(target)) return level;

                int zeroIdx = curr.indexOf('0');

                for(int swapIdx : map.get(zeroIdx)) {
                    char[] arr = curr.toCharArray();
                    
                    char temp = arr[swapIdx];
                    arr[swapIdx] = arr[zeroIdx];
                    arr[zeroIdx] = temp;

                    String newStr = new String(arr);

                    if(!vis.contains(newStr)) {
                        q.add(newStr);
                        vis.add(newStr); 
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
