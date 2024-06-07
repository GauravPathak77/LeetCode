class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String words[] = sentence.split(" ");
        Collections.sort(dictionary, (a, b) -> a.length() - b.length());

        for(int i=0; i<words.length; i++){
            String word = words[i];

            for(int j=0; j<dictionary.size(); j++){
                if (word.startsWith(dictionary.get(j))) {
                    words[i] = dictionary.get(j);
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
}
