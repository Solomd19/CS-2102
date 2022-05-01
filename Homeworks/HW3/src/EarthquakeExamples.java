import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void instructorTestExcludeNeg() {

    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

    threeDates.add(20151013.0);
    threeDates.add(-10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(-50.0);
    threeDates.add(-45.0);
    threeDates.add(20151101.0);
    threeDates.add(-6.0);

    NovReports.add(new MaxHzReport(20151013.0,5.0));
    NovReports.add(new MaxHzReport(20151020.0,40.0));

    assertEquals(NovReports,
            E1.dailyMaxForMonth(threeDates, 10));
  }

  @Test
  public void instructorTestExcludeMonth() {

    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(20151001.0);
    threeDates.add(6.0);

    assertEquals(NovReports,
            E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void instructorTestNoDates() {

    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

    //threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    //threeDates.add(20151020.0);
    threeDates.add(40.0);
    //threeDates.add(20151001.0);
    threeDates.add(6.0);

    assertEquals(NovReports,
            E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void instructorTestNoFreqData() {

    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

    threeDates.add(20151013.0);
    //threeDates.add(-10.0);
    //threeDates.add(-5.0);
    threeDates.add(20151020.0);
    //threeDates.add(-40.0);
    threeDates.add(20151001.0);
    //threeDates.add(-6.0);

    assertEquals(NovReports,
            E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void instructorTestOnlyZero() {

    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

    threeDates.add(20151013.0);
    threeDates.add(0.0);
    threeDates.add(0.0);
    threeDates.add(20151020.0);
    threeDates.add(0.0);
    threeDates.add(20151001.0);
    threeDates.add(0.0);

    NovReports.add(new MaxHzReport(20151013.0, 0.0));
    NovReports.add(new MaxHzReport(20151020.0, 0.0));
    NovReports.add(new MaxHzReport(20151001.0, 0.0));


    assertEquals(NovReports,
            E1.dailyMaxForMonth(threeDates, 10));
  }

}

/*
Subtasks:
Iterate through double list
Interpret doubles into frequency data
Exclude data not from parameter month
Exclude negative frequency data
Find highest frequency per day (that has data)
Add relevant data to list
 */