package features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StepDefs {
	
	WebDriver driver = null; // share browser between steps
	String s = null; // save in between steps
	
	@Given("^Navigate to http://sports.williamhill.com/betting/en-gb$")
    public void Navigate_to_http_sports_williamhill_com_betting_en_gb() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); // driver path
		driver = new ChromeDriver(); // chrome browser
		
		driver.navigate().to("http://sports.williamhill.com/betting/en-gb"); // browser url change

    }

    @When("^Navigate to any football event$")
    public void Navigate_to_any_football_event() throws Throwable {
		
		driver.manage().window().maximize(); // maximize browser window
    	(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("match-highlights-OB_SP9"))); // wait till element will be visible
    	
    	WebElement MyCurrentWebElement = driver.findElement(By.id("match-highlights-OB_SP9")); // save element
    	int i = MyCurrentWebElement.findElements(By.cssSelector(".event")).size(); // save count of events
    	int rnd = (int) (Math.floorMod((int) (Math.random() * 10), i)); // random number from 0 till events count - 1
    	MyCurrentWebElement.findElements(By.cssSelector(".event")).get(rnd).click(); // find and click on random event
    	
    	s = MyCurrentWebElement.findElements(By.cssSelector(".event")).get(rnd).getAttribute("id"); // save id of element (for easiest find next element)
    	s = "stake-input__" + MyCurrentWebElement.findElements(By.cssSelector("[data-event='"+s+"']")).get(0).getAttribute("id").substring(5) + "L"; // get id for bet form
    	
    }

    @And("^Select event and place a \"([^\"]*)\" bet for the home team to Win$")
    public void select_event_and_place_a_bet_for_the_home_team_to_Win(String value) throws Throwable {
    	
    	(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.id(s))); // wait till element will be visible
    	driver.findElement(By.id(s)).sendKeys(value); // write value for bet

    }

    @And("^Place bet and assert the odds and returns offered$")
    public void Place_bet_and_assert_the_odds_and_returns_offered() throws Throwable {
    	
    	driver.findElement(By.cssSelector("[data-ng-click='placeBet()']")).click(); // confirm bet
    	
    	Assert.assertTrue(driver.findElement(By.cssSelector("#place-bet-error > span")).getText().contains("You must be logged in to place a bet, please log in and try again")); // check message
    	
    	WebElement MyCurrentWebElement = driver.findElement(By.cssSelector("[title='Remove Selection']")); // save element save id of element (for easiest find next element)
    	MyCurrentWebElement.findElement(By.cssSelector("i[class='icon-x']")).click(); // find and click on cross icon

    }
    
    @Then("^Close the browser$")
    public void Close_the_browser() throws Throwable {
    	
    	driver.close(); // close browser
    	
    }

}
