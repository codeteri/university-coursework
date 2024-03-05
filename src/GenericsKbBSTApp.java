import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GenericsKbBSTApp {
    private BinarySearchTree<Statement> knowledgeBase;

    public GenericsKbBSTApp() {
        knowledgeBase = new BinarySearchTree<>();
    }

    // Load initial knowledge base from a file
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    String term = parts[0];
                    String sentence = parts[1];
                    double confidenceScore = Double.parseDouble(parts[2]);

                    Statement newStatement = new Statement(term, sentence, confidenceScore);
                    knowledgeBase.insert(newStatement);
                } else {
                    System.out.println("Invalid line in the file: " + line);
                }
            }
            System.out.println("Knowledge base loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // Load additional statements from a file
    public void loadAdditionalFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    String term = parts[0];
                    String sentence = parts[1];
                    double confidenceScore = Double.parseDouble(parts[2]);

                    Statement newStatement = new Statement(term, sentence, confidenceScore);
                    knowledgeBase.insert(newStatement);
                } else {
                    System.out.println("Invalid line in the file: " + line);
                }
            }
            System.out.println("Additional statements loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // Add a new statement to the knowledge base BST
    public void addStatement(String term, String sentence, double confidenceScore) {
        Statement newStatement = new Statement(term, sentence, confidenceScore);
        knowledgeBase.insert(newStatement);
        System.out.println("New statement added for term " + term + ".");
    }

    // Search for a term in the knowledge base BST
    public void searchByTerm(String term) {
        BinaryTreeNode<Statement> foundNode = knowledgeBase.searchByTerm(new Statement(term));
        if (foundNode != null) {
            System.out.println("Statement found: " + foundNode.data);
        } else {
            System.out.println("No statement found for term " + term + ".");
        }
    }

    // Search for a term and sentence in the knowledge base BST
    public void searchByTermAndSentence(String term, String sentence) {
        BinaryTreeNode<Statement> foundNode = knowledgeBase.searchByTermAndSentence(new Statement(term), sentence);
        if (foundNode != null) {
            System.out.println("Statement found: " + foundNode.data);
        } else {
            System.out.println("No matching statement found for term and sentence.");
        }
    }

    // Display the knowledge base tree
    public void displayTree() {
        knowledgeBase.displayTree();
    }

    // Display the menu
    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("------ Knowledge Base Menu ------");
            System.out.println("1. Search by term");
            System.out.println("2. Search by term and sentence");
            System.out.println("3. Add new statement");
            System.out.println("4. Display Knowledge Base");
            System.out.println("5. Load additional statements from file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter term to search: ");
                    String termToSearch = scanner.nextLine();
                    searchByTerm(termToSearch);
                    break;
                case 2:
                    System.out.print("Enter term to search: ");
                    String termToSearch2 = scanner.nextLine();
                    System.out.print("Enter sentence to search: ");
                    String sentenceToSearch = scanner.nextLine();
                    searchByTermAndSentence(termToSearch2, sentenceToSearch);
                    break;
                case 3:
                    System.out.print("Enter term for new statement: ");
                    String newTerm = scanner.nextLine();
                    System.out.print("Enter sentence for new statement: ");
                    String newSentence = scanner.nextLine();
                    System.out.print("Enter confidence score for new statement: ");
                    double confidenceScore = scanner.nextDouble();
                    addStatement(newTerm, newSentence, confidenceScore);
                    break;
                case 4:
                    displayTree();
                    break;
                case 5:
                    System.out.print("Enter file name for additional statements: ");
                    String additionalFileName = scanner.nextLine();
                    loadAdditionalFromFile(additionalFileName);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }

    public static void main(String[] args) {
        GenericsKbBSTApp app = new GenericsKbBSTApp();
        app.loadFromFile("GenericsKB.txt");

        // Display the menu
        app.displayMenu();
    }
}
