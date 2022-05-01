/**
 * Exception thrown when voting for a candidate more than once in a single form
 */
public class DuplicateVotesException extends Exception{
    private String candidate;

    DuplicateVotesException(String candidate) {
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