public class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> check = new HashMap<>();

        for (List<String> path : paths) {
            check.put(path.get(0), "out");
            if (!check.containsKey(path.get(1))) {
                check.put(path.get(1), "in");
            }
        }

        for (String item : check.keySet()) {
            if ("in".equals(check.get(item))) {
                return item;
            }
        }

        return "";
    }
}
