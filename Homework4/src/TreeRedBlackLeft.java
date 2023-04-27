public class TreeRedBlackLeft {
    public Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = "BLACK";
            return result;
        } else {
            root = new Node(value);
            root.color = "BLACK";
            return true;
        }
    }

    public boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node(value);
                    node.leftChild.color = "RED";
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node(value);
                    node.rightChild.color = "RED";
                    return true;
                }
            }

        }
    }

    public void colorSwap(Node node) {
        node.color = "RED";
        node.rightChild.color = "BLACK";
        node.leftChild.color = "BLACK";
    }

    public Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = "RED";
        return leftChild;
    }

    public Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = "RED";
        return rightChild;
    }

    public Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == "RED" &&
                    (result.leftChild == null || result.leftChild.color == "BLACK")) {
                needRebalance = true;
                result = rightSwap((result));
            }
            if (result.leftChild != null && result.leftChild.color == "RED" &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == "RED") {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == "RED" &&
                    result.rightChild != null && result.rightChild.color == "RED") {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;

    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        treeLine(root, sb);
        System.out.println(sb);
    }

    public void treeLine(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.toString());
            if (node.leftChild != null || node.rightChild != null) {
                sb.append("(");
                if (node.leftChild != null) {
                    treeLine(node.leftChild, sb);
                }
            else sb.append("-");
            sb.append(";");
            if (node.rightChild != null) {
                treeLine(node.rightChild, sb);
            }
            else sb.append("-");
            sb.append(")");
            }
        }
    }

}









