import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Represents a weather report for a given day and all it's data
 */
public class TodaysWeatherReport implements IReport {
    private GregorianCalendar date;
    private LinkedList<Reading> readings;

    public TodaysWeatherReport(GregorianCalendar date, LinkedList<Reading> readings) {
        this.date = date;
        this.readings = readings;
    }

    /**
     * Returns date of report
     *
     * @return date of report
     */
    public GregorianCalendar getDate() {
        return this.date;
    }

    /**
     * Calculates the average temperature across all recorded readings
     * @return Average temperature value
     */
    public double avgTemp() {
        int dataQuantity = 0;
        double tempTotal = 0.0;

        for (Reading currReading : readings) {
            tempTotal += currReading.getTemperature();
            dataQuantity++;
        }

        if (dataQuantity != 0) {
            return tempTotal / (double) dataQuantity;
        } else {
            return 0.0;
        }
    }

    /**
     * Calculates the total rainfall across all readings
     * @return total rainfall at report time
     */
    public double totalRainfall() {
        double rainTotal = 0.0;

        for (Reading currReading : readings) {
            rainTotal += currReading.getRainfall();
        }

        return rainTotal;
    }


}
