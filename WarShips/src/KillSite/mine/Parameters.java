package KillSite.mine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by dzyob on 16.05.2016.
 */
public class Parameters {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    private int weight;
    private int sizeShip;
    String[] locations;

    public void setWeight() throws IOException{
        System.out.println("Уровень сложности. Длина строки(между 7-21): ");
        int weightArg = Integer.parseInt(r.readLine());
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

    public void setSizeShip() throws IOException{
        System.out.println("Размер корабля(между 1-5): ");
        int sizeShipArg = Integer.parseInt(r.readLine());
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

    public String[] makeList (){
        int random = (int) (Math.random() * ((this.getWeight()-this.getSizeShip())+1));
        locations = new String[this.getWeight()];
        for (int i = 0; i < locations.length; i++) {
            if(i == random) {
                for (int j = 0; j < this.getSizeShip(); j++) {
                    locations[i+j] = String.valueOf(random+j);
                }
            }
        }
        return locations;
    }

}