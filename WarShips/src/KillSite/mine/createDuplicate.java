package KillSite.mine;

/**
 * Created by dzyob on 16.05.2016.
 */
public class createDuplicate {
    String[] locationCells;
    String[] locationCellsDuplicate;
    public void setOrigin(String[] locs){
        locationCells = locs;
    }
    public String[] makeDuplicate() {
        locationCellsDuplicate = new String[locationCells.length];
        for (int i = 0; i < locationCells.length; i++) {
            locationCellsDuplicate[i] = locationCells[i];
        }
        return locationCellsDuplicate;
    }
}
