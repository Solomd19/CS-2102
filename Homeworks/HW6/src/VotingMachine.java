import java.util.Scanner;

/**
 * Class that acts as the voting machine which the user interfaces with
 */
public class VotingMachine {

    private ElectionData myElection;
    private Scanner keyboard = new Scanner(System.in);


    public VotingMachine() {
        myElection = new ElectionData();
    }

    /**
     * Functions as the user interface for voting, takes keyboard input for the first, second and third choice votes
     */
    public void screen() {
        myElection.printBallot();
        System.out.println("Who do you want to vote for first?");
        String firstVote = keyboard.next();

        System.out.println("Who do you want to vote for second?");
        String secondVote = keyboard.next();

        System.out.println("Who do you want to vote for third?");
        String thirdVote = keyboard.next();

        try{
            myElection.processVote(firstVote, secondVote, thirdVote);
        }catch (UnknownCandidateException candidate) {
            System.out.println("Candidate " + candidate.getName() + " is not currently in the ballot. Would you like to add them to the ballot? (Y/N)");
            String yesOrNo = keyboard.next();
            if(yesOrNo.equalsIgnoreCase("Y")){
                addWriteIn(candidate.getName());
            }else{
                System.out.println("Please try voting again.");
            }
            //return;
        }catch (DuplicateVotesException candidate){
            System.out.println("Candidate " + candidate.getName() + " was voted for multiple times. Please try voting again.");
            this.screen();
            //return;
        }

        System.out.println("You voted for:");
        System.out.println("First: " + firstVote);
        System.out.println("Second: " + secondVote);
        System.out.println("Third: " + thirdVote);

    }

    /**
     * Used when a candidate not in the ballot is voted for, adds them to ballot
     * @param candidate The candidate in question
     */
    public void addWriteIn(String candidate){
        try{
            myElection.addCandidate(candidate);
        }catch (CandidateExistsException candidateExists){
            System.out.println("Candidate " + candidate + " already is in the ballot. Please try voting again.");
        }
        System.out.println("Candidate " + candidate + " was added to the ballot! Please try voting again.");

    }
}
