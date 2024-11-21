import java.util.*;

class Solution {
    private void dfs(int r, int c, String dir, int[][] vis, Map<String, Integer> mp) {
        int n = vis.length;
        int m = vis[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m) return;
        if (mp.containsKey(r + "," + c)) return;

        vis[r][c] = 1;

        switch (dir) {
            case "r":
                dfs(r, c + 1, "r", vis, mp);
                break;
            case "l":
                dfs(r, c - 1, "l", vis, mp);
                break;
            case "u":
                dfs(r - 1, c, "u", vis, mp);
                break;
            case "d":
                dfs(r + 1, c, "d", vis, mp);
                break;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] vis = new int[m][n];
        Map<String, Integer> mp = new HashMap<>();

        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            mp.put(x + "," + y, 1);
            vis[x][y] = 1;
        }

        for (int[] wall : walls) {
            int x = wall[0], y = wall[1];
            mp.put(x + "," + y, 1);
            vis[x][y] = 1;
        }

        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];
            dfs(r, c + 1, "r", vis, mp);
            dfs(r, c - 1, "l", vis, mp);
            dfs(r + 1, c, "d", vis, mp);
            dfs(r - 1, c, "u", vis, mp);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) count++;
            }
        }

        return count;
    }
}
