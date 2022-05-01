public class Main {
    public static void main(String[] args) {

        // what to do on startup goes here
        VoteBooth myBooth = new VoteBooth();
        myBooth.screen();

        myBooth.voteD.castVote("Gompei");
        myBooth.voteD.castVote("Gompei");
        myBooth.voteD.castVote("Gompei");
        myBooth.voteD.castVote("Gompei");
        myBooth.voteD.castVote("Husky");
        myBooth.voteD.castVote("Husky");
        myBooth.voteD.castVote("Gompei");
        System.out.println("Longest Gompei Streak Was: " + myBooth.voteD.longestStreak("Gompei"));
        System.out.println("Longest Gompei Streak Was: " + myBooth.voteD.longestStreak("Husky"));
    }
}
