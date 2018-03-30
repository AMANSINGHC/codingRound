package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class BaseTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		setDriverPath();
		
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        driver.get("https://www.cleartrip.com/");
	}

	private void setDriverPath() 
	{
        if (PlatformUtil.isMac())
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//libs//chromedriver");
        else if (PlatformUtil.isWindows()) 
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//libs//chromedriver.exe");
        else if (PlatformUtil.isLinux()) 
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//libs//chromedriver_linux");
	}
}
