public class SinglyLinkedList {
    
    private String word; //word may change to any other name (to be modified)
    private int count;
    private SNode link;
    private SNode head;

    public SNode() {
        word = null;
        link = null;
        count = 0;
    }


    public SNode(String newWord, int newCount, SNode linkValue) {
        setData(newWord, newCount);
        head = linkValue;
    }

    public void setData(String newWord, int newCount) {
        word = newWord;
        count = newCount;
    }

    public void setLink(SNode newLink) {
        link = newLink;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public SNode getHead() {
        return head;
    }   

    public SNode getLink() {
        return link;
    }


    // Add a new node to the end of the list
    public void addToStart(String wordName, int wordCount) {
        head = new SNode(wordName, wordCount, head);
    }

    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.getLink();
            return true;
        } else {
            return false;
        }
    }

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

    public void outputList() {
        SNode position = head;
        while (position != null) {
            System.out.println(position.getWord() + " " + position.getCount());
            position = position.getLink();
        }
    }
}
