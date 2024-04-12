
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
        while (position.getLink() != null && count < index) {
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
        return (findData(key) != null);
    }

    //Finds the data in the linkedList
    private SNode findData(String target) {
        SNode position = head;
        String dataAtPosition;
        while (position != null) {
            dataAtPosition = position.getWord();
            if (dataAtPosition.equals(target)) {
                return position;
            }
            position = position.getLink();
        }
        return null;
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
    }

    //Inserts a new node at a certain index
    public void insertAtIndex(String word, int index) {
        SNode newNode = new SNode();
        SNode position = head;
        int count = 0;
        while (position.getLink() != null && count < index) {
            position = position.getLink();
            count++;
        }
        newNode.setData(word); //Set the data of the new node
        newNode.setLink(position.getLink()); //Set the link of the new node to the next node
        position.setLink(newNode); //Set the link of the previous node to the new node
    }

}//End of SinglyLinkedList Class
