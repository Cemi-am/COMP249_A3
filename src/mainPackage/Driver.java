import java.util.Scanner;

public class Driver {
    public static Scanner sc = new Scanner(System.in);

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
            Enter Your Choice: """);

            int inputChoice = sc.nextInt();

            switch (inputChoice) {
                /*
                 * Browse a topic
                 */
                case 1:
                    /*
                     * Implement a method to browse a topic
                     * 1. Print all topics and ask user to choose one
                     * 2. Once a topic is chosen, print all words in that topic
                     * 3. Go back to asking what topic until user chooses to exit
                     */
                    browseTopics(dll);
                    break;

                /*
                 * Insert a new topic before another one
                 */
                case 2:
                    /*
                     * Implement a method to insert a new topic before another one
                     * 1. Ask user to select which topic he whishes to put the new one before
                     * 2. Ask user to input the new topic
                     * 3. Ask user to input the words for the new topic
                     * 4. Insert the new topic before the selected one
                     */
                    dll = insertATopicBefore(dll);
                    break;

                /*
                 * Insert a new topic after another one
                 */
                case 3:
                    /*
                     * Implement a method to insert a new topic after another one
                     * 1. Ask user to select which topic he whishes to put the new one after
                     * 2. Ask user to input the new topic
                     * 3. Ask user to input the words for the new topic
                     * 4. Insert the new topic after the selected one
                     */
                    dll = insertATopicAfter(dll);
                    break;

                /*
                 * Remove a topic
                 */
                case 4:
                    /*
                     * Implement a method to remove a topic
                     * 1. Print all topics and ask user to choose one
                     * 2. Once a topic is chosen, remove it
                     */
                    dll = removeTopic(dll);
                    break;

                /*
                 * Modify a topic
                 */
                case 5:
                    /*
                     * Implement a method to modify a topic
                     * 1. Print all topics and ask user to choose one
                     * 2. Once a topic is chosen, ask user what he wants to modify
                     *  2.1. Add a word (if word already exist tell user)
                     *  2.2. Remove a word (if word not found tell user it doesn't exist)
                     *  2.3. Modify a word (if word not found tell user it doesn't exist)
                     * 3. Go back to asking what change user whant until chooses to exit
                     */
                    break;

                /*
                 * Search topics for a word
                 */
                case 6:

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
                    break;

                /*
                 * Save to file
                 */
                case 9:
                    /*
                     * Write to file in same format as input file
                     * GIVEN A FILE NAME???
                     */
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

    public static void browseTopics(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                DoublyLinkedList.DNode current = dll.getHead();

                int index = 1;
                while (current != null && index != userChoice) {
                    current = current.next;
                    index++;
                }
                if (current != null) {
                    System.out.println("Topic: " + current.getData().getTopic());
                    current.getData().getWords().printList();;
                } else {
                    System.out.println("Invalid index.");
                }
            }

        } while(restart);

    }// end of browseTopics

    public static DoublyLinkedList insertATopicBefore(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                int newIndex = userChoice - 1;
                System.out.print("Enter a topic name: ");
                String newTopicName = sc.nextLine();

                // Create new linkedlist with the new words
                SinglyLinkedList newWords = new SinglyLinkedList();
                System.out.println("Enter a word - to quit press Enter:");
                String word = sc.nextLine();
                while (!word.isEmpty()) {
                    newWords.insertAtEnd(word);
                    word = sc.nextLine();
                }

                // Create new Vocab object
                Vocab newVocab = new Vocab(newTopicName, newWords);
                dll.insertAtIndex(newVocab, newIndex);
            }

        } while(restart);


        return dll;
    }// end of insertATopicBefore

    public static DoublyLinkedList insertATopicAfter(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                int newIndex = userChoice;
                System.out.print("Enter a topic name: ");
                String newTopicName = sc.nextLine();

                // Create new linkedlist with the new words
                SinglyLinkedList newWords = new SinglyLinkedList();
                System.out.println("Enter a word - to quit press Enter:");
                String word = sc.nextLine();
                while (!word.isEmpty()) {
                    newWords.insertAtEnd(word);
                    word = sc.nextLine();
                }

                // Create new Vocab object
                Vocab newVocab = new Vocab(newTopicName, newWords);
                dll.insertAtIndex(newVocab, newIndex);
            }

        } while(restart);


        return dll;
    }// end of insertATopicAfter

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

    public static DoublyLinkedList removeTopic(DoublyLinkedList dll) {
        boolean restart = true;
        do {
            displayTopics(dll);
            int userChoice = sc.nextInt();
            sc.nextLine(); // junk

            if (userChoice == 0) {
                System.out.println();
                restart = false;
            } else {
                DoublyLinkedList.DNode current = dll.getHead();

                int index = 1;
                while (current != null && index != userChoice) {
                    current = current.next;
                    index++;
                }
                if (current != null) {
                    dll.removeVocab(current.getData().getTopic());
                } else {
                    System.out.println("Invalid index.");
                }
            }

        } while(restart);
        return dll;
    } 

}// end of Driver
