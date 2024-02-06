class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String st = strs[i];
            char arr[] = st.toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if(map.containsKey(s)){
                list.get(map.get(s)).add(st);
            }
            else{
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(st);
                map.put(s, list.size()-1);
            }
        }
        return list;
    }
}
