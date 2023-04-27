
//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).
public class Main {
    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.addEnd(1,2,3,4,5,6,7,8,9);
        ml.print();
        ml.reverse();
        ml.print();


    }






    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }
}
