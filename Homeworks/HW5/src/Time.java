/**
 * Represents a point of time in a 24 hour span
 */
public class Time {
    private int hour = 0;
    private int minute = 0;

    public Time(int hour, int minute){
        if(hour >= 0 && hour < 24){
            this.hour = hour;
        }else{
            this.hour = 0;
        }
        if(minute >= 0 && minute < 60){
            this.minute = minute;
        }else{
            this.minute = 0;
        }

    }

    public Time(int hour){
        if(hour >= 0 && hour < 24){
            this.hour = hour;
        }else{
            this.hour = 0;
        }
        this.minute = 0;
    }

}
