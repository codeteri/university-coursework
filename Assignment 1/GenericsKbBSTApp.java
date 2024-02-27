import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenericsKbBSTApp {
    private BinarySearchTree knowledgeBase;

    public GenericsKbBSTApp() {
        knowledgeBase = new BinarySearchTree();
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

    // Add a new statement to the knowledge base BST
    public void addStatement(String term, String sentence, double confidenceScore) {
        Statement newStatement = new Statement(term, sentence, confidenceScore);
        knowledgeBase.insert(newStatement);
        System.out.println("New statement added for term " + term + ".");
    }

    // Search for a term in the knowledge base BST
    public void searchByTerm(String term) {
        Statement foundStatement = knowledgeBase.searchByTerm(term);
        if (foundStatement != null) {
            System.out.println("Statement found: " + foundStatement);
        } else {
            System.out.println("No statement found for term " + term + ".");
        }
    }

    // Search for a term and sentence in the knowledge base BST
    public void searchByTermAndSentence(String term, String sentence) {
        Statement foundStatement = knowledgeBase.searchByTermAndSentence(term, sentence);
        if (foundStatement != null) {
            System.out.println("Statement found: " + foundStatement);
        } else {
            System.out.println("No matching statement found for term and sentence.");
        }
    }

    public static void main(String[] args) {
        // Example usage
        GenericsKbBSTApp app = new GenericsKbBSTApp();
        app.loadFromFile("GenericsKB.txt");

        // Test other functionalities
        app.searchByTerm("maple syrup");
        app.searchByTermAndSentence("maple syrup", "Maple syrup is made from the sweet sap that is stored in the trunk of the sugar maple.");
        app.addStatement("maple syrup", "Maple syrup is the product made when water is evaporated out of maple sap.", 0.777);
    }
}
