import java.util.LinkedList;

class Event {
    private String type;              // wedding, etc.
    private Date date;
    private boolean isEvening;   // true if the event is to be held in the evening

    public Event(String type, Date date, boolean isEvening) {
        this.type = type;
        this.date = date;
        this.isEvening = isEvening;
    }

    // returns true if a conflict
    boolean hasConflict(Event e2) {
        return this.date.dateSame(e2.date) && this.isEvening == e2.isEvening;
    }
}

class Date {
    private String month;
    private int day;
    private int year;

    public Date(String month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // returns true if both dates are the same
    boolean dateSame(Date d2) {
        return this.month.equals(d2.month) && this.day == d2.day && this.year == d2.year;
    }
}

class Reservations {
    private LinkedList<Event> events;

    public Reservations() {
        this.events = new LinkedList<Event>();
    }

    // adds the given event to the events list, as long as there is no
    // date/time conflict with existing events in the list.
    // returns true if the event was added, false otherwise
    boolean bookEvent(Event newEvent) {
        if (events.size() == 0) {     // no other events, so no conflicts
            events.add(newEvent);
            return true;
        } else {
            for (Event e : this.events) {
                if (e.hasConflict(newEvent))
                    return false;     // conflict found, event not added
            }
            events.add(newEvent);     // no conflicts, so add event
            return true;
        }
    }


}
