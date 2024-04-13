//import java.util.ArrayList;   ONLY TO BE USED FOR CASE 8
import java.util.Scanner;

public class DoublyLinkedList {

    static Scanner sc = new Scanner(System.in);

    private DNode head;
    private DNode tail;

    private class DNode {

        private Vocab data;
        private DNode next;
        private DNode prev;

        //Default Constructor
        @SuppressWarnings("unused")
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

        if (index == 0) {
            addToStart(vocab);
            return;
        }

        DNode position = head;
        int count = 0;
        while (position.next != null && count < index - 1) {
            position = position.next;
            count++;
        }

        newNode.next = position.next;
        newNode.prev = position;
        if (position.next != null) {
            position.next.prev = newNode;
        } else {
            // If inserting at the end, update the tail
            tail = newNode;
        }
        position.next = newNode;
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

    public static void browseTopics(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            Driver.displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                 
                DoublyLinkedList.DNode current = dll.getHead();

                int index = 1;
                while (current != null && index != userChoice) {
                    current = current.next;
                    index++;
                }
                if (current != null) {
                    System.out.println("Topic: " + current.getData().getTopic());
                    current.getData().getWords().printList();;
                } else {
                    System.out.println("Invalid index.");
                }
            }

        } while(restart);

    }// end of browseTopics

    public static DoublyLinkedList insertATopicBefore(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            Driver.displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                int newIndex = userChoice - 1;
                System.out.print("Enter a topic name: ");
                String newTopicName = sc.nextLine();

                // Create new linkedlist with the new words
                SinglyLinkedList newWords = new SinglyLinkedList();
                System.out.println("Enter a word - to quit press Enter:");
                String word = sc.nextLine();
                while (!word.isEmpty()) {
                    newWords.insertAtEnd(word);
                    word = sc.nextLine();
                }

                // Create new Vocab object
                Vocab newVocab = new Vocab(newTopicName, newWords);
                dll.insertAtIndex(newVocab, newIndex);
            }

        } while(restart);

        return dll;
    }// end of insertATopicBefore

    public static DoublyLinkedList insertATopicAfter(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            Driver.displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                int newIndex = userChoice;
                System.out.print("Enter a topic name: ");
                String newTopicName = sc.nextLine();

                // Create new linkedlist with the new words
                SinglyLinkedList newWords = new SinglyLinkedList();
                System.out.println("Enter a word - to quit press Enter:");
                String word = sc.nextLine();
                while (!word.isEmpty()) {
                    newWords.insertAtEnd(word);
                    word = sc.nextLine();
                }

                // Create new Vocab object
                Vocab newVocab = new Vocab(newTopicName, newWords);
                dll.insertAtIndex(newVocab, newIndex);
            }

        } while(restart);


        return dll;
    }// end of insertATopicAfter

    public static DoublyLinkedList removeTopic(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            Driver.displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                DoublyLinkedList.DNode current = dll.getHead();

                int index = 1;
                while (current != null && index != userChoice) {
                    current = current.next;
                    index++;
                }
                if (current != null) {
                    dll.removeVocab(current.getData().getTopic());
                } else {
                    System.out.println("Invalid index.");
                }
            }

        } while(restart);
        return dll;
    }// end of removeTopic

    public static DoublyLinkedList modifyATopic(DoublyLinkedList dll) {
        Driver.displayTopics(dll);
        int topicChoice = sc.nextInt();
        sc.nextLine();

        DoublyLinkedList.DNode topicHead = dll.getHead();
        int topicIndex = 1;
        while (topicHead != null && topicIndex != topicChoice) {
            topicHead = topicHead.next;
            topicIndex++;
        }

        if (topicHead != null) {
            System.out.println("Topic: " + topicHead.getData().getTopic());
            topicHead.getData().getWords().printList();
        }

        System.out.print("""
                    ----------------------------------------------
                                  Modify Topics Menu
                    ----------------------------------------------
                    a. add a word
                    r. remove a word
                    c. change a word
                    0. exit
                    ----------------------------------------------
                    Enter your choice:\s""");

        String userChoice = sc.next();
        sc.nextLine();
        switch(userChoice) {
            // Adding a word
            case "a", "A" -> {
                System.out.print("Type a word and press Enter or press Enter to end input:\n");
                String newWord = sc.nextLine();
                if (newWord.isEmpty()) {
                    return dll;
                } else {
                    // Checking if the word already exists
                    boolean wordExists = topicHead.getData().getWords().searchAWord(newWord);
                    if (wordExists) {
                        System.out.println("Sorry, the word: '" + newWord + "' is already listed!");
                        return dll;
                    } else {
                        topicHead.getData().getWords().insertAtEnd(newWord);
                    }
                }
            }
            // Removing a Word
            case "r", "R" -> {
                System.out.print("Enter a word: ");
                String wordToRemove = sc.nextLine();
                if (topicHead.getData().getWords().searchAWord(wordToRemove)) {
                    topicHead.getData().getWords().deleteWord(wordToRemove);
                } else {
                    System.out.println("Sorry, there is no word: " + wordToRemove);
                }
            }
            case "c", "C" -> {
                System.out.print("Enter the word you wish to change: ");
                String wordToChange = sc.nextLine();

                // Check if the word exists
                if (topicHead.getData().getWords().searchAWord(wordToChange)) {
                    System.out.print("Enter the new word: ");
                    String newWord = sc.nextLine();

                    // Replace the old word
                    topicHead.getData().getWords().changeWord(wordToChange, newWord);
                } else {
                    System.out.println("Sorry, there is no word: " + wordToChange);
                }
            }
            case "0" -> {
                return dll;
            }
            default -> {
                System.out.println("Invalid choice.");
            }
        }

        return dll;
    }// end of modifyATopic

    public void printToFile(String fileName) {
    
        DNode position = head;
        while (position != null) {
            SinglyLinkedList.singleToFile(position.data, fileName);
            position = position.next;
        }

    }

}
