import java.util.Scanner;

/**
 * The Driver class contains the main method and handles user input to perform
 */
public class Driver {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Displays a menu and handles user input to perform various 
     * operations on the doubly linked list and the singly linked list.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {

        //DoublyLinkedList dll = new DoublyLinkedList(); //OFFICIAL CODE
        DoublyLinkedList dll = Vocab.inputToVocab("A3_input_file.txt"); //JUST A TEST


        //While loop for the menu
        while (true) {
            System.out.print("""
            ----------------------------------------------
                      Vocabulary Control Center
            ----------------------------------------------
            1 browse a topic
            2 insert a new topic before another one
            3 insert a new topic after another one
            4 remove a topic
            5 modify a topic
            6 search topics for a word
            7 load from a file
            8 show all words starting with a given letter
            9 save to file
            0 exit
            ----------------------------------------------
            Enter Your Choice:\s""");

            int inputChoice = sc.nextInt();

            switch (inputChoice) {
                /*
                 * Browse a topic
                 */
                case 1:
                    /*
                     * 1. Print all topics and ask user to choose one
                     * 2. Once a topic is chosen, print all words in that topic
                     * 3. Go back to asking what topic until user chooses to exit
                     */
                    DoublyLinkedList.browseTopics(dll);
                    break;

                /*
                 * Insert a new topic before another one
                 */
                case 2:
                    /*
                     * 1. Ask user to select which topic he whishes to put the new one before
                     * 2. Ask user to input the new topic
                     * 3. Ask user to input the words for the new topic
                     * 4. Insert the new topic before the selected one
                     */
                    dll = DoublyLinkedList.insertATopicBefore(dll);
                    break;

                /*
                 * Insert a new topic after another one
                 */
                case 3:
                    /*
                     * 1. Ask user to select which topic he whishes to put the new one after
                     * 2. Ask user to input the new topic
                     * 3. Ask user to input the words for the new topic
                     * 4. Insert the new topic after the selected one
                     */
                    dll = DoublyLinkedList.insertATopicAfter(dll);
                    break;

                /*
                 * Remove a topic
                 */
                case 4:
                    /*
                     * 1. Print all topics and ask user to choose one
                     * 2. Once a topic is chosen, remove it
                     */
                    dll = DoublyLinkedList.removeTopic(dll);
                    break;

                /*
                 * Modify a topic
                 */
                case 5:
                    /*
                     * 1. Print all topics and ask user to choose one
                     * 2 . Once a topic is chosen, ask user what he wants to modify
                     *  2.1. Add a word (if word already exist tell user)
                     *  2.2. Remove a word (if word not found tell user it doesn't exist)
                     *  2.3. Modify a word (if word not found tell user it doesn't exist)
                     * 3. Go back to asking what change user whant until chooses to exit
                     */

                    DoublyLinkedList.modifyTopic(dll);
                    break;
                /*
                 * Search topics for a word
                 */
                case 6:
                    dll.case6();
                    break;

                /*
                 * Load from a file
                 */
                case 7:
                    System.out.println("Enter the name of the input file: ");
                    String fileInput = sc.next();
                    try {
                        dll = Vocab.inputToVocab(fileInput); //Replace previous file with this one
                        System.out.println("File loaded successfully.");
                    } catch (Exception e) {
                        System.out.println("File not found.");
                    }
                    break;

                /*
                 * Show all words starting with a given letter
                 */
                case 8:
                    /*
                     * Implement a method to show all words starting with a given letter
                     * Use arrayList
                     * Store extracted words in an ArrayList
                     * sort and print the ArrayList
                     */
                    System.out.print("Enter a letter: ");
                    char letter = sc.next().charAt(0);
                    sc.nextLine();

                    SinglyLinkedList.displayWordsStartingWithLetter(letter, dll);
                    break;


                /*
                 * Save to file
                 */
                case 9:
                    System.out.println("Enter the name of the new file: ");
                    String fileWrite = sc.next();
                    try {
                        dll.printToFile(fileWrite); //Replace previous file with this one
                        System.out.println("File created successfully.");
                    } catch (Exception e) {
                        System.out.println("File not created. Error occurred.");
                    }
                    break;

                /*
                 * Exit the program
                 */
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                /*
                 * Invalid input
                 */
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

        }

    }// end of main

    /**
     * Displays the list of topics to the user.
     *
     * @param dll The doubly linked list of topics.
     */
    public static void displayTopics(DoublyLinkedList dll) {
        System.out.println("""
                ----------------------------------------------
                                Pick a topic
                ----------------------------------------------""");
        dll.printList();
        System.out.println("""
                0. Exit
                ----------------------------------------------""");
        System.out.print("Enter your Choice: ");
    }

}// end of Driver