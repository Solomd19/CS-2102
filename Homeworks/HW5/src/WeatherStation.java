import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Manages and stores all weather reports, and can calculate statistics of the stored reports
 */
public class WeatherStation implements IWeatherManager {

    private LinkedList<IReport> weatherReports;

    public WeatherStation(LinkedList<IReport> weatherReports) {
        this.weatherReports = weatherReports;
    }

    public WeatherStation() {
        this.weatherReports = new LinkedList<IReport>();
    }

    /**
     * Takes a month (designated by a number such as 0 for January, 1 for February, etc) and a year
     * and produces the average temperature over all days that month.
     *
     * @param month month of data sought
     * @param year  year of data sought
     * @return average of all montly temps for the month and year combination given
     */
    public double averageMonthTemp(int month, int year) {

        if (month < 0 || month > 11) {
            return -1.0;
        }

        int dataQuantity = 0;
        double tempTotal = 0.0;

        for (IReport currDate : weatherReports) {
            if (currDate.getDate().get(GregorianCalendar.MONTH) == month && currDate.getDate().get(GregorianCalendar.YEAR) == year) {
                tempTotal += currDate.avgTemp();
                dataQuantity++;
            }
        }

        if (dataQuantity != 0) {
            return tempTotal / (double) dataQuantity;
        } else {
            return 0.0;
        }

    }

    /**
     * takes a month (designated by a number such as 0 for January, 1 for February, etc)
     * and a year and produces the total rainfall over all days that month
     *
     * @param month month of data sought
     * @param year  year of data sought
     * @return total rainfall for the month and year combination given
     */
    public double totalMonthRainfall(int month, int year) {

        if (month < 0 || month > 11) {
            return -1.0;
        }

        double rainTotal = 0.0;

        for (IReport currDate : weatherReports) {
            if (currDate.getDate().get(GregorianCalendar.MONTH) == month && currDate.getDate().get(GregorianCalendar.YEAR) == year) {
                rainTotal += currDate.totalRainfall();
            }
        }

        return rainTotal;
    }

    /**
     * Adds a new report to the WeatherStation's list
     *
     * @param date     date of the new report
     * @param readings list of readings for the day given to add
     */
    public void addTodaysReport(GregorianCalendar date, LinkedList<Reading> readings) {

        weatherReports.add(new TodaysWeatherReport(date, readings));
    }

}
