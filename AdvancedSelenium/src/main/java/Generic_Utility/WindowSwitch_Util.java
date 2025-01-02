package Generic_Utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowSwitch_Util {
	
	public void switchWindow(WebDriver driver, String prtTitle) {
		Set<String> allWin= driver.getWindowHandles();
		
		Iterator<String> it = allWin.iterator();
		
		while(it.hasNext()) {
			String Window = it.next();
			driver.switchTo().window(Window);
			String title = driver.getTitle();
			if(title.contains(prtTitle)) {
				break;
			}
		}
	}

}
