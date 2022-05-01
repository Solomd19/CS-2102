/**
 * Represents the shared functionality between all ski events
 *
 * @author dmsolomon
 */

public abstract class SkiEvent implements IEvent{

    int place;
    int penalties;

    //Constructor
    public SkiEvent(int place, int penalties){
        this.place = place;
        this.penalties = penalties;
    }

    /**
     * Calculates total penalty points earned for a ski event
     * based on penalties earned
     *
     * @return double representing penalty points
     * to subtract from score for final event result
     */
    public double getPenalties(){
        return penalties * 5;
    }
}
