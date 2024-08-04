package dummy;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args)
	{
		
				driver= new ChromeDriver();
				driver.get("https://www.dazn.com/en-JP/signin");
				driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
	driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	
	driver.findElement(By.id("email")).sendKeys("saipavan.uppalapati@dazn.com");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	
	driver.findElement(By.id("password")).sendKeys("DAZN20233");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id='signIn__BUTTON']")));
	
	driver.findElement(By.xpath("//button[@data-test-id='signIn__BUTTON']")).click();	
	handleOfferPopup(driver, wait);
	driver.navigate().back();
	//driver.findElement(By.xpath("(//li[@id='ACTIVE_MENU_ITEM'])[1]")).click();
	//driver.findElement(By.xpath("(//h4[normalize-space()='Rainbow Six - Day 1'])[1]")).click();
	 WebElement element = scrollToElement(driver, wait, By.xpath("(//h4[normalize-space()='Apex Legends - Day 2'])[1]"));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_15485uv0 gvif6y3'])[1]")));
		
	 
	 
	driver.quit();

	}
	 private static void handleOfferPopup(WebDriver driver, WebDriverWait wait) {
	        try {
	            // Wait for the pop-up to appear
	            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='OfferPopup__content___3FXDU OfferPopup__content-new-layout___1glrq'])[1]"))); // Update with actual ID or locator
	            if (popup.isDisplayed()) {
	                // Close the pop-up
	                WebElement startWatching = popup.findElement(By.xpath("(//button[@class='sc-pyfCe sc-kDvujY gTYMya ihnwix OfferPopup__cta___39Cvo OfferPopup__cta-new-layout___1LvRF'])[1]")); // Update with actual close button selector
	                startWatching.click();
	            }
	        } catch (Exception e) {
	            System.out.println("Pop-up not found or could not be closed: " + e.getMessage());
	        }
	    }
	 private static WebElement scrollToElement(WebDriver driver, WebDriverWait wait, By locator) {
	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        return element;
	    }
	 
	   
	

	
	
}	

	
        
    

