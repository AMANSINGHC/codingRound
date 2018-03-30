package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest{

	@FindBy(css="#OneWay")
	WebElement rBtnOneWay;
	
	@FindBy(css="#FromTag")
	WebElement txtFrom;
	
	@FindBy(css="#ui-id-1")
	WebElement originOptions;
	
	@FindBy(css="#ToTag")
	WebElement txtTo;
	
	@FindBy(css="#ui-id-2")
	WebElement destOptions;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[7]/a")
	WebElement date;
	
	@FindBy(css="#SearchBtn")
	WebElement btnSearch;
	
    @Test
    public void testThatResultsAppearForAOneWayJourney() {

    	PageFactory.initElements(driver, this);
    	
        rBtnOneWay.click();

        txtFrom.clear();
        txtFrom.sendKeys("Bangalore");

        //wait for the auto complete options to appear for the origin        
        originOptions.findElements(By.tagName("li")).get(0).click();

        txtTo.clear();
        txtTo.sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination

        
        //select the first item from the destination auto complete list
        destOptions.findElements(By.tagName("li")).get(0).click();

        date.click();

        //all fields filled in. Now click on search
        btnSearch.click();

        //verify that result appears for the provided journey search
        AssertJUnit.assertTrue(isElementPresent(By.className("searchSummary")));
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
