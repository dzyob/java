public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		SimpleDotCom dot = new SimpleDotCom();
		int[] locations = {2,3,4};

		dot.setLocationCells(locations);

		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		/*String testResult = "�������";

		if(result.equals("�����")) {
			testResult = "�������";
		}
		System.out.println("testResult");*/
	}
	
}
class SimpleDotCom {
	int[] locationCells;
	int numOfHits = 0;

	public void setLocationCells(int[] locs){
		locationCells = locs;
	}
	public String checkYourself(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);
		String result = "����";
		for (int cell : locationCells) {
			if (guess == cell) {
				result = "�����";
				numOfHits++;
				break;
			}
		}
		if (numOfHits == locationCells.length){
			result = "�������";
		}
		System.out.println(result);
		return result;
	}
}
