class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows<=0){
            return triangle;
        }
        triangle.add(0).add(1);
        for(int i=1; i<numRows; i++){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
            for(int j=1; j<=i; j++){
                if(j==i){
                    list.add(triangle.get(i-1).get(j-1));
                }else{
                    list.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
            }
            triangle.add(list);
        }
        return triangle;
    }
}