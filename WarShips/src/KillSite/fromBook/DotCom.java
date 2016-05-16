/**
 * Created by dzyob on 13.05.2016.
 */
package KillSite.fromBook;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public DotCom() {
    }

    public void setLocationCells(ArrayList<String> loc) {
        this.locationCells = loc;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = this.locationCells.indexOf(userInput);
        if(index >= 0) {
            this.locationCells.remove(index);
            if(this.locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }

        return result;
    }

    public void setName(String string) {
        this.name = string;
    }
}