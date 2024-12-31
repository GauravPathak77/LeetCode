class Solution {
    private int solve(int day, Set<Integer> travelDays, int[] costs, int[] memo) {
        if(day > 365) return 0;

        if(memo[day] != -1) return memo[day];

        if(!travelDays.contains(day)) {
            return memo[day] = solve(day + 1, travelDays, costs, memo);
        }

        int oneDay = costs[0] + solve(day + 1, travelDays, costs, memo);
        int sevenDays = costs[1] + solve(day + 7, travelDays, costs, memo);
        int thirtyDays = costs[2] + solve(day + 30, travelDays, costs, memo);

        return memo[day] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[366];
        Set<Integer> travelDays = new HashSet<>();

        Arrays.fill(memo, -1);

        for(int day : days) {
            travelDays.add(day);
        }

        return solve(1, travelDays, costs, memo);
    }
}
