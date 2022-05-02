import java.util.HashMap;

/**
 * Class which holds all election data and related handling functions
 */
class ElectionData {
    private HashMap<String, Integer> firstVotes;
    private HashMap<String, Integer> secondVotes;
    private HashMap<String, Integer> thirdVotes;

    //private Scanner keyboard = new Scanner(System.in);

    public ElectionData() {
        firstVotes = new HashMap<String, Integer>();
        secondVotes = new HashMap<String, Integer>();
        thirdVotes = new HashMap<String, Integer>();
    }

    /**
     * Prints out all candidates currently in the ballot
     */
    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : firstVotes.keySet()) {
            System.out.println(s);
        }
    }

    /**
     * Adds first, second, and third choice candidate votes to each candidate
     *
     * @param firstVote  choice of candidate for first place
     * @param secondVote choice of candidate for second place
     * @param thirdVote  choice of candidate for third place
     * @throws UnknownCandidateException thrown if candidate entered doesn't exist in the ballot
     * @throws DuplicateVotesException thrown if a single candidate is voted for more than once in the ballot
     */
    public void processVote(String firstVote, String secondVote, String thirdVote) throws UnknownCandidateException, DuplicateVotesException {

        if (!firstVotes.containsKey(firstVote)) {
            throw new UnknownCandidateException(firstVote);
        }
        if (!secondVotes.containsKey(secondVote)) {
            throw new UnknownCandidateException(secondVote);
        }
        if (!thirdVotes.containsKey(thirdVote)) {
            throw new UnknownCandidateException(thirdVote);
        }
        if (firstVote.equals(secondVote) || firstVote.equals(thirdVote)) {
            throw new DuplicateVotesException(firstVote);
        }
        if (secondVote.equals(firstVote) || secondVote.equals(thirdVote)) {
            throw new DuplicateVotesException(secondVote);
        }
        if (thirdVote.equals(firstVote) || thirdVote.equals(secondVote)) {
            throw new DuplicateVotesException(thirdVote);
        }

        firstVotes.replace(firstVote, firstVotes.get(firstVote) + 1);
        secondVotes.replace(secondVote, secondVotes.get(secondVote) + 1);
        thirdVotes.replace(thirdVote, thirdVotes.get(thirdVote) + 1);


    }

    /**
     * Adds a candidate to the ballot if they are not already entered
     * @param candidate candidate to add to ballot
     * @throws CandidateExistsException thrown if candidate entered already exists in the ballot
     */
    public void addCandidate(String candidate) throws CandidateExistsException {
        if (firstVotes.containsKey(candidate)) {
            throw new CandidateExistsException(candidate);
        } else {
            firstVotes.put(candidate, 0);
            secondVotes.put(candidate, 0);
            thirdVotes.put(candidate, 0);
        }
    }

    /**
     * The winner is the candidate with more than 50% of first place votes. If no candidate receives more than 50% of the votes, return the string "Runoff required".
     *
     * @return Name of winner or indication that a runoff election is required
     */
    public String findWinnerMostFirstVotes() {
        int totalVotes = 0;
        int maxVotes = 0;
        String currWinner = "N/A";

        for (String e : firstVotes.keySet()) {
            int currVotes = firstVotes.get(e);
            totalVotes += currVotes;
            if (currVotes > maxVotes) {
                maxVotes = currVotes;
                currWinner = e;
            }
        }

        if (maxVotes >= totalVotes / 2.0) {
            return currWinner;
        } else {
            return "Runoff required";
        }
    }

    /**
     * the winner is the candidate with the most points under the following formula:
     * three points for each first-place vote they received,
     * two points for each second-place vote they received,
     * and one point for each third-place vote they received
     *
     * @return Name of winner
     */
    public String findWinnerMostPoints() {
        int maxVotes = 0;
        String currWinner = "N/A";

        for (String e : firstVotes.keySet()) {
            int currVotes = firstVotes.get(e) * 3 + secondVotes.get(e) * 2 + thirdVotes.get(e);
            if (currVotes > maxVotes) {
                maxVotes = currVotes;
                currWinner = e;
            }
        }
        return currWinner;
    }

    /**
     * Determines if two ElectionData objects are equal
     * @param otherDataObj other ElectionData to compare to
     * @return Indication of if two ElectionData objects are equal
     */
    @Override
    public boolean equals(Object otherDataObj){
        ElectionData otherData = (ElectionData) otherDataObj;
        if(this.firstVotes.size() != otherData.firstVotes.size()
                || this.secondVotes.size() != otherData.secondVotes.size()
                || this.thirdVotes.size() != otherData.thirdVotes.size()){
            return false;
        }

        for (String e : firstVotes.keySet()) {
            if(otherData.firstVotes.containsKey(e) == false || this.firstVotes.get(e) != otherData.firstVotes.get(e)){
                return false;
            }
        }

        for (String e : secondVotes.keySet()) {
            if(otherData.secondVotes.containsKey(e) == false || this.secondVotes.get(e) != otherData.secondVotes.get(e)){
                return false;
            }
        }

        for (String e : thirdVotes.keySet()) {
            if(otherData.thirdVotes.containsKey(e) == false || this.thirdVotes.get(e) != otherData.thirdVotes.get(e)){
                return false;
            }
        }
        return true;
    }

}
