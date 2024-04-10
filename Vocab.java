public class Vocab {
    private String topic;
    private SinglyLinkedList words;

    private Vocab(String topic) {
        this.topic = topic;
        this.words = null;
    }

    public void addWord(SinglyLinkedList words) {
        SNode snode = new SNode(words);

        if (words == null) {
            words = snode;
        } else {
            SNode currentNode = words;
            while (currentNode != null) {
                currentNode = currentNode.next;
            }
        }

    }
    
}
