import java.io.*;

public class SinglyLinkedList {

    private SNode head;
    
    private class SNode {
        
        //Instance Variables
        private String word; //Data being stored
        private SNode link; //Pointer to the next node

        //Default Constructor
        public SNode() {
            word = null;
            link = null;
        }

        //Parameterized Constructors
        public SNode(String newWord, SNode linkValue) {
            word = newWord;
            link = linkValue;
        }

        //Mutators
        public void setData(String newWord) {
            word = newWord;
        }
        public void setLink(SNode newLink) {
            link = newLink;
        }

        //Accesors
        public String getWord() {
            return word;
        }
        public SNode getLink() {
            return link;
        }

    }//End of SNode Class

    public SNode getHead() {
        return head;
    }  



    //Sets the head to the next node (deletes the first node)
    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.getLink();
            return true;
        } else {
            return false;
        }
    }

    //Deletes a node at a certain index
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

    //Gives back the size of the linkedList
    public int size() {
        int count = 0;
        SNode position = head;
        while (position != null) {
            count++;
            position = position.getLink();
        }
        return count;
    }

    //Checks if the linkedList contains a certain word
    public boolean contains(String key) {
        return (search(key) != -1);
    }

    //Finds the data in the linkedList
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

    //Prints the linkedList
    public void printList() {
        SNode position = head;
        int count = 1;
        while (position != null) {
            System.out.println(count+". "+position.getWord());
            position = position.getLink();
            count++;
        }
    }


    // Add a new node to the begining of the list
    public void addToStart(String word) {
        head = new SNode(word, head); //Here, the previous reference held in head is now the link of the new node
    }

    //Inserts a new node at the end of the list
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

    public boolean searchAWord(String word) {
        SNode current = head;
        while (current != null) {
            if (current.getWord().equalsIgnoreCase(word)) {
                return true;
            }
            current = current.getLink();
        }
        return false;
    }// End of searchAWord

    public boolean deleteWord(String wordToDelete) {
        if (head == null) {
            return false;// empty list
        }
        if (head.getWord().equals(wordToDelete)) {
            head = head.getLink();// head points to the second node in the list
            return true;
        }
        SNode current = head;

        while (current.getLink() != null) {
            if (current.getLink().getWord().equals(wordToDelete)) {
                current.setLink(current.getLink().getLink());// skips over the node to delete
                return true;
            }
            current = current.getLink();
        }
        return false; // Word isn't found
    }// end of deleteWord

    public void changeWord(String oldWord, String newWord) {
        SNode current = head;
        while (current != null) {
            if (current.getWord().equals(oldWord)) {
                current.setData(newWord);// replace old word
                return;
            }
            current = current.getLink();
        }
    }
    
}//End of SinglyLinkedList Class
