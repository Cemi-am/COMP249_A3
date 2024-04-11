package mainPackage;

public class SinglyLinkedList {
    
    private SNode head;
    
    private class SNode {
        
        //Instance Variables
        private String word; //Data being stored
        private SNode link; //Pointer to the next node 
        private int wordCount; //Counts the number of the word (i.e. index)

        //Default Constructor
        public SNode() {
            word = null;
            link = null;
            wordCount = 0;
        }
        //Parameterized Constructor
        public SNode(String newWord, SNode linkValue, int newWordCount) {
            word = newWord;
            link = linkValue;
            wordCount = newWordCount;
        }

        //Mutators
        public void setData(String newWord) {
            word = newWord;
        }
    
        public void setLink(SNode newLink) {
            link = newLink;
        }

        public void setCount(int newWordCount) {
            wordCount = newWordCount;
        }

        //Accesors
        public String getWord() {
            return word;
        }
    
        public SNode getLink() {
            return link;
        }
        
        public int getCount() {
            return wordCount;
        }

    }//End of SNode Class

    public SNode getHead() {
        return head;
    }  



    // Add a new node to the begining of the list
    public void addToStart(String wordName, int wordCount) {
        head = new SNode(wordName, head, wordCount);
    }


    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.getLink();
            return true;
        } else {
            return false;
        }
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

    public boolean contains(String key) {
        return (findData(key) != null);
    }

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

    //
    public void outputList() {
        SNode position = head;
        while (position != null) {
            System.out.println(position.getWord() + " " + position.getCount());
            position = position.getLink();
        }
    }


    /*
     * We have to add a method that will change the link of the last node to the new node
     * so we can add a new node to the end of the list (useful with bufferedReader)
     * 
     */

}//End of SinglyLinkedList Class
