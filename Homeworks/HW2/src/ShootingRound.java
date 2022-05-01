public class ShootingRound {
    int targets;
    boolean standing; //Prone if false

    //Constructor
    public ShootingRound(int targets, boolean standing){
        this.targets = targets;
        this.standing = standing;
    }

    public ShootingRound(int targets){
        this.targets = targets;
    }
}
