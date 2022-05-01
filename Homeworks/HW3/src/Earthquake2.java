import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
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
    LinkedList<Double> filteredData = new LinkedList<Double>();
    LinkedList<MaxHzReport> maxHz = new LinkedList<MaxHzReport>();

    boolean correctMonth = false;

    for(double currData : data){
      if(isDate(currData) == true && extractMonth(currData) == month){
        correctMonth = true;
        filteredData.add(currData);
      }else if(isDate(currData) == false && correctMonth == true){
        filteredData.add(currData);
      }else{
        correctMonth = false;
      }
    }

    //Now that irrelevant data has been excluded...
    double currDate = 0.0;
    double currMaxFreq = 0.0;

    for(double currData : filteredData){
      if(isDate(currData) == true && currDate != currData){
        if(currDate != 0){
          maxHz.add(new MaxHzReport(currDate, currMaxFreq));
        }
        currDate = currData;
      }else if(isDate(currData) == false){
        if(currData > currMaxFreq){
          currMaxFreq = currData;
        }
      }
    }
    if(currDate != 0 && currMaxFreq >= 0.0){
      maxHz.add(new MaxHzReport(currDate, currMaxFreq));
    }

    return maxHz;
  }
}