import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples(){}

    ShootingRound shootingRound1_1 = new ShootingRound(1);
    ShootingRound shootingRound1_2 = new ShootingRound(1);
    ShootingRound shootingRound1_3 = new ShootingRound(1);
    ShootingRound shootingRound1_4 = new ShootingRound(1);

    ShootingResult shootingResult1 = new ShootingResult(shootingRound1_1, shootingRound1_2, shootingRound1_3, shootingRound1_4);
    SkiingResult skiingResult1 = new SkiingResult(4, 36.0, 18.0, 24.0, 36.0, 49);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult1 = new FinalResult(shootingResult1, skiingResult1);
    Athlete athlete1 = new Athlete(finalResult1);

    ShootingRound shootingRound2_1 = new ShootingRound(3);
    ShootingRound shootingRound2_2 = new ShootingRound(2);
    ShootingRound shootingRound2_3 = new ShootingRound(4);
    ShootingRound shootingRound2_4 = new ShootingRound(5);

    ShootingResult shootingResult2 = new ShootingResult(shootingRound2_1, shootingRound2_2, shootingRound2_3, shootingRound2_4);
    SkiingResult skiingResult2 = new SkiingResult(2, 5.0, 5.0, 5.0, 5.0, 2);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult2 = new FinalResult(shootingResult2, skiingResult2);
    Athlete athlete2 = new Athlete(finalResult2);

    ShootingRound shootingRound3_1 = new ShootingRound(5);
    ShootingRound shootingRound3_2 = new ShootingRound(5);
    ShootingRound shootingRound3_3 = new ShootingRound(5);
    ShootingRound shootingRound3_4 = new ShootingRound(5);

    ShootingResult shootingResult3 = new ShootingResult(shootingRound3_1, shootingRound3_2, shootingRound3_3, shootingRound3_4);
    SkiingResult skiingResult3 = new SkiingResult(1, 1.0, 1.0, 1.0, 1.0, 0);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult3 = new FinalResult(shootingResult3, skiingResult3);
    Athlete athlete3 = new Athlete(finalResult3);

    ShootingRound shootingRound4_1 = new ShootingRound(2);
    ShootingRound shootingRound4_2 = new ShootingRound(3);
    ShootingRound shootingRound4_3 = new ShootingRound(2);
    ShootingRound shootingRound4_4 = new ShootingRound(4);

    ShootingResult shootingResult4 = new ShootingResult(shootingRound4_1, shootingRound4_2, shootingRound4_3, shootingRound4_4);
    SkiingResult skiingResult4 = new SkiingResult(3, 10.0, 10.0, 10.0, 10.0, 5);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult4 = new FinalResult(shootingResult4, skiingResult4);
    Athlete athlete4 = new Athlete(finalResult4);


    @Test
    public void simpleCheck() {
        assertEquals(4, 4);
    }

    @Test
    public void getPointsSkiCheck() {
        assertEquals(skiingResult1.pointsEarned(), 114.0, 0);
        assertEquals(skiingResult2.pointsEarned(), 20.0, 0);
        assertEquals(skiingResult3.pointsEarned(), 4.0, 0);
        assertEquals(skiingResult4.pointsEarned(), 40.0, 0);
    }

    @Test
    public void getPenaltiesSkiCheck() {
        assertEquals(skiingResult1.getPenalties(), 245.0, 0);
        assertEquals(skiingResult2.getPenalties(), 10.0, 0);
        assertEquals(skiingResult3.getPenalties(), 0.0, 0);
        assertEquals(skiingResult4.getPenalties(), 25.0, 0);
    }

    @Test
    public void getPointsShootCheck() {
        assertEquals(shootingResult1.pointsEarned(), 4.0, 0);
        assertEquals(shootingResult2.pointsEarned(), 14.0, 0);
        assertEquals(shootingResult3.pointsEarned(), 20.0, 0);
        assertEquals(shootingResult4.pointsEarned(), 11.0, 0);
    }

    @Test
    public void getPenaltiesShootCheck() {
        assertEquals(shootingResult1.getPenalties(), 960.0, 0);
        assertEquals(shootingResult2.getPenalties(), 360.0, 0);
        assertEquals(shootingResult3.getPenalties(), 0.0, 0);
        assertEquals(shootingResult4.getPenalties(), 540.0, 0);
    }

    @Test
    public void finalScoreCheck() {
        assertEquals(finalResult1.finalScore(), 1318.0, 0);
        assertEquals(finalResult2.finalScore(), 383.0, 0);
        assertEquals(finalResult3.finalScore(), -6.0, 0);
        assertEquals(finalResult4.finalScore(), 602.0, 0);
    }

    @Test
    public void betterSkiierCheck() {
        assertEquals(athlete3.betterSkiier(athlete1), true);
        assertEquals(athlete3.betterSkiier(athlete2), true);
        assertEquals(athlete3.betterSkiier(athlete4), true);
        assertEquals(athlete1.betterSkiier(athlete2), false);
        assertEquals(athlete1.betterSkiier(athlete3), false);
        assertEquals(athlete1.betterSkiier(athlete4), false);
    }

    @Test
    public void betterShooterCheck() {
        assertEquals(athlete3.betterShooter(athlete1), true);
        assertEquals(athlete3.betterShooter(athlete2), true);
        assertEquals(athlete3.betterShooter(athlete4), true);
        assertEquals(athlete1.betterShooter(athlete2), false);
        assertEquals(athlete1.betterShooter(athlete3), false);
        assertEquals(athlete1.betterShooter(athlete4), false);
    }

    @Test
    public void hasBeatenCheck() {
        assertEquals(athlete3.hasBeaten(athlete2), true);
        assertEquals(athlete2.hasBeaten(athlete4), true);
        assertEquals(athlete4.hasBeaten(athlete1), true);
        assertEquals(athlete1.hasBeaten(athlete4), false);
        assertEquals(athlete4.hasBeaten(athlete2), false);
        assertEquals(athlete2.hasBeaten(athlete3), false);

    }
  
}
