import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class PhraseOMatic{
    public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("¬веди своЄ им€: ");
		String name = r.readLine();
		System.out.println("");
        String[] wordListOne = {"круглосуточный", "трех-звездный", "взаимный", "интересный", "расслабл€ющий", "проникающий", "умный", "нежный", "динамичный"};
        String[] wordListTwo = {"долгий", "нестандартный", "абалденный", "всохитительный", "незабываемый"};
        String[] wordListThree = {"ужин", "завтрак", "обед", "отдых", "секс", "тусич"};
        int one = wordListOne.length;
        int two = wordListTwo.length;
        int three = wordListThree.length;

        int rand1 = (int) (Math.random() * one);
        int rand2 = (int) (Math.random() * two);
        int rand3 = (int) (Math.random() * three);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        System.out.println(name +", всЄ что вам нужно, - это " + phrase);
    }
}