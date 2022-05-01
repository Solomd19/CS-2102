/**
 * Exception that is thrown when an indicated candidate is not present in the ballot
 */
public class UnknownCandidateException extends Exception{
    private String candidate;

    UnknownCandidateException(String candidate) {
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
