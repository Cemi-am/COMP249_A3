//---------------------------------------------------------------------------------------------------------------------
// Assignment 3 - COMP 249
// due March 15th 2024
// Written by: Samy Mezimez 40275766 and Hiba Talbi 40278717
//---------------------------------------------------------------------------------------------------------------------
import java.io.*;
import java.util.Scanner;

/**
 * The Vocab class contains the topic and words of the vocabulary
 * Also contains methods to add, remove, and change words in the vocabulary
 */
public class Vocab {

    Scanner sc = new Scanner(System.in);
    private String topic;
    private SinglyLinkedList words;

    /**
     * Default constructor
     * Initializes the topic and words to null
     *  
     * @param topic The topic of the vocabulary
     * @param words The words in the vocabulary
     */
    public Vocab() {
        this.topic = null;
        this.words = null;
    }

    /**
     * Parameterized constructor
     * Initializes the topic and words to the given values
     * 
     * @param topic The topic of the vocabulary
     * @param words The words in the vocabulary
     */
    public Vocab(String topic, SinglyLinkedList words) {
        this.topic = topic;
        this.words = words;
    }

    /**
     * Accessor method for the topic
     * @return The topic of the vocabulary
     */
    public String getTopic() {
        return topic;
    }
    /**
     * Accessor method for the words
     * @return The words in the vocabulary
     */
    public SinglyLinkedList getWords() {
        return words;
    }

    /**
     * Reads a file and creates a doubly linked list of vocab objects
     * 
     * @param fileName The name of the file to read
     * @return The doubly linked list of vocab objects
     */
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

    /**
     * Adds a word to the vocabulary
     * takes no param because it reads from the scanner
     */
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

    /**
     * Removes a word from the vocabulary
     * takes no param because it reads from the scanner
     */
    public void removeWord() {
        System.out.println("Type a word to remove and press Enter");
        String word = sc.nextLine();
        if (words.contains(word)) {
            words.deleteAtIndex(words.search(word));
        } else {
            System.out.println("Word does not exist.");
        }
    }

    /**
     * Changes a word in the vocabulary
     * takes no param because it reads from the scanner
     */
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