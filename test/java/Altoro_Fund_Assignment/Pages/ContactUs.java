import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs {
    
    WebDriver driver;
    public ContactUs(WebDriver driver){
        this.driver = driver;
    }

    public Boolean clickOnContactUs(){
        try{
         // find the contact us link   
        WebElement contact_us = driver.findElement(By.id("HyperLink3"));
        //click on contact us
        contact_us.click();
        return true;
        }catch(Exception ex){
            return false;
        }
    }

    public Boolean clickOnlineForm(){
        try{
        //find online form link
        WebElement online_form_link = driver.findElement(By.xpath("//a[text()='online form']"));
        
        //click on link
        online_form_link.click();
        return true;
        }catch(Exception ex){
            return false;
        }
    }

   //Enter online form detail and submit form
    public Boolean fillUpOnlineFormDetail(String username,String emailid,String subject,String comment){
        try{
        //Find username textbox
        WebElement username_txt = driver.findElement(By.xpath("//input[@name='name']"));

        //Enter the username
        username_txt.sendKeys(username);

        //Find EmailId textbox
        WebElement email_address_txt = driver.findElement(By.name("email_addr"));

        //Enter the email address
        email_address_txt.sendKeys(emailid);

        //Find subject textbox
        WebElement subject_txt = driver.findElement(By.name("subject"));

        //Enter the subject
        subject_txt.sendKeys(subject);

         //Find comment textbox
         WebElement comment_txt = driver.findElement(By.name("comments"));

         //Enter the comment
         comment_txt.sendKeys(comment);

         //find the submit button
         WebElement submit_btn = driver.findElement(By.name("submit"));

         //click on the submit button
         submit_btn.click();

        return true;
        }catch(Exception ex){
            return false;
        }
    }
   
    //Verify successfull message after submitting detail
    public Boolean verifysuccefullMessage(){
        try{
            // find the message
            WebElement text_message1 = driver.findElement(By.xpath("//h1[text()='Thank You']"));

            // find the message
            WebElement text_message2 = driver.findElement(By.xpath("//p"));

            //verify message dispalyed or not
            if(text_message1.isDisplayed() && text_message2.isDisplayed()){
            return true;
        }
        
       }catch(Exception ex){
        return false;
       }
      return true;
    }

    public Boolean clickOnSignOff(){
        try{
            // find the signoff
            WebElement signoff = driver.findElement(By.id("LoginLink"));

            //click on the signoff
            signoff.click();
            return true;
            }
            catch(Exception ex){
                return false;
        }
    }

    public Boolean VerifySignOff(){
        try{
            // find the signin 
            WebElement signin = driver.findElement(By.xpath("//*[text()='Sign In']"));

            // verify sign in dispalayed or not after signoff
            signin.isDisplayed();
            return true;

        }catch(Exception ex){
         return false;
        }
    }

}
