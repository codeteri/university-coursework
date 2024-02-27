public class Statement {
    private String term;
    private String sentence;
    private double confidenceScore;

  // Constructor
    public Statement(String term, String sentence, double confidenceScore){
    this.term = term;
    this.sentence = sentence;
    this.confidenceScore = confidenceScore;
    }

  // Getter methods
    public String getTerm() {
        return term;
    }

    public String getSentence() {
        return sentence;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

  // Setter method
    public void setTerm(String newTerm) {
        this.term = newTerm;
    }

    public void setSentence(String newSentence) {
        this.sentence = newSentence;
    }

    public void setConfidenceScore(double newConfidenceScore) {
        this.confidenceScore = newConfidenceScore;
    }
}
