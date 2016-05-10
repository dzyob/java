import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class PsevdoSimpleDotComTestDrive {
    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        SimpleDotCom dot = new SimpleDotCom();
        Parametrs settings = new Parametrs();

        int count = 0;                                              // ���������� ������� � ������� ������� �������
        String result="����";                                       // ��������� ���������� "����"

        System.out.println("������� ���������. ����� ����: ");
        int weight = Integer.parseInt(r.readLine());
        settings.setWeight(weight);                                 // ����� �������� ����� ������

        System.out.println("������ �������: ");
        int size = Integer.parseInt(r.readLine());
        settings.setSizeShip(size);                                 // ����� �������� ����� �������

        int random = (int) (Math.random() * ((settings.getWeight()-settings.getSizeShip())+1));

        String[] locations = new String[settings.getWeight()];      // ������� ������
        for (int i = 0; i < locations.length; i++) {                // ��������� �������� � ����������� �����
            if(i == random) {
                for (int j = 0; j < settings.getSizeShip(); j++) {
                    locations[i+j] = String.valueOf(random+j);
                }
            }
        }

        String[] locationsDuplicate = new String[locations.length]; // ������ �������� �������
        for (int i = 0; i < locations.length; i++) {                // �������������� ��������
            locationsDuplicate[i]=locations[i];
        }

        dot.setLocationCells(locations);                            // ����������� ������ ��� ���������

        while(!result.equals("�������")) {
            System.out.println("����� �����: ");
            String n = r.readLine();
            result = dot.checkYourself(n, settings.getSizeShip());
            count++;
            System.out.println("");
        }
        System.out.println("======================================");
        System.out.println("��� ������������ "+count+" �������(�)");
        System.out.println("");
        System.out.println("��� ��� ��� ��� �������� �������: ");
        System.out.println("");
        for (String g : locationsDuplicate) {
            System.out.println("# "+g);
        }
        System.out.println("======================================");
    }

}
class SimpleDotCom {
    String[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(String[] locs){
        locationCells = locs;
    }
    public String checkYourself(String n, int z) {
        String guess = n;
        String result = "����";
        for (int i = 0; i < locationCells.length; i++) {
            if (guess.equals(locationCells[i])) {
                result = "�����";
                numOfHits++;
                locationCells[i] = null;
                break;
            }
        }
        if (numOfHits == z){
            result = "�������";
        }
        System.out.println(result);
        System.out.println("������� ������ �������: "+numOfHits);
        return result;
    }
}
class Parametrs {
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
