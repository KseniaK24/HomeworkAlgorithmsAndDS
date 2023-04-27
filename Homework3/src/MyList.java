public class MyList {
        Node head;

        public void print(){
            Node item = head;
            while (item != null) {
                System.out.print(item.value + " ->");
                item = item.next;
            }
            System.out.println();
        }


        public void addEnd(int... values) {
            for (int i : values) {
                this.addEnd(i);
            }
        }


        public void addEnd(int value) {
            Node newNode = new Node(value);
            if (head != null) {
                Node LastNode = head;
                while (LastNode.next != null) {
                    LastNode = LastNode.next;
                }
                LastNode.next = newNode;
            } else {
                head = newNode;
            }
        }

        public void reverse(){
            if (head != null && head.next != null){
                revert(head.next,head);
            }
        }
        private void revert(Node currentNode, Node previousNode){
            if (currentNode.next == null) {
                head = currentNode;
            } else {
                revert(currentNode.next, currentNode);
            }
            currentNode.next = previousNode;
            previousNode.next = null;
        }

    }

