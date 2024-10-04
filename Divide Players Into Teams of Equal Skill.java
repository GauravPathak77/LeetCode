class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);

        int i = 0;
        int j = n-1;
        long sum = skill[i] + skill[j];
        long ans = 0;

        while(i < j) {
            if(skill[i] + skill[j] != sum) return -1;
            i++;
            j--;
        }

        for(i = 0, j = n-1; i < j; i++, j--) {
            ans += (skill[i] * skill[j]);
        }

        return ans;
    }
}
