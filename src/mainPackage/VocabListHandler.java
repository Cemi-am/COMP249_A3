package mainPackage;
import java.io.*;

public class VocabListHandler {

    private DoublyLinkedList vocabList;

    /* INSTRUCTIONS
     * Need to read a single file
     * 1. every "#" means the rest of the line (remove white space) is a topic
     * 2. iterate through every line that has words and add them to the SinglyLinkedList
     * 3. at an empty line, the topic is done
     * 4. create a new Vocab object with the topic and the SinglyLinkedList
     */

    /*To be used like this in the Driver class i think
    * VocabListHandler.inputToVocabObjects("A3_input_file.txt");
    */
    

    //Method to read the input file and create ONE Vocab objects
    /*
     * If put in a whle loop, it will create multiple Vocab objects
     * Need to create a DoublyLinkedList to store all the Vocab objects
     */
    public static void inputToVocabObjects(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String line;

            //While line has content
            while ((line = br.readLine()).trim().length() != 0) {
                //if line starts with {"#"} --> topic
                if (line.startsWith("#")) {
                    String topic = line.substring(1).trim();
                    SinglyLinkedList words = new SinglyLinkedList();
                    while ((line = br.readLine()) != null && !line.isEmpty()) {
                        words.insertAtEnd(line); //THIS METHOD NEEDS TO BE CREATED IN THE SinglyLinkedList CLASS
                    }
                    Vocab vocab = new Vocab(topic, words);
                    //vocabList.insertAtEnd(vocab); //TO BE FIXED (Need to insertAtEnd in a DoublyLinkedList???)
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public DoublyLinkedList createVocabList() {
        
    // }

}