class Solution {
    private int n;
    private int width;
    private int[][] t;

    private int solve(int[][] books, int i, int remainWidth, int maxHt) {
        if (i >= n) {
            return maxHt;
        }

        if (t[i][remainWidth] != -1) {
            return t[i][remainWidth];
        }

        int bookWidth = books[i][0];
        int bookHeight = books[i][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        if (bookWidth <= remainWidth) {
            keep = solve(books, i + 1, remainWidth - bookWidth, Math.max(maxHt, bookHeight));
        }

        skip = maxHt + solve(books, i + 1, width - bookWidth, bookHeight);

        return t[i][remainWidth] = Math.min(keep, skip);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        width = shelfWidth;
        t = new int[1001][1001];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        int remainWidth = shelfWidth;
        return solve(books, 0, remainWidth, 0);
    }
}
