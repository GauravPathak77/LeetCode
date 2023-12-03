class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for(int i=1; i<points.length; i++){
            int x1 = points[i-1][0];
            int y1 = points[i-1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];

            int deltaX = Math.abs(x2 - x1);
            int deltaY = Math.abs(y2 - y1);

            int diagonal = Math.min(deltaX, deltaY);
            
            int straight = Math.abs(deltaX - deltaY);

           res += diagonal + straight;
        }
        return res;
    }
}
