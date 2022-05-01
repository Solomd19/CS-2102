public class FinalResult {
    ShootingResult shootResult;
    SkiingResult skiResult;

    public FinalResult(ShootingResult shootResult, SkiingResult skiResult){
        this.shootResult = shootResult;
        this.skiResult = skiResult;
    }

    public double finalScore(){
        double score = skiResult.pointsEarned() + shootResult.getPenalties() + skiResult.getPenalties();
        switch (skiResult.place){
            case 4:
                score -= 1;
                break;
            case 3:
                score -= 3;
                break;
            case 2:
                score -= 7;
                break;
            case 1:
                score -= 10;
                break;
        }
        return score;
    }
}
