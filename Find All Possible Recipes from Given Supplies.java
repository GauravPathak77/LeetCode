class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> ans = new ArrayList<>();
        Set<String> st = new HashSet<>();
        boolean[] cooked = new boolean[n];
        int count = n;

        for(String s : supplies) st.add(s);

        while(count-- > 0) {
            for(int i = 0; i < n; i++) {
                if(cooked[i]) continue;
            
                boolean canMake = true;
                for(String str : ingredients.get(i)) {
                    if(!st.contains(str)) {
                        canMake = false;
                        break;
                    }
                }

                if(canMake) {
                    ans.add(recipes[i]);
                    st.add(recipes[i]);
                    cooked[i] = true;
                }
            }
        }

        return ans;
    }
}
