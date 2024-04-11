package mainPackage;

public class Vocab {

    /*
     * The link of the Vocab needs to be a SinglyLinkedList that containts the words of the topic
     */

    private String topic;
    private SinglyLinkedList words;

    //Default Constructor
    public Vocab() {
            this.topic = null;
            this.words = null;
    }

    //Parameterized Constructor
    public Vocab(String topic, SinglyLinkedList words) {
        this.topic = topic;
        this.words = words;
    }

    /* INSTRUCTIONS
     * Need to read a single file
     * 1. every "#" means the rest of the line (remove white space) is a topic
     * 2. iterate through every line that has words and add them to the SinglyLinkedList
     * 3. at an empty line, the topic is done
     * 4. create a new Vocab object with the topic and the SinglyLinkedList
     */
    

    // public void addWord(SinglyLinkedList words) {

    //     /*
    //      * SNode is a private attribute of the SinglyLinkedList class. It cannot be accessed from the Vocab class.
    //      */

    //     SNode snode = new SNode(words);

    //     if (words == null) {
    //         words = snode;
    //     } else {
    //         SNode currentNode = words;
    //         while (currentNode != null) {
    //             currentNode = currentNode.next;
    //         }
    //     }

    // }
    
}
