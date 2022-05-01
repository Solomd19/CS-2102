import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples(){}
    
    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */

    @Test
    public void sharkLenCheck(){
        Shark testShark1 = new Shark(18, 1);
        Shark testShark2 = new Shark(10, 1);
        assertTrue(testShark1.isNormalSize());
        assertTrue(testShark2.isNormalSize());
    }

    @Test
    public void testIsDangerToPeople(){
        Dillo testDillo = new Dillo(14, false);
        Boa testBoa1 = new Boa("Bessie", 14, "mice");
        Boa testBoa2 = new Boa("Amogus", 14, "people");
        Fish testFish = new Fish(3, 3.75);
        Shark testShark1 = new Shark(18, 0);
        Shark testShark2 = new Shark(10, 1);

        assertFalse(testDillo.isDangerToPeople());
        assertFalse(testBoa1.isDangerToPeople());
        assertTrue(testBoa2.isDangerToPeople());
        assertFalse(testFish.isDangerToPeople());
        assertFalse(testShark1.isDangerToPeople());
        assertTrue(testShark2.isDangerToPeople());
    }


}