class Solution {
    private List<int[]> merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        list.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < list.get(list.size()-1)[1]) {
                int[] temp = list.get(list.size()-1);
                temp[1] = Math.max(intervals[i][1], list.get(list.size()-1)[1]);
                list.remove(list.size()-1);
                list.add(temp);
            } else {
                list.add(intervals[i]);
            }
        }

        return list;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int size = rectangles.length;
        int[][] horInt = new int[size][2];
        int[][] verInt = new int[size][2];

        List<int[]> horList = new ArrayList<>();
        List<int[]> verList = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int startx = rectangles[i][0];
            int starty = rectangles[i][1];
            int endx = rectangles[i][2];
            int endy = rectangles[i][3];

            horInt[i] = new int[]{startx, endx};
            verInt[i] = new int[]{starty, endy};
        }

        horList = merge(horInt);
        verList = merge(verInt);  

        if(horList.size() >= 3 || verList.size() >= 3) return true;

        return false;      
    }
}
