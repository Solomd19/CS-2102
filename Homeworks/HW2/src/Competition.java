import java.util.LinkedList;

/**
 * Represents a competition with an amount of shooting rounds
 * and list of Athletes participating
 *
 * @author dmsolomon
 */

public class Competition {

    int shootRounds;
    LinkedList<Athlete> athletes;

    //Constructor
    public Competition(int shootRounds, LinkedList<Athlete> athletes){
        this.shootRounds = shootRounds;
        this.athletes = athletes;
    }

    /**
     *Returns produces a LinkedList of the names of the Athletes in
     *  the competition whose list of ShootingRounds is less than the
     *  number of rounds specified by shootRounds
     *
     * @return LinkedList of Athletes' names who did not complete enough
     * shooting rounds
     */
    public LinkedList<String> shootingDNF(){
        LinkedList<String> shootDNF = new LinkedList<String>();

        for (Athlete currAthlete : athletes) {
            if(currAthlete.finalResult.shootResult.rounds.size() < shootRounds){
                shootDNF.add(currAthlete.name);
            }
        }

        return shootDNF;
    }

    /**
     * Calculate's an Athlete's final score for the biathlon, subtracting
     * penalty points from their total points earned
     *
     * @param name name of Athlete for whom to calculate final score for
     * @return double representing athlete's final score across the biathlon
     */
    public double finalScoreForAthlete(String name){
        for (Athlete currAthlete : athletes) {
            if(currAthlete.name.equals(name)){
                return currAthlete.finalResult.finalScore();
            }
        }
        return -1.0; //Error case
    }

    /**
     * Indicates if any Athletes in a Competition had an improved score
     * in a following Competition
     *
     * @param otherComp the competition to compare against (which was held later)
     * @return boolean indicating if any Athletes improved between competitions
     */
    public boolean anyImprovement(Competition otherComp){
        for (Athlete currAthlete : athletes) {
            for (Athlete currAthleteOther : otherComp.athletes) {
                if(currAthlete.name.equals(currAthleteOther.name)){
                    if(currAthlete.finalResult.finalScore() < currAthleteOther.finalResult.finalScore()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

//Question 13 answer
/*
One useful helper function to have would be one which could identify an
athlete and take it from a linked list only from a name String.
This is done within my solution for each of these problems and would
likely be done so again if more functionality were to be added, so the
usefulness of such a function would be great.

Other than that I am generally satisfied with the organization of the code.
(Not much other shared functionality between the functions)
 */