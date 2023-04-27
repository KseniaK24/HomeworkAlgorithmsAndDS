public class Node {
    public int value;
    public String color;
    public Node leftChild;
    public Node rightChild;

    public Node(int value) {
        this.value = value;
    }
    public String toString(){
        return  value +" " + color;
    }
}
