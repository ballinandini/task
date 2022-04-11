package stepDefinations;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



@RunWith(Cucumber.class)
public class test1 {
public static WebDriver driver;
@Given("^I am on the Google search page$")
public void i_am_on_the_google_search_page() throws Throwable {

// WebDriver driver=new ChromeDriver();
System.setProperty("webdriver.chrome.driver","C:\\Users\\nandini.balli\\Downloads\\chromedriver.exe");
driver=new ChromeDriver();
driver.get("https://www.google.com");
driver.get("https://www.github.com");
}
public static WebElement p;
@When("^I search for \"([^\"]*)\"$")
public void i_search_for_something(String strArg1) throws Throwable {
p=driver.findElement(By.name("q"));
p.sendKeys("react");
p.submit();
driver.findElement(By.linkText("Advanced search")).click();
WebElement Lan=driver.findElement(By.id("search_language"));
Select dropdown=new Select(Lan);
dropdown.selectByValue("JavaScript");
driver.findElement(By.id("search_stars")).sendKeys(">45");
driver.findElement(By.id("search_followers")).sendKeys(">50");
WebElement lic=driver.findElement(By.id("search_license"));
Select license=new Select(lic);
license.selectByVisibleText("Boost Software License 1.0");
driver.findElement(By.className("btn")).click();
String actualTest=driver.findElement(By.xpath("//div[@class='d-flex flex-column flex-md-row flex-justify-between border-bottom pb-3 position-relative']")).getText();
Assert.assertEquals(actualTest, "1 repository result");
String actualRepository=driver.findElement(By.cssSelector("a[class='v-align-middle']")).getText();
Assert.assertEquals(actualRepository, "mvoloskov/decider");
driver.findElement(By.xpath("//a[@class='v-align-middle']")).click();
WebElement readmeDriver = driver.findElement(By.xpath("//div[@data-target='readme-toc.content']"));
String expectedText = readmeDriver.getText();
//Printing the first 300 characters
System.out.println(expectedText.substring(0, 300));
throw new PendingException();
}



@Then("^the page title should start with \"([^\"]*)\"$")
public void the_page_title_should_start_with_something(String strArg1) throws Throwable {
	driver.close();
	throw new PendingException();
}
}



	   
	    
	    
	  
	

	

