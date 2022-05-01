import static org.junit.Assert.*;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Examples {

    public Examples(){}

    ShootingRound shootingRound1_1 = new ShootingRound(1);
    ShootingRound shootingRound1_2 = new ShootingRound(1);
    ShootingRound shootingRound1_3 = new ShootingRound(1);
    ShootingRound shootingRound1_4 = new ShootingRound(1);

    ShootingResult shootingResult1 = new ShootingResult(shootingRound1_1, shootingRound1_2, shootingRound1_3, shootingRound1_4);
    SkiingResult skiingResult1 = new SkiingResult(4, 36.0, 18.0, 24.0, 36.0, 49);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult1 = new FinalResult(shootingResult1, skiingResult1);
    Athlete athlete1 = new Athlete(finalResult1, "Alex");

    ShootingRound shootingRound2_1 = new ShootingRound(3, true);
    ShootingRound shootingRound2_2 = new ShootingRound(2, false);
    ShootingRound shootingRound2_3 = new ShootingRound(4, true);
    ShootingRound shootingRound2_4 = new ShootingRound(5, false);

    ShootingResult shootingResult2 = new ShootingResult(shootingRound2_1, shootingRound2_2, shootingRound2_3, shootingRound2_4);
    SkiingResult skiingResult2 = new SkiingResult(2, 5.0, 5.0, 5.0, 5.0, 2);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult2 = new FinalResult(shootingResult2, skiingResult2);
    Athlete athlete2 = new Athlete(finalResult2, "Bob");

    ShootingRound shootingRound3_1 = new ShootingRound(5);
    ShootingRound shootingRound3_2 = new ShootingRound(5);
    ShootingRound shootingRound3_3 = new ShootingRound(5);
    ShootingRound shootingRound3_4 = new ShootingRound(5);

    ShootingResult shootingResult3 = new ShootingResult(shootingRound3_1, shootingRound3_2, shootingRound3_3, shootingRound3_4);
    SkiingResult skiingResult3 = new SkiingResult(1, 1.0, 1.0, 1.0, 1.0, 0);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult3 = new FinalResult(shootingResult3, skiingResult3);
    Athlete athlete3 = new Athlete(finalResult3, "Chris");

    ShootingRound shootingRound4_1 = new ShootingRound(2);
    ShootingRound shootingRound4_2 = new ShootingRound(3);
    ShootingRound shootingRound4_3 = new ShootingRound(2);
    ShootingRound shootingRound4_4 = new ShootingRound(4);

    ShootingResult shootingResult4 = new ShootingResult(shootingRound4_1, shootingRound4_2, shootingRound4_3, shootingRound4_4);
    SkiingResult skiingResult4 = new SkiingResult(3, 10.0, 10.0, 10.0, 10.0, 5);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResult4 = new FinalResult(shootingResult4, skiingResult4);
    Athlete athlete4 = new Athlete(finalResult4, "Drew");

    ShootingResult shootingResultBLANK = new ShootingResult(new LinkedList<ShootingRound>());
    SkiingResult skiingResultBLANK = new SkiingResult(3, 5);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
    FinalResult finalResultBLANK = new FinalResult(new ShootingResult(new LinkedList<ShootingRound>()), skiingResult4);
    Athlete athleteBLANK = new Athlete(finalResultBLANK, "Ewan");



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
        assertEquals(skiingResultBLANK.pointsEarned(), 0, 0);
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
        assertEquals(finalResult1.finalScore(), 1318.0, 1);
        assertEquals(finalResult2.finalScore(), 383.0, 1);
        assertEquals(finalResult3.finalScore(), -6.0, 1);
        assertEquals(finalResult4.finalScore(), 602.0, 1);
    }

    @Test
    public void betterSkiierCheck() {
        assertTrue(athlete3.betterSkiier(athlete1));
        assertTrue(athlete3.betterSkiier(athlete2));
        assertTrue(athlete3.betterSkiier(athlete4));
        assertFalse(athlete1.betterSkiier(athlete2));
        assertFalse(athlete1.betterSkiier(athlete3));
        assertFalse(athlete1.betterSkiier(athlete4));
    }

    @Test
    public void betterShooterCheck() {
        assertTrue(athlete3.betterSkiier(athlete1));
        assertTrue(athlete3.betterSkiier(athlete2));
        assertTrue(athlete3.betterSkiier(athlete4));
        assertFalse(athlete1.betterSkiier(athlete2));
        assertFalse(athlete1.betterSkiier(athlete3));
        assertFalse(athlete1.betterSkiier(athlete4));
    }

    @Test
    public void hasBeatenCheck() {
        assertTrue(athlete3.betterSkiier(athlete2));
        assertTrue(athlete2.betterSkiier(athlete4));
        assertTrue(athlete4.betterSkiier(athlete1));
        assertFalse(athlete1.betterSkiier(athlete4));
        assertFalse(athlete4.betterSkiier(athlete2));
        assertFalse(athlete2.betterSkiier(athlete3));

    }

//    ShootingRound shootingRound2_1 = new ShootingRound(3, true);
//    ShootingRound shootingRound2_2 = new ShootingRound(2, false);
//    ShootingRound shootingRound2_3 = new ShootingRound(4, true);
//    ShootingRound shootingRound2_4 = new ShootingRound(5, false);

    @Test
    public void testBestRoundByType(){ //Step 9
        assertEquals(athlete2.finalResult.shootResult.bestRoundByType(true), shootingRound2_3);
        assertEquals(athlete2.finalResult.shootResult.bestRoundByType(false), shootingRound2_4);
        assertEquals(athleteBLANK.finalResult.shootResult.bestRoundByType(true), null);
        assertNull(athleteBLANK.finalResult.shootResult.bestRoundByType(false));
    }

    @Test
    public void testShootingDNF(){ //Step 10
        LinkedList<Athlete> comp1Athletes = new LinkedList<Athlete>();
        comp1Athletes.add(athlete1);
        comp1Athletes.add(athlete2);
        comp1Athletes.add(athlete3);
        comp1Athletes.add(athlete4);
        comp1Athletes.add(athleteBLANK);
        Competition comp1 = new Competition(4, comp1Athletes);
        Competition comp2 = new Competition(5, comp1Athletes);
        Competition comp3 = new Competition(0, comp1Athletes);
        LinkedList<String> nameList = new LinkedList<String>();
        nameList.add("Alex");
        nameList.add("Bob");
        nameList.add("Chris");
        nameList.add("Drew");
        nameList.add("Ewan");
        LinkedList<String> ewanList = new LinkedList<String>();
        ewanList.add("Ewan");

        assertEquals(comp1.shootingDNF(), ewanList);
        assertEquals(comp2.shootingDNF(), nameList);
        assertEquals(comp3.shootingDNF(), new LinkedList<String>());
    }

    @Test
    public void testFinalScoreForAthlete(){ //Step 11
        LinkedList<Athlete> comp1Athletes = new LinkedList<Athlete>();
        comp1Athletes.add(athlete1);
        comp1Athletes.add(athlete2);
        comp1Athletes.add(athlete3);
        comp1Athletes.add(athlete4);
        comp1Athletes.add(athleteBLANK);
        Competition comp1 = new Competition(4, comp1Athletes);

        assertEquals(comp1.finalScoreForAthlete("Alex"), 1318.0, 0);
        assertEquals(comp1.finalScoreForAthlete("Bob"), 383.0, 0);
        assertEquals(comp1.finalScoreForAthlete("Chris"), -6.0, 0);
        assertEquals(comp1.finalScoreForAthlete("Drew"), 602.0, 0);
        assertEquals(comp1.finalScoreForAthlete("Ewan"), 62.0, 0);
        assertEquals(comp1.finalScoreForAthlete("FAKE NAME"), -1, 0);
    }

    @Test
    public void testAnyImprovement(){ //Step 12
        LinkedList<Athlete> comp1Athletes = new LinkedList<Athlete>();
        comp1Athletes.add(athlete1);
        comp1Athletes.add(athlete2);
        comp1Athletes.add(athlete3);
        comp1Athletes.add(athlete4);
        comp1Athletes.add(athleteBLANK);

        Competition comp1 = new Competition(4, comp1Athletes);
        Competition comp2 = new Competition(4, comp1Athletes);

        ShootingRound shootingRoundNEW_1 = new ShootingRound(5);
        ShootingRound shootingRoundNEW_2 = new ShootingRound(5);
        ShootingRound shootingRoundNEW_3 = new ShootingRound(5);
        ShootingRound shootingRoundNEW_4 = new ShootingRound(5);

        ShootingResult shootingResultNEW = new ShootingResult(shootingRoundNEW_1, shootingRoundNEW_2, shootingRoundNEW_3, shootingRoundNEW_4);
        SkiingResult skiingResultNEW = new SkiingResult(1, 1.0, 1.0, 1.0, 1.0, 1);	//Position, Lap 1, Lap 2, Lap 3, Lap 4, penalties
        FinalResult finalResultNEW = new FinalResult(shootingResultNEW, skiingResultNEW);
        Athlete newDrew = new Athlete(finalResultNEW, "Drew");

        LinkedList<Athlete> comp3Athletes = new LinkedList<Athlete>();
        comp3Athletes.add(athlete1);
        comp3Athletes.add(athlete2);
        comp3Athletes.add(athlete3);
        comp3Athletes.add(newDrew);
        comp3Athletes.add(athleteBLANK);
        Competition comp3 = new Competition(4, comp3Athletes);

        assertFalse(comp1.anyImprovement(comp2));
        assertFalse(comp2.anyImprovement(comp1));
        assertTrue(comp3.anyImprovement(comp1));
        assertFalse(comp1.anyImprovement(comp3));


    }

}
