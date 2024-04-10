import java.util.LinkedList;
import java.util.ArrayList;

public class DoublyLinkedList {
    private class DNode {
        Vocab data;
        DNode prev;
        DNode next;

        public DNode(Vocab data) {
            this.data = data;
            this.prev = null;
            this.next = null;

        }
    }

    private DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
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
