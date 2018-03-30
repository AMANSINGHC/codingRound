package testcases;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{
	
	@FindBy(linkText="Your trips")
	WebElement eleYourTrips;
	
	@FindBy(css="#SignIn")
	WebElement btnSignIn_1;
	
	@FindBy(xpath="//div[@id='ModalFrame']/iframe")
	WebElement frame;
	
	@FindBy(css="#signInButton")
	WebElement btnSignIn_2;
	
	@FindBy(css="#errors1")
	WebElement txtError;
	
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

    	PageFactory.initElements(driver, this);
    	
        eleYourTrips.click();
        btnSignIn_1.click();        
        
        driver.switchTo().frame(frame);
        btnSignIn_2.click();

        String errors1 = txtError.getText();
        
        AssertJUnit.assertTrue(errors1.contains("There were errors in your submission"));
    }
}
