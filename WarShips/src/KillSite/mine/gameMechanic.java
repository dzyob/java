package KillSite.mine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dzyob on 16.05.2016.
 */
public class gameMechanic {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    String[] locationCells;
    String[] locationCellsDuplicate;
    int numOfHits = 0;
    int count=1;

    public void setLocationCells(String[] locs){ locationCells = locs; }
    public void setLocationCellsDuplicate(String[] locs){ locationCellsDuplicate = locs; }
    public String checkYourself(String n, int z) {
        String guess = n;
        String result = "Мимо";
        for (int i = 0; i < locationCells.length; i++) {
            if (guess.equals(locationCells[i])) {
                result = "Попал";
                numOfHits++;
                locationCells[i] = null;
                break;
            }
        }
        if (numOfHits == z){
            result = "Потопил";
        }
        System.out.println(result);
        System.out.println("Подбито частей корабля: "+numOfHits);
        return result;
    }
    public void makeGame(int z, String[] list) throws IOException {

        String hit="Мимо";
        while(!hit.equals("Потопил")) {
            System.out.println("Выстрел №"+count +". Куда стрелять: ");
            String n = r.readLine();
            hit = this.checkYourself(n, z);
            count++;
            System.out.println("");
        }
        System.out.println("======================================");
        System.out.println("Вам понадобился(ось) "+(count-1)+" выстрел(a, ов)");
        System.out.println("");
        System.out.println("Вот так вот был размещён корабль: ");
        System.out.println("");
        for (String g : list) {
            System.out.println("# "+g);
        }
        System.out.println("======================================");
    }
}