import static org.junit.Assert.*;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Examples {

    WeatherStation newsChannel13 = new WeatherStation();

    GregorianCalendar date1 = new GregorianCalendar(2016, 11, 17); //Different month than rest
    LinkedList<Reading> readings1 = new LinkedList<Reading>();

    GregorianCalendar date2 = new GregorianCalendar(2016, 10, 15);
    LinkedList<Reading> readings2 = new LinkedList<Reading>();

    GregorianCalendar date3 = new GregorianCalendar(2016, 10, 12);
    LinkedList<Reading> readings3 = new LinkedList<Reading>();

    GregorianCalendar date4 = new GregorianCalendar(2018, 10, 12); //Different year than rest
    LinkedList<Reading> readings4 = new LinkedList<Reading>();

    public Examples(){

        readings1.add(new Reading(new Time(4, 45), 50, 6.8));
        readings1.add(new Reading(new Time(6, 19), 30, 2.1));
        readings1.add(new Reading(new Time(12, 28), 40, 7.0));

        readings2.add(new Reading(new Time(18, 26), 45, 2.2));

        readings3.add(new Reading(new Time(14, 13), 55, 3.8));

        readings4.add(new Reading(new Time(14, 13), 55, 3.8));

        newsChannel13.addTodaysReport(date1, readings1);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAvgTempSingleEntry(){
        assertEquals(newsChannel13.averageMonthTemp(11, 2016), 40, 0);
    }

    @Test
    public void testAvgTempMultEntries(){
        newsChannel13.addTodaysReport(date2, readings2);
        newsChannel13.addTodaysReport(date3, readings3);
        assertEquals(newsChannel13.averageMonthTemp(10, 2016), 50, 0);
    }

    @Test
    public void testAvgTempNoDataMonth(){
        assertEquals(newsChannel13.averageMonthTemp(10, 2016), 0, 0);
    }

    @Test
    public void testAvgTempInvalidMonth(){
        assertEquals(newsChannel13.averageMonthTemp(12, 2016), -1, 0);
    }

    @Test
    public void testAvgTempInvalidYear(){
        assertEquals(newsChannel13.averageMonthTemp(12, 2017), -1, 0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testTotalRainfallSingleEntry(){
        assertEquals(newsChannel13.totalMonthRainfall(11, 2016), 15.9, 0);
    }

    @Test
    public void testTotalRainfallMultEntries(){
        newsChannel13.addTodaysReport(date2, readings2);
        newsChannel13.addTodaysReport(date3, readings3);
        assertEquals(newsChannel13.totalMonthRainfall(10, 2016), 6.0, 0);
    }

    @Test
    public void testTotalRainfallNoDataMonth(){
        assertEquals(newsChannel13.totalMonthRainfall(10, 2016), 0, 0);
    }

    @Test
    public void testTotalRainfallInvalidMonth(){
        assertEquals(newsChannel13.totalMonthRainfall(12, 2016), -1, 0);
    }

    @Test
    public void testTotalRainfallInvalidYear(){
        assertEquals(newsChannel13.totalMonthRainfall(12, 2017), -1, 0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}

