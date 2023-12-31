package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RequestChequeBookTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {


		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
	}
	
	@Test
	public  void requestChequeBook() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("namrata@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Namratak@#15");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("chequebookRequestLink")).click();
		driver.findElement(By.id("chequebookRequestPrimary")).click();
		driver.findElement(By.id("primary")).click();
		driver.findElement(By.id("chequetype")).click();
		driver.findElement(By.id("individual")).click();
		
		driver.findElement(By.id("description")).sendKeys("Apply for cheque book");;

		driver.findElement(By.className("text-center")).click();

		Thread.sleep(1000L);
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		alert.accept();
		assertEquals(msg, "Chequebook request submiited");

	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}
