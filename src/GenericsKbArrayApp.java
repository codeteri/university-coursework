// package binarytreecode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GenericsKbArrayApp {
    private Statement[] knowledgeBase;
    private int knowledgeBaseSize;  // To keep track of the number of statements in the array

    public GenericsKbArrayApp(int maxSize) {
        knowledgeBase = new Statement[maxSize];
        knowledgeBaseSize = 0;
    }

    // Load initial knowledge base from a file
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                String term = parts[0];
                String sentence = parts[1];
                double confidenceScore = Double.parseDouble(parts[2]);
                addStatement(term, sentence, confidenceScore);
            }
            System.out.println("Knowledge base loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load additional statements from a file
    public void loadAdditionalFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                String term = parts[0];
                String sentence = parts[1];
                double confidenceScore = Double.parseDouble(parts[2]);
                addStatement(term, sentence, confidenceScore);
            }
            System.out.println("Additional statements loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a new statement to the knowledge base array
    public void addStatement(String term, String sentence, double confidenceScore) {
        // Check if the term already exists in the knowledge base
        for (int i = 0; i < knowledgeBaseSize; i++) {
            if (knowledgeBase[i].getTerm().equals(term)) {
                // Update the statement if the new confidence score is higher
                if (confidenceScore >= knowledgeBase[i].getConfidenceScore()) {
                    knowledgeBase[i].setSentence(sentence);
                    knowledgeBase[i].setConfidenceScore(confidenceScore);
                    System.out.println("Statement for term " + term + " has been updated.");
                    return;
                } else {
                    // Do not update if the new confidence score is lower
                    System.out.println("Confidence score for term " + term + " is already higher.");
                    return;
                }
            }
        }

        // Add a new statement if the term doesn't exist
        if (knowledgeBaseSize < knowledgeBase.length) {
            knowledgeBase[knowledgeBaseSize++] = new Statement(term, sentence, confidenceScore);
            System.out.println("New statement added for term " + term + ".");
        } else {
            System.out.println("Knowledge base is full. Cannot add new statement for term " + term + ".");
        }
    }

    // Search for a term in the knowledge base array
    public void searchByTerm(String term) {
        for (int i = 0; i < knowledgeBaseSize; i++) {
            if (knowledgeBase[i].getTerm().equals(term)) {
                System.out.println("Statement found: " + knowledgeBase[i].getSentence() +
                        " (Confidence score: " + knowledgeBase[i].getConfidenceScore() + ")");
                return;
            }
        }
        System.out.println("No statement found for term " + term + ".");
    }

    // Search for a term and sentence in the knowledge base array
    public void searchByTermAndSentence(String term, String sentence) {
        for (int i = 0; i < knowledgeBaseSize; i++) {
            if (knowledgeBase[i].getTerm().equals(term) && knowledgeBase[i].getSentence().equals(sentence)) {
                System.out.println("The statement was found and has a confidence score of " + knowledgeBase[i].getConfidenceScore() + ".");
                return;
            }
        }
        System.out.println("No matching statement found for term and sentence.");
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Load a knowledge base from a file");
            System.out.println("2. Add a new statement to the knowledge base");
            System.out.println("3. Search for an item in the knowledge base by term");
            System.out.println("4. Search for an item in the knowledge base by term and sentence");
            System.out.println("5. Load additional statements from file");
            System.out.println("6. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    loadFromFile(fileName);
                    break;
                case 2:
                    System.out.print("Enter the term: ");
                    String term = scanner.nextLine();
                    System.out.print("Enter the statement: ");
                    String statement = scanner.nextLine();
                    System.out.print("Enter the confidence score: ");
                    double confidenceScore = scanner.nextDouble();
                    addStatement(term, statement, confidenceScore);
                    break;
                case 3:
                    System.out.print("Enter the term to search: ");
                    term = scanner.nextLine();
                    searchByTerm(term);
                    break;
                case 4:
                    System.out.print("Enter the term: ");
                    term = scanner.nextLine();
                    System.out.print("Enter the statement to search for: ");
                    statement = scanner.nextLine();
                    searchByTermAndSentence(term, statement);
                    break;
                case 5:
                    System.out.print("Enter file name for additional statements: ");
                    String additionalFileName = scanner.nextLine();
                    loadAdditionalFromFile(additionalFileName);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }

    public static void main(String[] args) {
        // Testing
        GenericsKbArrayApp app = new GenericsKbArrayApp(100000);

        // Display menu for user interactions
        app.displayMenu();
    }
}
