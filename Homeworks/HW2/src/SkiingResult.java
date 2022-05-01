import java.util.LinkedList;

public class SkiingResult extends SkiEvent{
    LinkedList<Double> laps = new LinkedList<Double>();

    //Constructor
    public SkiingResult(int place, double lap1, double lap2, double lap3, double lap4, int penalties){
        super(place, penalties);
        //this.place = place;
        laps.add(lap1);
        laps.add(lap2);
        laps.add(lap3);
        laps.add(lap4);
        //this.penalties = penalties;
    }

    public SkiingResult(int place, int penalties){
        super(place, penalties);
    }

    /**
     * Totals points earned across all laps in list laps
     *
     * @return A double representing the points earned across all ski lap times.
     */

    public double pointsEarned(){

        double totalTime = 0;
        for (Double time : laps) {
            totalTime += time;
        }
        return totalTime;
    }

}
