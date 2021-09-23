package utilitis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpertotackescreenshoots {

// bat help el framework fy el7agat aw btb2a zy shared libararies men el7agat ely mawgoda fy el frame work 

	// create method to take screenshoots when test case failed
	// 5alaha static 3ashan a2dr ast5dmha 3la tol mn 4er ma25od mnha object mn el
	// class
	// hab3t ll method bata3ty el web driver w el variable bata3y ely hay5od
	// screenshoots dlw2ty w ana brun
	// el test case bata3ty w haysmeha
	


	public static void capturescreenshoots(WebDriver driver, String screenshotname)  {

		// hena 3aeza adelo el path ely hay7ot feha el screen shoots
		// path de liprary fy el java
		// paths function bata5od argue URL
		// You create a Path instance using a static method in the Paths class
		// (java.nio.file.Paths)
		// named Paths.get(). Here is a Java Paths.get()
		
		//TODO needed timestamp with the  file
	
		Path dest = Paths.get("./screenshots", screenshotname +timestamp()+".png");
		
		// used Try and catch to handel IO exception when createing a file
		
		
		
		try {
			Files.createDirectories(dest.getParent());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try (FileOutputStream out = new FileOutputStream(dest.toString());) {
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		} catch (Exception e) {
			System.out.println("Exception will taken screenshoot"+e.getMessage());
		}
		




		/*
		 * try { // using to create directory in the folder
		 * 
		 * // fileoutputstream java calss ha5od mno object FileOutputStream out = new
		 * FileOutputStream(dest.toString()); out.write(((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.BYTES)); out.close();
		 * 
		 * } catch (IOException e) {
		 * 
		 * System.out.println("Exception will taken screenshoot"+e.getMessage()); }
		 */

	}

     private static String timestamp() {
	// TODO Auto-generated method stub
	 return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}

}
