import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Interface type for weather report managers
 */
public interface IWeatherManager {
    double averageMonthTemp(int month, int year);
    double totalMonthRainfall(int month, int year);
    void addTodaysReport(GregorianCalendar date, LinkedList<Reading> readings);
}
