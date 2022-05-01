import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    HeapChecker HT = new HeapChecker();
    DataHeap myHeap = new DataHeap(0, new MtHeap(), new MtHeap());
    DataBT myBinTree = new DataBT(0, new MtBT(), new MtBT());

    public Examples(){}

    //You should have at least 6 tests for each method.

    ///////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIsHeapOneElt(){

        DataHeap myHeap = new DataHeap(1, new MtHeap(), new MtHeap());

        assertTrue(myHeap.isHeap());

    }

    @Test
    public void testIsHeapYesSmall(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(2, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));

        assertTrue(myHeap.isHeap());

    }

    @Test
    public void testIsHeapNoSmall(){

        DataHeap myHeap = new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new DataHeap(3, new MtHeap(), new MtHeap()));

        assertFalse(myHeap.isHeap());
    }

    @Test
    public void testIsHeapYesLarge(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(2, new DataHeap(3), new DataHeap(16)), new DataHeap(5, new DataHeap(15), new DataHeap(13)));

        assertTrue(myHeap.isHeap());

    }

    @Test
    public void testIsHeapNoLarge(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(2, new DataHeap(3), new DataHeap(16)), new DataHeap(16, new DataHeap(15), new DataHeap(13)));

        assertFalse(myHeap.isHeap());
    }

    @Test
    public void testIsHeapMT(){

        MtHeap myMTHeap = new MtHeap();

        assertTrue(myMTHeap.isHeap());
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testInstancesOfMT(){

        MtHeap myMTHeap = new MtHeap();

        assertEquals(myMTHeap.instancesOf(2), 0, 0);
    }

    @Test
    public void testInstancesOfSmall(){

        DataHeap myHeap2 = new DataHeap(1, new DataHeap(13), new DataHeap(13));

        assertEquals(myHeap2.instancesOf(13), 2, 0);
    }

    @Test
    public void testInstancesOfLarge(){

        DataHeap myHeap2 = new DataHeap(1, new DataHeap(2, new MtHeap(), new MtHeap()), new DataHeap(5, new DataHeap(13), new DataHeap(13)));

        assertEquals(myHeap2.instancesOf(13), 2, 0);
    }

    @Test
    public void testInstancesOfAllElt(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(1), new DataHeap(1));

        assertEquals(myHeap.instancesOf(1), 3, 0);
    }

    @Test
    public void testInstancesOfNoElt(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(1), new DataHeap(1));

        assertEquals(myHeap.instancesOf(2), 0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testSmallestEltSmall(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(2), new DataHeap(3));

        assertEquals(myHeap.smallestElt(), 1, 0);

    }

    @Test
    public void testSmallestEltLarge(){

        DataHeap myHeap2 = new DataHeap(1, new DataHeap(2, new MtHeap(), new MtHeap()), new DataHeap(5, new DataHeap(0), new DataHeap(13)));

        assertEquals(myHeap2.smallestElt(), 0, 0);

    }

    @Test
    public void testSmallestEltMT(){

        MtHeap myMTHeap = new MtHeap();

        assertEquals(myMTHeap.smallestElt(), -1, 0);

    }

    @Test
    public void testSmallestAllEqual(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(1), new DataHeap(1));

        assertEquals(myHeap.smallestElt(), 1, 0);

    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddEltTesterMTHeap(){

        MtHeap myMTHeap = new MtHeap();
        DataHeap myHeap = new DataHeap(5);


        assertTrue(HT.addEltTester(myMTHeap,5, myHeap));
        assertTrue(HT.addEltTester(myMTHeap,5, myMTHeap.addElt(5)));

    }

    @Test
    public void testAddEltTesterMTHeapTwice(){

        MtHeap myMTHeap = new MtHeap();
        DataHeap myHeap = new DataHeap(5, new MtHeap(), new MtHeap());
        DataHeap myHeap2 = new DataHeap(5, new DataHeap(6), new MtHeap());


        assertTrue(HT.addEltTester(myMTHeap,5, myHeap));
        assertTrue(HT.addEltTester(myHeap,6, myHeap2));

        assertTrue(HT.addEltTester(myMTHeap,5, myMTHeap.addElt(5)));
        assertTrue(HT.addEltTester(myHeap,6, myHeap.addElt(6)));


    }

    @Test
    public void testAddEltTesterMTWrongNum(){

        MtHeap myMTHeap = new MtHeap();
        DataHeap myHeap = new DataHeap(5, new MtHeap(), new MtHeap());

        assertFalse(HT.addEltTester(myMTHeap,7, myHeap));
        assertTrue(HT.addEltTester(myMTHeap,7, myMTHeap.addElt(7)));

    }

    @Test
    public void testAddEltTesterSmall(){

        DataHeap myHeap = new DataHeap(1, new MtHeap(), new MtHeap());
        DataHeap myHeap2 = new DataHeap(1, new DataHeap(13), new MtHeap());

        assertTrue(HT.addEltTester(myHeap,13, myHeap2));
        assertTrue(HT.addEltTester(myHeap,13, myHeap.addElt(13)));

    }

    @Test
    public void testAddEltTesterLarge(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(2, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));
        DataHeap myHeap2 = new DataHeap(1, new DataHeap(2, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new DataHeap(13)));

        assertTrue(HT.addEltTester(myHeap,13, myHeap2));
        assertTrue(HT.addEltTester(myHeap,13, myHeap.addElt(13)));

    }

    @Test
    public void testAddEltSameNumNoAdd(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(1), new DataHeap(1));
        DataHeap myHeap2 = new DataHeap(1, new DataHeap(1), new DataHeap(1));

        assertFalse(HT.addEltTester(myHeap,1, myHeap2));
        assertTrue(HT.addEltTester(myHeap,1, myHeap.addElt(1)));

    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testRemMinEltTesterMT(){

        MtHeap myMTHeap = new MtHeap();

        assertFalse(HT.remMinEltTester(myMTHeap, myMTHeap.remMinElt()));

    }

    @Test
    public void testRemMinEltTesterSmall(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(2), new DataHeap(3));
        DataHeap myHeap2 = new DataHeap(2, new DataHeap(3), new MtHeap());

        assertTrue(HT.remMinEltTester(myHeap, myHeap2));
        assertTrue(HT.remMinEltTester(myHeap, myHeap.remMinElt()));

    }

    @Test
    public void testRemMinEltTesterLarge(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(2, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new DataHeap(13)));
        DataHeap myHeap2 = new DataHeap(2, new MtHeap(), new DataHeap(5, new MtHeap(), new DataHeap(13)));

        assertTrue(HT.remMinEltTester(myHeap, myHeap2));
        assertTrue(HT.remMinEltTester(myHeap, myHeap.remMinElt()));

    }

    @Test
    public void testRemMinEltTesterAllEqual(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(1), new DataHeap(1));
        DataHeap myHeap2 = new DataHeap(1, new DataHeap(1), new MtHeap());

        assertTrue(HT.remMinEltTester(myHeap, myHeap2));
        assertTrue(HT.remMinEltTester(myHeap, myHeap.remMinElt()));

    }

    @Test
    public void testRemMinEltTesterNotEvenAHeap(){

        DataHeap myHeap = new DataHeap(6, new DataHeap(1), new DataHeap(1));
        DataHeap myHeap2 = new DataHeap(6, new DataHeap(1), new MtHeap());

        assertFalse(HT.remMinEltTester(myHeap, myHeap2));
        assertFalse(HT.remMinEltTester(myHeap, myHeap.remMinElt()));

    }

    @Test
    public void testRemMinEltTesterRemoveTwice(){

        DataHeap myHeap = new DataHeap(1, new DataHeap(1), new DataHeap(1));
        DataHeap myHeap2 = new DataHeap(1, new DataHeap(1), new MtHeap());
        DataHeap myHeap3 = new DataHeap(1, new MtHeap(), new MtHeap());

        assertTrue(HT.remMinEltTester(myHeap, myHeap2));
        assertTrue(HT.remMinEltTester(myHeap, myHeap.remMinElt()));

        assertTrue(HT.remMinEltTester(myHeap2, myHeap3));
        assertTrue(HT.remMinEltTester(myHeap2, myHeap2.remMinElt()));

    }

}
