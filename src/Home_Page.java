import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Home_Page {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MY LAPTOP\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		String userName = "standard_user";
		String password = "secret_sauce";
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(2000);
//********************************  return the title of the website  ***************************************************		
//		String actualTitle = driver.getTitle();// al eshe al f3le al mawjod
//		String expectedTitle = "Hi Ya 7lween";// al eshe al metwag3oh
//		
//		if(actualTitle == expectedTitle) {
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
//		
//		Assert.assertEquals(actualTitle, expectedTitle);
		
		
//************************  add 6 items to the cart and compare between actual & expected  *************************

		int expectedItems = 6;

		List<WebElement> myButton = driver.findElements(By.className("btn"));
		for (int i = 0; i < myButton.size(); i++) {
			myButton.get(i).click();
		}

		String actualItemsAdded = driver.findElement(By.className("shopping_cart_badge")).getText();

		int theRealNumber = Integer.parseInt(actualItemsAdded);

		Assert.assertEquals(theRealNumber, expectedItems);

	

	}

}
