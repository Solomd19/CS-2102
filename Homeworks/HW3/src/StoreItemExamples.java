import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class StoreItemExamples {

    @Test
    public void testStore2() {
        StoreItem redGrapes = new StoreItem("red grapes", "produce", 0, 20210423);
        StoreItem greenGrapes = new StoreItem("green grapes", "produce", 20210423);

        assertEquals(redGrapes, greenGrapes);
    }

}
