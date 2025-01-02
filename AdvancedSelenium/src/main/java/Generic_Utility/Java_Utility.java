package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * This method is used to avoid duplicates
	 * @author Pavan
	 * @return
	 */
	public int getRandomNum() {
		Random ran1 = new Random();
		int ranNum = ran1.nextInt(1000);
		return ranNum;
	}

}
