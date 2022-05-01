import java.util.LinkedList;

/**
* Represents an athlete's results for the  Mass Start
* skiing event containing their starting position and
* a list of lap times
* @author dmsolomon
*
*/

public class MassStartResult extends SkiEvent{
    int startingPos;
    LinkedList<Double> laps = new LinkedList<Double>();


    public MassStartResult(int startingPos, int place, int penalties){
        super(place, penalties);
        this.startingPos = startingPos;
    }

    public MassStartResult(int startingPos, int place, double lap1, double lap2, double lap3, double lap4, int penalties){
        super(place, penalties);
        this.startingPos = startingPos;
    }

    public double pointsEarned(){

        double totalTime = 0;
        for (Double time : laps) {
            totalTime += time;
        }
        return totalTime;
    }

}
