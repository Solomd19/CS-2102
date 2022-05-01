import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    Album album1 = new Album("Michael Jackson", "Pop");
    Album album2 = new Album("Rock", "Drew Solomon");

    Song HapBD = new Song("Happy Birthday", 18, album2);
    Song mySong1 = new Song("Beat It", 14, album1);
    Song mySong2 = new Song("Macarena", 31, album2);

    public Examples(){}

    @Test
    public void checkHBLen() {
        assertEquals(18, HapBD.lenInSeconds);
    }

    @Test
    public void checkMySong1Len() {
        assertEquals(18, mySong1.lenInSeconds);
    }

    @Test
    public void checkMySong1Album() {
        assertEquals(album1, mySong1.onAlbum);
    }

    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */

}