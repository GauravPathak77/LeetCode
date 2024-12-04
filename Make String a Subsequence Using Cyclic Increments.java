class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;

        while(i < str1.length() && j < str2.length()) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);

            if(ch1 == ch2 || (ch1 == 'z' && ch2 == 'a') || (ch1+1 == ch2)) j++;

            i++;
        }

        if(j == str2.length()) return true;
        else return false;
    }
}
