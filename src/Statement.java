// package binarytreecode;
public class Statement implements Comparable<Statement> {
    private String term;
    private String sentence;
    private double confidenceScore;

    // Constructor
    public Statement(String term, String sentence, double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
    }

    public Statement(String term) {
        this.term = term;
        this.sentence = "";  // Default sentence
        this.confidenceScore = 0.0;  // Default confidence score
    }

    // Getter methods
    public String getTerm() {
        return term;
    }

    public String getSentence() {
        return sentence;
    }

    public double getConfidenceScore() {
        return confidenceScore;
    }

    // Setter methods
    public void setTerm(String newTerm) {
        this.term = newTerm;
    }

    public void setSentence(String newSentence) {
        this.sentence = newSentence;
    }

    public void setConfidenceScore(double newConfidenceScore) {
        this.confidenceScore = newConfidenceScore;
    }

    @Override
    public int compareTo(Statement other) {
        // Implement comparison logic based on your requirements
        // For example, compare terms or sentences
        return this.getTerm().compareTo(other.getTerm());
    }

    @Override
    public String toString() {
        return "Statement {" +
                "term: " + term +
                ", sentence:" + sentence +
                " , confidenceScore:" + confidenceScore +
                '}';
    }
}
