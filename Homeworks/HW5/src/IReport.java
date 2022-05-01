import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Interface type for weather reports
 */
public interface IReport {
    GregorianCalendar getDate();
    double avgTemp();
    double totalRainfall();
}
