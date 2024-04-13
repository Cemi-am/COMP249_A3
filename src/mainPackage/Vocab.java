import java.io.*;
import java.util.Scanner;

//add word, remove word, modify word, get topic, display words, get words
public class Vocab {

    Scanner sc = new Scanner(System.in);
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


    public void addWord() {
        System.out.println("Type a word and press Enter, or press Enter to end input");
        String word = sc.nextLine();
        while (!word.isEmpty()) {
            
            if (words.contains(word)) {
                System.out.println("Word already exists.");
                break;
            } else {
            words.insertAtEnd(word);
            word = sc.nextLine();
            }
        }
    }

    public void removeWord() {
        System.out.println("Type a word to remove and press Enter");
        String word = sc.nextLine();
        if (words.contains(word)) {
            words.deleteAtIndex(words.search(word));
        } else {
            System.out.println("Word does not exist.");
        }
    }

    public void changeWord() {
        System.out.println("Type the word you want to change and press Enter");
        String oldWord = sc.nextLine();
        if (words.contains(oldWord)) {
            int index = words.search(oldWord);
            words.deleteAtIndex(index);
            System.out.println("Type the new word and press Enter");
            String newWord = sc.nextLine();
            words.insertAtIndex(newWord, index);
        } else {
            System.out.println("Word does not exist.");
        }
    }
}
