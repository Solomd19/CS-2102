/**
 * Represents a given reading and all relevant data
 */
public class Reading{
    private Time readTime;
    private double temperature;
    private double rainfall;

    public Reading(Time readTime, double temperature, double rainfall){
        this.readTime = readTime;
        this.temperature = temperature;
        this.rainfall = rainfall;
    }

    /**
     * Returns temperature reading
     * @return temperature reading
     */
    public double getTemperature(){
        return this.temperature;
    }

    /**
     * Returns rainfall level reading
     * @return rainfall level reading
     */
    public double getRainfall(){
        return this.rainfall;
    }

}
