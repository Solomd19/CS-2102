
public class CompileCheck {

    public static void main(String[] args) {

        // dummy variables for assignment
        double x;
        boolean y;

        // test making ShootingRounds
        ShootingRound shootingRound1 = new ShootingRound(1);
        ShootingRound shootingRound2 = new ShootingRound(3);
        ShootingRound shootingRound3 = new ShootingRound(2);
        ShootingRound shootingRound4 = new ShootingRound(5);

        // test making each of the Result classes
        ShootingResult shootingResult = new ShootingResult(shootingRound1, shootingRound2, shootingRound3, shootingRound4);
        SkiingResult skiingResult = new SkiingResult(3, 12.0, 14.0, 13.0, 12.0, 7);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
        FinalResult finalResult = new FinalResult(shootingResult, skiingResult);
        
        // test making athletes
        Athlete athlete1 = new Athlete(finalResult);
        Athlete athlete2 = new Athlete(finalResult);

        // test pointsEarned and getPenalties methods
        x = skiingResult.pointsEarned();
        x = shootingResult.pointsEarned();
        x = skiingResult.getPenalties();
        x = shootingResult.getPenalties();
        x = finalResult.finalScore();

        //test betterSkiier method
        y = athlete1.betterSkiier(athlete2);

        //test betterShooter method
        y = athlete1.betterShooter(athlete2);
        
        //test hasBeaten method
        y = athlete2.hasBeaten(athlete1);
 
        System.out.println("Congrats! Your program compiled and ran!");

    }


}
