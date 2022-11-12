import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ViewAccoutnSummery {
    WebDriver driver;
    public ViewAccoutnSummery(WebDriver driver){
        this.driver = driver;
    }
    public Boolean clickOnViewAccountSummery(){
        try{
            WebElement viewAccount_link;
            viewAccount_link = this.driver.findElement(By.id("MenuHyperLink1"));
            viewAccount_link.click();
            return true;

        }catch(Exception ex){
            return false;
        }
    }

    public Boolean viewAccountDetails(String accountOption){
        try{
            WebElement go_btn;
            Select dropdown = new Select(driver.findElement(By.id("listAccounts")));
            dropdown.selectByVisibleText(accountOption);
            go_btn = driver.findElement(By.id("btnGetAccount"));
            go_btn.click();
            return true;

        }catch(Exception ex){
            return false;
        }
    }

    public Boolean verifyAvailableBalance(){
        try{
            WebElement aval_Bal;
            aval_Bal = driver.findElement(By.xpath("//div/table/tbody//tr[4]/td[contains(text(),'Available balance')]//following-sibling::td"));
            aval_Bal.isDisplayed();
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
}
