import java.util.LinkedList;

public class Planning {

    LinkedList<Double> rainList = new LinkedList<Double>();

//    public Planning(){
//
//    }

    public double rainfall(){
        double totalRain = 0.0;
        double count = 0.0;
        for (double currRain : rainList) {
            if(currRain == -999){
                break;
            }else if(currRain >= 0.0){
                totalRain += currRain;
                count += 1.0;
            }
        }
        if(count == 0.0){
            return -1;
        }else{
            return totalRain/count;
        }
    }
}
