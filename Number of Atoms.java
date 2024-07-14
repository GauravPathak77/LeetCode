
class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        for (int i = 0; i < n;) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int i_start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = i > i_start ? Integer.parseInt(formula.substring(i_start, i)) : 1;
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key) * multiplier);
                }
            } else {
                int i_start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(i_start, i);
                i_start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = i > i_start ? Integer.parseInt(formula.substring(i_start, i)) : 1;
                stack.peek().put(element, stack.peek().getOrDefault(element, 0) + count);
            }
        }
        Map<String, Integer> counts = stack.peek();
        List<String> elements = new ArrayList<>(counts.keySet());
        Collections.sort(elements);
        StringBuilder result = new StringBuilder();
        for (String element : elements) {
            result.append(element);
            int count = counts.get(element);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }   
}
