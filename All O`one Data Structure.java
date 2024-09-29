class AllOne {
    class Node {
        int count;
        LinkedHashSet<String> st;
        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
            st = new LinkedHashSet<>();
            prev = null;
            next = null;
        }
    }

    Map<String, Node> map;
    Node head;
    Node tail;

    public Node addNode(Node currNode, int count) {
        Node newNode = new Node(count);
        newNode.prev = currNode;
        newNode.next = currNode.next;
        if (currNode.next != null) {
            currNode.next.prev = newNode;
        }
        currNode.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
        return newNode;
    }

    public void removeNode(Node currNode) {
        if (currNode.st.isEmpty()) {
            currNode.prev.next = currNode.next;
            if (currNode.next != null) {
                currNode.next.prev = currNode.prev;
            }
            if (tail == currNode) {
                tail = currNode.prev;
            }
        }
    }

    public AllOne() {
        map = new HashMap<>();
        Node newNode = new Node(0);
        head = newNode;
        tail = newNode;
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next == null || head.next.count != 1) {
                Node newNode = addNode(head, 1);
                newNode.st.add(key);
                map.put(key, newNode);
            } else {
                head.next.st.add(key);
                map.put(key, head.next);
            }
        } else {
            Node currNode = map.get(key);
            int currCount = currNode.count;
            if (currNode.next == null || currNode.next.count != currCount + 1) {
                Node newNode = addNode(currNode, currCount + 1);
                newNode.st.add(key);
                map.put(key, newNode);
            } else {
                currNode.next.st.add(key);
                map.put(key, currNode.next);
            }
            currNode.st.remove(key);
            removeNode(currNode);
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) return;

        Node currNode = map.get(key);
        int currCount = currNode.count;
        if (currCount == 1) {
            currNode.st.remove(key);
            map.remove(key);
        } else {
            if (currNode.prev == head || currNode.prev.count != currCount - 1) {
                Node prevNode = addNode(currNode.prev, currCount - 1);
                prevNode.st.add(key);
                map.put(key, prevNode);
            } else {
                currNode.prev.st.add(key);
                map.put(key, currNode.prev);
            }
            currNode.st.remove(key);
        }
        removeNode(currNode);
    }

    public String getMaxKey() {
        if (tail == head) return "";
        return tail.st.iterator().next();
    }

    public String getMinKey() {
        if (head.next == null) return "";
        return head.next.st.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
