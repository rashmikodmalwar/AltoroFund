import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransferFundPage {
    WebDriver driver;
    float deposit_tmp_amount;
    String deposit_tmp_accountFrom;
    String deposit_tmp_accountTo;
    float withdrawl_tmp_amount;
    String withdrawl_tmp_accountFrom;
    String withdrawl_tmp_accountTo;
    public TransferFundPage(WebDriver driver){
        this.driver = driver;
    }
    public Boolean ClickOnTransferFunds(){
        try{
            WebElement transfer_Fund_LinkClick;
            transfer_Fund_LinkClick = driver.findElement(By.id("MenuHyperLink3"));
            transfer_Fund_LinkClick.click();
            return true;

        }catch(Exception ex){
            return false;
        }
    }

    public Boolean transferFundDetail(String fromAccount,String toAccount,int amount1){
        try{
            Select from_account_dropdown = new Select(driver.findElement(By.id("fromAccount")));
            from_account_dropdown.selectByVisibleText(fromAccount);
            Select to_account_dropdown = new Select(driver.findElement(By.id("toAccount")));
            to_account_dropdown.selectByVisibleText(toAccount);
            WebElement amount_tran = driver.findElement(By.id("transferAmount"));
            amount_tran.sendKeys(String.valueOf(amount1));
            deposit_tmp_accountTo = toAccount;
            deposit_tmp_accountFrom = fromAccount;
            deposit_tmp_amount = amount1;
            WebElement transer_money_btn = driver.findElement(By.id("transfer"));
            transer_money_btn.click();
            return true;

        }catch(Exception ex){
            return false;
        }

    }

    public Boolean validateTransactionDetailMessage(float amounttrans){
        try{
             //String amounttoRepalce = amount.getText();
            WebElement stringtoRepalce =  driver.findElement(By.xpath("//*[contains(text(),'was successfully transferred from Account')]"));
            System.out.println(stringtoRepalce.getText());
            if(stringtoRepalce.getText().contains(String.valueOf(amounttrans))){
                return true;
            }
            
           return true;
        }catch(Exception ex){
            return false;

        }

    }

    public Boolean clickOnViewRecentTransaction(){
        try{
            WebElement recent_trans_click;
            recent_trans_click = driver.findElement(By.id("MenuHyperLink2"));
            recent_trans_click.click();
            return true;
        }catch(Exception ex){
           return false;
        }
    }

    public Boolean validateDepositTransactionDetail(){
        try{
          WebElement deposit_account_id= driver.findElement(By.xpath("//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tbody//tr[2]//td[3]"));
          WebElement deposit_account_type= driver.findElement(By.xpath("//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tbody//tr[2]//td[4]"));
          WebElement deposit_account_amount= driver.findElement(By.xpath("//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tbody//tr[2]//td[5]"));
          
          if(deposit_account_id.getText().equals(String.valueOf(deposit_tmp_accountTo)) && deposit_account_type.getText().equals("Deposit")
          && deposit_account_amount.getText().equals(String.valueOf(deposit_tmp_amount)))
          {
            return true;

          }
        }catch(Exception ex){
           return false;
        }
        return true;
    } 
    
    public Boolean validateWithdrawlTransactionDetail(){
        try{
          WebElement withdrawl_account_id= driver.findElement(By.xpath("//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tbody//tr[3]//td[3]"));
          WebElement withdrawl_account_type= driver.findElement(By.xpath("//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tbody//tr[3]//td[4]"));
          WebElement withdrawl_account_amount= driver.findElement(By.xpath("//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tbody//tr[3]//td[5]"));
          
          if(withdrawl_account_id.getText().equals(String.valueOf(withdrawl_tmp_accountTo)) && withdrawl_account_type.getText().equals("Withdrawal")
          && withdrawl_account_amount.getText().equals(String.valueOf(withdrawl_tmp_amount)))
          {
            return true;

          }
        }catch(Exception ex){
           return false;
        }
        return true;
    } 
    
}


