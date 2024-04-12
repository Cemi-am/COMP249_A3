import java.io.*;

//add word, remove word, modify word, get topic, display words, get words
public class Vocab {

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

    //Accesors
    public String getTopic() {
        return topic;
    }
    public SinglyLinkedList getWords() {
        return words;
    }

    /* INSTRUCTIONS
     * Need to read a single file
     * 1. every "#" means the rest of the line (remove white space) is a topic
     * 2. iterate through every line that has words and add them to the SinglyLinkedList
     * 3. at an empty line, the topic is done
     * 4. create a new Vocab object with the topic and the SinglyLinkedList
     */
    

    //Creates DoublyLinkedList, fills it with Vocab objects from txt and returns it
    public static DoublyLinkedList inputToVocab(String fileName) {
        
        DoublyLinkedList vocabList = new DoublyLinkedList();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String line;

            //While line is not empty check for topic
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                //if line starts with {"#"} --> topic
                if (line.startsWith("#")) {
                    String topic = line.substring(1).trim();
                    SinglyLinkedList words = new SinglyLinkedList();
                    while ((line = br.readLine()) != null && !line.isEmpty()) {
                        words.insertAtEnd(line);
                    }
                    Vocab vocab = new Vocab(topic, words);
                    vocabList.insertAtEnd(vocab); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vocabList;
    }//inputToVocab

}
