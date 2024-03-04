class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);
        int minptr = 0,maxptr = tokens.length-1;

        int maxscore = 0;
        int score = 0;

        while(minptr<=maxptr)
        {
            if(power>=tokens[minptr])
            {
                power -= tokens[minptr];
                score++;
                maxscore = Math.max(score,maxscore);
                minptr++;
                continue;
            }
            else 
            {
                if(score>=1)
                {
                power += tokens[maxptr];
                maxptr--;
                score--;
                continue;
                }
            }
            break;
        }
        return maxscore;
    }
}
