/**
 * Exception thrown when candidate already in the ballot is entered again
 */
public class CandidateExistsException extends Exception{
    private String candidate;

    CandidateExistsException(String candidate) {
        this.candidate = candidate;
    }

    /**
     * Returns name of candidate vote that caused exception
     * @return name of candidate that caused exception
     */
    public String getName(){
        return this.candidate;
    }
}
