public class Athlete {
    FinalResult finalResult;

    public Athlete(FinalResult finalResult){
        this.finalResult = finalResult;
    }

    boolean betterSkiier(Athlete otherAthlete){
        if(this.finalResult.skiResult.pointsEarned() < otherAthlete.finalResult.skiResult.pointsEarned()){
            return true;
        }else{
            return false;
        }
    }

    boolean betterShooter(Athlete otherAthlete){
        if(this.finalResult.shootResult.pointsEarned() > otherAthlete.finalResult.shootResult.pointsEarned()){
            return true;
        }else{
            return false;
        }
    }

    boolean hasBeaten(Athlete otherAthlete){
        if(this.betterShooter(otherAthlete) || this.betterSkiier(otherAthlete)){
            return true;
        }else{
            return false;
        }
    }
}
