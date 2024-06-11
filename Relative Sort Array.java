class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        for(int i=0; i< arr1.length; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        for(int i=0; i<arr2.length; i++){
            int n = map.get(arr2[i]);

            while(n-- > 0){
                list1.add(arr2[i]);
            }
            map.remove(arr2[i]);
        }

        System.out.println("List1");
        for(int i=0; i<list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }

        if(map.size() != 0){
            for(Integer key : map.keySet()){
                int n = map.get(key);

                while(n-- > 0){
                    list2.add(key);
                }
            }
            Collections.sort(list2);
            list1.addAll(list2);
        }

        System.out.println("\nList1");
        for(int i=0; i<list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }

        for(int i=0; i<list1.size(); i++){
            arr1[i] = list1.get(i);
        }

        return arr1;
    }
}
