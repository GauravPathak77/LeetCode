class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long totalValid = 0;
    int lastBlockStart = 0;
    int secondLastBlockStart = 0;
    long[] gainIfRemoved = new long[n + 1];
    List<Integer>[] conflictAtRight = new List[n + 1];

    for (int i = 0; i <= n; ++i)
      conflictAtRight[i] = new ArrayList<>();

    for (int[] pair : conflictingPairs) {
      int x = pair[0];
      int y = pair[1];
      conflictAtRight[Math.max(x, y)].add(Math.min(x, y));
    }

    for (int end = 1; end <= n; ++end) {
      for (int start : conflictAtRight[end]) {
        if (start > lastBlockStart) {
          secondLastBlockStart = lastBlockStart;
          lastBlockStart = start;
        } else if (start > secondLastBlockStart) {
          secondLastBlockStart = start;
        }
      }

      totalValid += end - lastBlockStart;
      gainIfRemoved[lastBlockStart] += lastBlockStart - secondLastBlockStart;
    }

    return totalValid + Arrays.stream(gainIfRemoved).max().getAsLong();
    }
}
