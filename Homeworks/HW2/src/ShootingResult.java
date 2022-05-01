import java.util.LinkedList;

public class ShootingResult implements IEvent{

    LinkedList<ShootingRound> rounds = new LinkedList<ShootingRound>();

    public ShootingResult(ShootingRound round1, ShootingRound round2, ShootingRound round3, ShootingRound round4){
        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);
        rounds.add(round4);
    }

    public ShootingResult(LinkedList<ShootingRound> rounds){
        this.rounds = rounds;
    }

    /**
     * Calculates points earned across all of an Athlete's
     * shooting rounds based on targets hit
     *
     * @return double representing points earned across all rounds
     */
    public double pointsEarned(){
        int totalTargets = 0;
        if(rounds.size() <= 0){
            return 0;
        }
        for (ShootingRound currRound : rounds) {
            totalTargets += currRound.targets;
        }
        return totalTargets;
    }

    public double getPenalties(){
        return (5*rounds.size() - pointsEarned()) * 60;
    }

    /**
     *
     * @param standing indicates if requesting best round completed
     *                standing (true) or prone (false)
     * @return ShootingRound with highest score of type chosen (standing or prone)
     */
    public ShootingRound bestRoundByType(boolean standing){
        ShootingRound bestRound = null;
        for (ShootingRound currRound : rounds) {
            if(currRound.standing == standing && (bestRound == null || currRound.targets > bestRound.targets)){
                bestRound = currRound;
            }
        }
        if(bestRound != null){
            return bestRound;
        }else{
            return null;
        }
    }
}
