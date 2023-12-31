package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("http://localhost:4200/register");
	}
	
	@Test
	public void registerUser() throws InterruptedException {
		
		//Personal Details
		driver.findElement(By.cssSelector("input[name='firstName'")).sendKeys("Surya");
		driver.findElement(By.cssSelector("input[name='lastName'")).sendKeys("Sharma");
		
		//Contact Details
		driver.findElement(By.cssSelector("input[name='email'")).sendKeys("test123@gmail.com");
		driver.findElement(By.cssSelector("input[name='phone'")).sendKeys("9699011654");
		
		
		//Kyc Details
		driver.findElement(By.cssSelector("input[name='dob'")).click();
		driver.findElement(By.cssSelector("input[name='dob'")).sendKeys("02/02/2000");
		driver.findElement(By.cssSelector("input[name='pancard'")).sendKeys("GJOH16765");
		
		
		//Address Details
		driver.findElement(By.cssSelector("input[name='addressLine1'")).sendKeys("C-1 Silver Oaks");
		driver.findElement(By.cssSelector("input[name='addressLine2'")).sendKeys("SV Road");
		driver.findElement(By.cssSelector("input[name='addressLine3'")).sendKeys("Borivali");
		driver.findElement(By.cssSelector("input[name='addressLine4'")).sendKeys("Mumbai, Maharashtra");
		driver.findElement(By.cssSelector("input[name='addressLine5'")).sendKeys("400067");
		driver.findElement(By.id("next")).click();
		assertEquals(driver.getCurrentUrl(), "http://localhost:4200/register/userRegistration");
		
		//User Registration
		driver.findElement(By.cssSelector("input[name='userName'")).sendKeys("Surya");
		driver.findElement(By.cssSelector("input[name='password'")).sendKeys("Abc@123456");
		driver.findElement(By.cssSelector("input[name='confirm_password'")).sendKeys("Abc@123456");
		driver.findElement(By.cssSelector("input[name='tnc'")).click();
		driver.findElement(By.cssSelector("button[id='signUpButton'")).click();
		Thread.sleep(2000L);
		assertEquals(driver.getCurrentUrl(), "http://localhost:4200/login");
		

	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}
