import java.io.*;

/**
 * The SinglyLinkedList class contains the singly linked list of words
 * Contains SNode class for the nodes in the linked list
 * Contains methods to add and remove nodes from beggining, end, and at a certain index
 * Methods that returns length of the linked list, checks if a word is in the linked list and at what index
 * Prints the linked list on the terminal or on a file
 */
public class SinglyLinkedList {

    private SNode head;

    /**
     * Private inner class that represents a node in the singly linked list
     * Contains a string data and a link to the next node
     */
    private class SNode {

        //Instance Variables
        private String word; //Data being stored
        private SNode link; //Pointer to the next node

        /**
         * Default constructor
         * Initializes the word and link to null
         */
        public SNode() {
            word = null;
            link = null;
        }

        /**
         * Parameterized constructor
         * Initializes the word and link to the given values
         * 
         * @param newWord The word to be stored in the node
         * @param linkValue The link to the next node
         */
        public SNode(String newWord, SNode linkValue) {
            word = newWord;
            link = linkValue;
        }

        /**
         * Mutators
         * @param newWord The word to be stored in the node
         */
        public void setData(String newWord) {
            word = newWord;
        }
        /**
         * Mutators
         * @param newLink The link to the next node
         */
        public void setLink(SNode newLink) {
            link = newLink;
        }

        /**
         * Accessors
         * @return The word stored in the node
         */
        public String getWord() {
            return word;
        }
        /**
         * Accessors
         * @return The link to the next node
         */
        public SNode getLink() {
            return link;
        }

    }//End of SNode Class

    /**
     * Head accessor
     * @return The head of the linked list
     */
    public SNode getHead() {
        return head;
    }

    /**
     * Deletes the first node in the linked list
     * @return True if the node was deleted, false otherwise
     */
    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.getLink();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Deletes a node at a certain index in the linked list
     * @param index The index of the node to be deleted
     */
    public void deleteAtIndex(int index) {
        SNode position = head;
        int count = 0;
        if (index == 0) {
            deleteHeadNode();
            return;
        }
        while (position.getLink() != null && count < index-1) {
            position = position.getLink();
            count++;
        }
        position.setLink(position.getLink().getLink()); //Set the link of the previous node to the node after the next node
    }

    /**
     * Returns the length of the linked list
     * @return The length of the linked list
     */
    public int size() {
        int count = 0;
        SNode position = head;
        while (position != null) {
            count++;
            position = position.getLink();
        }
        return count;
    }

    /**
     * Checks if the linkedList contains a certain word
     * 
     * @param key The word to be searched for
     * @return True if the word is in the linked list, false otherwise
     */
    public boolean contains(String key) {
        return (search(key) != -1);
    }

    //

    /**
     * Finds the data in the linkedList
     * Is used by the contains method
     * @param target The word to be searched for
     * @return The index of the word in the linked list, -1 if the word is not in the linked list
     */
    public int search(String target) {
        SNode position = head;
        String dataAtPosition;
        int count = 0;
        while (position != null) {
            dataAtPosition = position.getWord();
            if (dataAtPosition.equals(target)) {
                return count;
            }
            position = position.getLink();
            count++;
        }
        return -1;
    }

    /**
     * Prints the linked list on the terminal
     */
    public void printList() {
        SNode position = head;
        int count = 1;
        while (position != null) {
            System.out.println(count+". "+position.getWord());
            position = position.getLink();
            count++;
        }
    }

    /**
     * Adds a new node to the beginning of the linked list
     * @param word The word to be stored in the new node
     */
    public void addToStart(String word) {
        head = new SNode(word, head); //Here, the previous reference held in head is now the link of the new node
    }

    //Inserts a new node at the end of the list

    /**
     * Adds a new node to the end of the linked list
     * @param word The word to be stored in the new node
     */
    public void insertAtEnd(String word) {
        if (head == null) {
            addToStart(word);
            return;
        }
        SNode newNode = new SNode();
        SNode position = head;
        while (position.link != null) {
            position = position.link;
        }
        newNode.setData(word);
        position.setLink(newNode);
    }//End of insertAtEnd

    //Inserts a new node at a certain index
    /**
     * Adds a new node at a certain index in the linked list
     * 
     * @param word The word to be stored in the new node
     * @param index The index at which the new node is to be inserted
     */
    public void insertAtIndex(String word, int index) {
        SNode newNode = new SNode();
        SNode position = head;
        if (index == 0) {
            addToStart(word);
            return;
        }
        int count = 0;
        while (position.getLink() != null && count < index-1) {
            position = position.getLink();
            count++;
        }
        newNode.setData(word); //Set the data of the new node
        newNode.setLink(position.getLink()); //Set the link of the new node to the next node
        position.setLink(newNode); //Set the link of the previous node to the new node
    }//End of insertAtIndex

    /**
     * Prints the linked list to a file
     * (To be called in a while loop so all vocab objects are printed to the file)
     * @param vocab The vocab object to be printed
     * @param fileName The name of the file to be printed to
     */
    public static void singleToFile(Vocab vocab, String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

            SNode position = vocab.getWords().getHead();
            bw.write("#" + vocab.getTopic());
            bw.newLine();
            while (position != null) {
                bw.write(position.getWord());
                bw.newLine();
                position = position.getLink();
            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }//End of singleToFile

    /**
     * Searches for a word in the linked list
     * @param vocab The vocab object to be searched
     * @param word The word to be searched for
     * @return True if the word is in the linked list, false otherwise
     */
    public boolean searchTopicForWord(Vocab vocab, String word) {
        SNode position = head;
        while (position != null) {
            if (position.getWord().equals(word)) {
                System.out.println("Word found in topic: " + vocab.getTopic());
                return true;
            }
            position = position.getLink();
        }
        return false;
    }//End of searchTopicForWords

    /*
     * Displays all words starting with a given letter
     * If words starting with the specified letter are found, they are printed
     * If not, inform the user by printing a message indicating that
     */

    public static void displayWordsStartingWithLetter(char letter, DoublyLinkedList dll) {
        DoublyLinkedList.DNode currentHead = dll.getHead();
        boolean foundWord = false;

        while (currentHead != null) {
            SinglyLinkedList currentWords = currentHead.getData().getWords();
            SinglyLinkedList.SNode currentNode = currentWords.getHead();

            while (currentNode != null) {
                String word = currentNode.getWord();
                if (word.charAt(0) == letter) {
                    System.out.println(word);
                    foundWord = true;
                }

                currentNode = currentNode.getLink();
            }
            currentHead = currentHead.next;
        }

        if (!foundWord) {
            System.out.println("No words found starting with the letter '" + letter + "'");
        }
    }

}//End of SinglyLinkedList Class