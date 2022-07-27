package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utility;

public class TestBase {
	public static  WebDriver driver ;
	public String projectPath = System.getProperty("user.dir");

	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
		if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
			//set property and create instance of chrome browser
			//System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//System.out.println(browserName + " browser running");
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
			//set property and create instance of chrome firefox
			//System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//	System.out.println(browserName + " browser running");
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
			//set property and create instance of chrome edge
			//System.setProperty("webdriver.edge.driver", projectPath+"\\Drivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			//	System.out.println(browserName + " browser running");
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {
			//set property and create instance of chrome ie
			System.setProperty("webdriver.ie.driver", projectPath+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(Utility.fetchProperty("applicationUrl").toString());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();

	}

}
