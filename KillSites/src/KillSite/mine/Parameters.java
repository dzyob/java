package KillSite.mine;

/**
 * Created by dzyob on 16.05.2016.
 */
public class Parameters {
    private int weight = 7;
    private int sizeShip = 3;

    public void setWeight(int weightArg){
        if(weightArg < 7){
            weight = 7;
        } else if (weightArg > 21) {
            weight = 21;
        } else {
            weight = weightArg;
        }
    }

    public int getWeight(){
        return weight;
    }

    public void setSizeShip(int sizeShipArg){
        if(sizeShipArg < 1){
            sizeShip = 1;
        } else if (sizeShipArg > 5) {
            sizeShip = 5;
        } else {
            sizeShip = sizeShipArg;
        }
    }

    public int getSizeShip(){
        return sizeShip;
    }

}