package KillSite.mine;

/**
 * Created by dzyob on 16.05.2016.
 */
public class gameMechanic {
    String[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(String[] locs){
        locationCells = locs;
    }
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
}