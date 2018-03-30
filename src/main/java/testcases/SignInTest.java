package testcases;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();        
        
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='ModalFrame']/iframe")));
        driver.findElement(By.id("signInButton")).click();

        String errors1 = driver.findElement(By.id("errors1")).getText();
        
        AssertJUnit.assertTrue(errors1.contains("There were errors in your submission"));
        
        driver.quit();
    }
}
