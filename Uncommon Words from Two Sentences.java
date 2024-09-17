class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        for(String str : str1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : str2) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                list.add(key);
            }
        }

        String[] ans = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
