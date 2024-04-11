package mainPackage;


//import java.util.ArrayList;   ONLY TO BE USED FOR CASE 8

public class DoublyLinkedList {
    
    private DNode head;
    private DNode tail;
    private int length;

    private class DNode {

        private Vocab data;
        private DNode next;
        private DNode prev;

        public DNode(Vocab data, DNode prev, DNode next) {
            this.data = data;
            // this.prev = prev;
            // this.next = next;
            
            /*
             * To be removed.. i think
             */
        }

        public DNode(Vocab data) {
            this(data, null, null);
        }
    }

    //Default Constructor
    private DoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    //Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    //Return the length of the list
    public int length() {
        return length;
    }

    public void insertAtEnd(Vocab vocab) {
        DNode newNode = new DNode(vocab);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(Vocab vocab) {
        DNode current = head;
        while (current != null) {
            if (current.data.equals(vocab)) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    
}
