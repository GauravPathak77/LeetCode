class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();

        Arrays.sort(folder, (a, b) -> a.length() - b.length());

        for(String file : folder) {
            int idx = 1;
            String[] arr = file.split("/");
            StringBuilder sb = new StringBuilder();

            while(idx < arr.length) {
                sb.append("/");
                sb.append(arr[idx]);
                if(ans.contains(sb.toString())) break;
                idx++;
            }

            if(idx == arr.length) ans.add(file);
        }

        return ans;
    }
}
