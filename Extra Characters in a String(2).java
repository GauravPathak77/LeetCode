class Solution {
    public class Node {
        Node[] child = new Node[26];
        boolean eow = false;

        Node() {
            for(int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }

    public Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
    }

    public boolean searchPrefix(String key) {
        Node curr = root;
        for(int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.eow;
    }

    public int solve(String s, int start, int[] memo) {
        if(start >= s.length()) {
            return 0;
        }

        if(memo[start] != -1) {
            return memo[start];
        }

        int extra = 1 + solve(s, start + 1, memo);

        for(int end = start + 1; end <= s.length(); end++) {
            if(searchPrefix(s.substring(start, end))) {
                extra = Math.min(extra, solve(s, end, memo));
            }
        }

        memo[start] = extra;
        return extra;
    }

    public int minExtraChar(String s, String[] dictionary) {
        for(String word : dictionary) {
            insert(word);
        }

        int[] memo = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            memo[i] = -1;
        }

        return solve(s, 0, memo);
    }
}
