class Solution {
    class Phone implements Comparable<Phone> {
        char ch;
        int freq;
        int push;

        Phone(char ch, int freq, int push) {
            this.ch = ch;
            this.freq = freq;
            this.push = push;
        }

        @Override
        public int compareTo(Phone p) {
            return p.freq - this.freq;
        }
    }

    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        List<Phone> list = new ArrayList<>();
        int ans = 0;

        for(char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(Character key : map.keySet()) {
            list.add(new Phone(key, map.get(key), 0));
        }

        Collections.sort(list);

        int num = 2, press = 1;
        for(int i=0; i<list.size(); i++) {
            list.get(i).push = press;
            num++;
            if(num > 9) {
                num = 2;
                press++;
            }
        }

        for(int i=0; i<list.size(); i++) {
            ans += list.get(i).freq * list.get(i).push;
        }

        return ans;
    }
}
