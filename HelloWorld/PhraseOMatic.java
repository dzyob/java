import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class PhraseOMatic{
    public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("����� ��� ���: ");
		String name = r.readLine();
		System.out.println("");
        String[] wordListOne = {"��������������", "����-��������", "��������", "����������", "�������������", "�����������", "�����", "������", "����������"};
        String[] wordListTwo = {"������", "�������������", "����������", "��������������", "������������"};
        String[] wordListThree = {"����", "�������", "����", "�����", "����", "�����"};
        int one = wordListOne.length;
        int two = wordListTwo.length;
        int three = wordListThree.length;

        int rand1 = (int) (Math.random() * one);
        int rand2 = (int) (Math.random() * two);
        int rand3 = (int) (Math.random() * three);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        System.out.println(name +", �� ��� ��� �����, - ��� " + phrase);
    }
}