package mainPackage;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //While loop for the menu
        while (true) {
            System.out.print("""
            -----------------------------
             Vocabulary Control Center
            -----------------------------
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
            -----------------------------
            Enter Your Choice: """);

            int inputChoice = scanner.nextInt();

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
                    break;

                /*
                 * Remove a topic
                 */
                case 4:
                    /*
                     * Implement a method to remove a topic
                     * 1. Print all topics and ask user to choose one
                     * 2. Once a topic is chosen, remove it
                     * 3*. MAYBE FUSE TWO LINKEDLIST IDK YET
                     */
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
                    /*
                     * Just use the VocabListHandler class to read the file
                     *  --> VocabListHandler.inputToVocabObjects(TEXT FILE NAME);
                     */
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
            scanner.close();
        }
        
    }
    
}
