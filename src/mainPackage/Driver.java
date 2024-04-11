package mainPackage;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
        System.out.print("Enter the name of the input file: ");
        String inputFile = scanner.nextLine();
        System.out.println("Done Loading");

        scanner.close();
    }
    
}
