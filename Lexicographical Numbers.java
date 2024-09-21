class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int num = 1; num <= 9; num++) {
            solve(n, num, ans);
        }
        
        return ans;
    }

    private void solve(int n, int num, List<Integer> ans) {
        if(num > n) {
            return;
        }

        ans.add(num);

        for(int append = 0; append <= 9; append++) {
            int new_num = (num * 10) + append;
            if(new_num > n) return;
            solve(n, new_num, ans);
        }
    }
}
