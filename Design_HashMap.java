class MyHashMap {
    private static final int SIZE = 10000;
    private List<Entry>[] buckets;

    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new ArrayList[SIZE];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return -1;
        }
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return;
        }
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                buckets[index].remove(entry);
                return;
            }
        }
    }

    private int getIndex(int key) {
        return key % SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
