class Solution {
    private class Node{
        Node[] child;
        int count;

        public Node() {
            child = new Node[26];
            count = 0;
        }
    }

    private void insertNode(String word, Node root) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
            curr.count++;
        }
    }

    private int search(String word, Node root) {
        Node curr = root;
        int score = 0;

        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(curr.child[idx] != null) {
                curr = curr.child[idx];
                score += curr.count;
            } else {
                break;
            }
        }

        return score;
    }

    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        int n = words.length;
        int[] ans = new int[n];

        for(String word : words) {
            insertNode(word, root);
        }

        for(int i = 0; i < n; i++) {
            ans[i] = search(words[i], root);
        }

        return ans;
    }
}
