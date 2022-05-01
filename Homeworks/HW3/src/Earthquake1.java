import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }


  /**
   * Takes a LinkedList of doubles representing earthquake vibration
   * frequency data and dates recorded, and returns a list of daily'
   * maximums
   *
   * @param data Date and frequency doubles to interpret into earthquake data
   * @param month Month to search for daily max frequencies
   * @return list of daily max frequencies for given month
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxHzReport> monthMaxReport = new LinkedList<MaxHzReport>();

    double currDate = 0.0;
    double currMaxFreq = 0.0;

    for(double currData : data){
      if(isDate(currData)){
        if(currDate != 0 && currDate != currData && extractMonth(currDate) == month){ //If a date is being read and is new...
          monthMaxReport.add(new MaxHzReport(currDate, currMaxFreq));
          currMaxFreq = 0.0;
        }
        currDate = currData;
      }else if(currData > currMaxFreq && currData >= 0 && extractMonth(currDate) == month){ //If a frequency is being read and its date month matches the parameter...
        currMaxFreq = currData;
      }
    }
    if(currDate != 0 && month == extractMonth(currDate) && currMaxFreq >= 0.0){
      monthMaxReport.add(new MaxHzReport(currDate, currMaxFreq));
    }
    return monthMaxReport;
  }
}  

