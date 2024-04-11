package mainPackage;


//import java.util.ArrayList;   ONLY TO BE USED FOR CASE 8

public class DoublyLinkedList {
    
    private DNode head;
    private DNode tail;

    private class DNode {

        private Vocab data;
        private DNode next;
        private DNode prev;

        //Default Constructor
        public DNode() {
            this(null, null, null);
        }

        //Parameterized Constructor
        public DNode(Vocab data, DNode prev, DNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
            
        }

        public DNode(Vocab data) {
            this(data, null, null);
        }

        //Accesors and Mutators???
        public Vocab getData() {
            return data;
        }
    }
    public DNode getHead() {
        return head;
    }

    //Default Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    //Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    //Return the length of the list
    public int size() {
        int count = 0;
        DNode position = head;
        while (position != null) {
            count++;
            position = position.next;
        }
        return count;
    }

    //Insert a new node at the end of the list
    public void insertAtEnd(Vocab vocab) {
        DNode newNode = new DNode(vocab);
        //if DoublyLinkedList is empty
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else { 
            tail.next = newNode; //The next of the last node is the new node
            newNode.prev = tail; //Previous of the new node is the tail
            tail = newNode; //Set newNode as the tail
        }
    }

    //Insert a new node at the beginning of the list
    public void addToStart(Vocab vocab) {
        DNode newNode = new DNode(vocab);
        //if DoublyLinkedList is empty
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; //The next of the new node is the head
            head.prev = newNode; //The previous of the head is the new node
            head = newNode; //Set newNode as the head
        }
    }

    //Insert a new node at a certain index
    public void insertAtIndex(Vocab vocab, int index) {
        DNode newNode = new DNode(vocab);
        DNode position = head;
        int count = 0;
        while (position.next != null && count < index) {
            position = position.next;
            count++;
        }
        newNode.next = position.next; //Next of new node is set to the current position's next
        position.next = newNode; //Position's next is set to the new node
        newNode.prev = position; //New node's previous is set to the current position
        position.next.prev = newNode; //Next node's previous is set to the new node
    }


    public void removeVocab(String topic) {
        DNode position = head;

        while (position != null) {
            if (position.data.getTopic().equals(topic)) { //If the topic is found
                if (position == head && position == tail) { //If there is only one node
                    head = null;
                    tail = null;
                } else if (position == head) { //If the node is the head
                    head = head.next;
                    head.prev = null;
                } else if (position == tail) { //If the node is the tail
                    tail = tail.prev;
                    tail.next = null;
                } else { //If the node is in the middle
                    position.prev.next = position.next;
                    position.next.prev = position.prev;
                }
                break;
            }
            position = position.next;
        }
    }

    public void printList() {
        DNode position = head;
        int count = 1;
        while (position != null) {
            System.out.println(count+". "+position.data.getTopic());
            position = position.next;
            count++;
        }
    }
    
}
