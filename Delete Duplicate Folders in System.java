class Solution {
    static class Node {
        String name;
        Map<String, Node> children = new HashMap<>();
        boolean toDelete = false;
        String serial = "";

        Node(String name) {
            this.name = name;
        }
    }

    Map<String, List<Node>> serialMap = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");

        for (List<String> path : paths) {
            Node curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Node(folder));
                curr = curr.children.get(folder);
            }
        }

        serialize(root);

        for (List<Node> group : serialMap.values()) {
            if (group.size() > 1) {
                for (Node node : group) {
                    node.toDelete = true;
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private String serialize(Node node) {
        if (node.children.isEmpty()) return "";

        List<String> serials = new ArrayList<>();
        for (Node child : node.children.values()) {
            String childSerial = serialize(child);
            serials.add(child.name + "(" + childSerial + ")");
        }

        Collections.sort(serials);
        String serial = String.join("", serials);
        node.serial = serial;

        serialMap.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }

    private void dfs(Node node, List<String> path, List<List<String>> res) {
        for (Node child : node.children.values()) {
            if (!child.toDelete) {
                path.add(child.name);
                res.add(new ArrayList<>(path));
                dfs(child, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
