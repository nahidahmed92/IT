package Sites.PageObjectModelFramework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class Base {
	public WebDriver driver;

	  @Parameters ({"browser", "url"})
	    @BeforeClass
		public void browser(String browser, String url) {
			if (browser.equalsIgnoreCase("Chrome")) {
				String userdirectory = System.getProperty("user.dir");
				System.out.println(userdirectory);
				System.setProperty("webdriver.chrome.driver", userdirectory + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.navigate().to(url);
				driver.manage().window().maximize(); 
			}
			else if (browser.equalsIgnoreCase("Firefox")) {
				String userdirectory = System.getProperty("user.dir");
				System.setProperty("webdriver.gecko.driver", userdirectory + "\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.navigate().to(url);
				driver.manage().window().maximize();
			} else {
				System.out.println("Wrong browser name");
			}
	  }

  @AfterClass
  public void afterClass() throws IOException, InterruptedException {
	  screenshot();
	  Thread.sleep(4000);
	  driver.quit();
  }
  
  public void screenshot () throws IOException {
		String userdirectory = System.getProperty("user.dir");
		Date dt = new Date();
//		System.out.println(dt.toString().replace(" ", "_").replace(":", "_"));
		String ut = dt.toString().replace(" ", "_").replace(":", "_") + ".jpg";
		System.out.println(dt);
		File captureOfShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(captureOfShots, new File(userdirectory + "\\Screenshots\\" + ut));
	}
}