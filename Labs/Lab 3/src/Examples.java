import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    @Test
    public void rainfallTestNormal(){
        Planning test1 = new Planning();
        test1.rainList.add(1.0);
        test1.rainList.add(-2.0);
        test1.rainList.add(5.0);
        test1.rainList.add(-999.0);
        test1.rainList.add(8.0);

        assertEquals(test1.rainfall(), 3.0, 0);
    }

    @Test
    public void rainfallTestNegOnly(){
        Planning test1 = new Planning();
        test1.rainList.add(-1.0);
        test1.rainList.add(-2.0);
        test1.rainList.add(-5.0);
        test1.rainList.add(-999.0);
        test1.rainList.add(-8.0);

        assertEquals(test1.rainfall(), -1, 0);
    }

    @Test
    public void rainfallTestNoList(){
        Planning test1 = new Planning();

        assertEquals(test1.rainfall(), -1, 0);
    }

    @Test
    public void rainfallTestNoItems(){
        Planning test1 = new Planning();
        test1.rainList.add(-999.0);

        assertEquals(test1.rainfall(), -1, 0);
    }

}
