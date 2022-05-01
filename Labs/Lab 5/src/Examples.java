import java.util.LinkedList;
import static org.junit.Assert.*;
import org.junit.Test;


public class Examples {

    // an EventGuests that uses LinkedLists under the hood

    EventGuests guestsLists = new EventGuests(new LLGuests().addElt("Danny"));

    // an EventGuests that uses BSTs under the hood

    EventGuests guestsBSTs = new EventGuests(new DataBST("Danny", new EmptyBST(), new EmptyBST()));

    // an EventGuests that uses AVL trees under the hood

    EventGuests guestsAVLs = new EventGuests(new AVLGuest("Danny", new EmptyBST(), new EmptyBST()));

    @Test
    public void isDannyThere(){
        assertTrue(guestsLists.isComing("Danny"));
        assertTrue(guestsBSTs.isComing("Danny"));
        assertTrue(guestsAVLs.isComing("Danny"));
    }

    @Test
    public void isMondoThere(){
        assertFalse(guestsLists.isComing("Mondo"));
        assertFalse(guestsBSTs.isComing("Mondo"));
        assertFalse(guestsAVLs.isComing("Mondo"));
    }

    @Test
    public void testNum(){
        assertEquals(guestsLists.numGuests(), 1, 0);
        assertEquals(guestsBSTs.numGuests(), 1, 0);
        assertEquals(guestsAVLs.numGuests(), 1, 0);
    }


}
