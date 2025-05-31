class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n) return moves;

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int[] coords = getCoordinates(next, n);
                    int row = coords[0];
                    int col = coords[1];
                    int destination = board[row][col] == -1 ? next : board[row][col];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {
        int r = n - 1 - (num - 1) / n;
        int c = (num - 1) % n;
        if (((n - 1 - r) % 2) == 1) {
            c = n - 1 - c;
        }
        return new int[]{r, c};
    }
}
