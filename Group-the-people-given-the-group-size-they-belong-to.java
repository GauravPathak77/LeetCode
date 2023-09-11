class Group-the-people-given-the-group-size-they-belong-to{
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<groupSizes.length; i++){
            if(!map.containsKey(groupSizes[i])){
            map.put(groupSizes[i], new ArrayList<>());

            }
            map.get(groupSizes[i]).add(i);
            if(map.get(groupSizes[i]).size() == groupSizes[i]){
                list.add(new ArrayList<>(map.get(groupSizes[i])));
                map.get(groupSizes[i]).clear();
            }
        }
        return list;
    }
}
