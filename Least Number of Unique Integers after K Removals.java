class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));

        while(!list.isEmpty()){
            int val = list.get(0).getValue();
            k -= val;

            if(k < 0){
                break;
            }
            list.remove(0);
        }
        return list.size();
    }
}
