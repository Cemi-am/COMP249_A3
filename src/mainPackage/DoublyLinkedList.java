//import java.util.ArrayList;   ONLY TO BE USED FOR CASE 8
import java.util.Scanner;

/**
 * The DoublyLinkedList class contains the doubly linked list of topics
 * Contains DNode class for the nodes in the linked list
 * Contains methods to add and remove nodes from beggining, end, and at a certain index
 * Methods that returns length of the linked list
 * Methods useful for browsing, inserting, removing, and modifying topics mainly used in the driver class
 */
public class DoublyLinkedList {
    static Scanner sc = new Scanner(System.in);
    private DNode head;
    private DNode tail;

    /**
     * Private inner class that represents a node in the doubly linked list
     * Contains a Vocab data and links to the next and previous nodes
     */
    private class DNode {
        private Vocab data;
        DNode next;
        private DNode prev;
        
        /**
         * Parametrized constructor
         * Initializes the data, prev, and next to null
         * 
         * @param data The data to be stored in the node
         * @param prev The link to the previous node
         * @param next The link to the next node
         */
        public DNode(Vocab data, DNode prev, DNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        /**
         * Parameterized constructor
         * Initializes the data to the given value and prev and next to null
         * 
         * @param data The data to be stored in the node
         */
        public DNode(Vocab data) {
            this(data, null, null);
        }

        /**
         * Accessor method for the data
         * @return The data of the node
         */
        public Vocab getData() {
            return data;
        }
    }

    /**
     * Accessor method for the head
     * @return The head of the doubly linked list
     */
    public DNode getHead() {
        return head;
    }

    /**
     * Default constructor for the DoublyLinkedList
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Method to check if the linked list is empty
     * @return True if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Method to return the size of the linked list
     * @return The size of the linked list
     */
    public int size() {
        int count = 0;
        DNode position = head;
        while (position != null) {
            count++;
            position = position.next;
        }
        return count;
    }

    /**
     * Method to insert a new node at the end of the list
     * @param vocab The vocab object to be stored in the node
     */
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

    /**
     * Method to add a new node at the start of the list
     * @param vocab The vocab object to be stored in the node
     */
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

    /**
     * Method to insert a new node at a certain index
     * @param vocab The vocab object to be stored in the node
     * @param index The index at which the node is to be inserted
     */
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

    /**
     * Method to remove a node from the list
     * @param topic The topic of the vocab object to be removed
     */
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

    /**
     * Method to print the list of topics
     */
    public void printList() {
        DNode position = head;
        int count = 1;
        while (position != null) {
            System.out.println(count+". "+position.data.getTopic());
            position = position.next;
            count++;
        }
    }

    /**
     * Method to browse the topics and display the words in the selected topic
     * Used in the driver class
     * @param dll The doubly linked list of topics
     */
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

    /**
     * Method to insert a new topic before a selected index (index is selected with scanner)
     * Used in the driver class
     * @param dll The doubly linked list of topics
     * @return The updated doubly linked list
     */
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

    /**
     * Method to insert a new topic after a selected index (index is selected with scanner)
     * Used in the driver class
     * @param dll The doubly linked list of topics
     * @return The updated doubly linked list
     */
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

    /**
     * Method to remove a topic from the list
     * Used in the driver class
     * @param dll The doubly linked list of topics
     * @return The updated doubly linked list
     */
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

    /**
     * Method to print the topics and words to a file
     * Used in a loop to print all topics and words
     * @param fileName The name of the file to be printed to
     */
    public void printToFile(String fileName) {

        DNode position = head;
        while (position != null) {
            SinglyLinkedList.singleToFile(position.data, fileName);
            position = position.next;
        }

    }

    /**
     * Method to modify a topic
     * Used in the driver class
     * @param dll The doubly linked list of topics
     */
    public static void modifyTopic(DoublyLinkedList dll) {
        while (true) {
            Driver.displayTopics(dll);
            String topicChoice = sc.next();
            sc.nextLine();

            if (topicChoice.equals("0")) {
                System.out.println();
                break;
            } else {
                DoublyLinkedList.DNode current = dll.getHead();
                int index = 1;
                while (current != null && index != Integer.parseInt(topicChoice)) {
                    current = current.next;
                    index++;
                }
                if (current != null) {
                    boolean restart = true;
                    while (restart) {
                        System.out.println("""
                        ----------------------------------------------
                                        Modify a topic
                        ----------------------------------------------
                            a. Add a word
                            r. Remove a word
                            c. Change a word
                            0. Exit
                        ----------------------------------------------""");
                        System.out.print("Enter your Choice: ");
                        String modChoice = sc.next();

                        switch (modChoice) {
                            case "a":
                                //addWord METHOD
                                current.getData().addWord();
                                break;
                            case "r":
                                //removeWord METHOD
                                current.getData().removeWord();
                                break;
                            case "c":
                                //changeWord METHOD
                                current.getData().changeWord();
                                break;
                            case "0":
                                System.out.println();
                                restart = false;
                                break;
                            default:
                                System.out.println("Invalid input. Please try again.");
                                break;
                        }// end of switch
                    }// end of while to choose modification
                } else {
                    System.out.println("Invalid input. Please try again.");
                }// end of else
            }// end of if
        }// end of while to choose topic
    }// end of modifyTopic

    /**
     * Method to search for a word in the topics
     * Used in the driver class
     */
    public void case6() {
        System.out.println("Enter a word to search for: ");
        String word = sc.nextLine();
        DNode position = head;
        boolean wordFound = false;
        while (position != null) {
            if (position.data.getWords().searchTopicForWord(position.data, word) == true) {
                wordFound = true;
            }
            position = position.next;
        }
        if (wordFound == false) {
            System.out.println("Word not found.");
        }
    }
}