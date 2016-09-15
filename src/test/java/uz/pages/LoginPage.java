package uz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.util.Logger;

/**
 * Sample page
 */
public class LoginPage extends Page {

private String title = ".//*[@id='title']";
private String login = ".//input[@id='username']";
private String password = ".//input[@id='password']";
private String enter = ".//input[@value='Вход в систему']";


  

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void setLogin(String val){
	  Logger.info("Заполнить поле 'Имя пользователя' значением '"+val+"'");
	  WebElement login_el = (new WebDriverWait(driver, 10))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(login)));
	  login_el.sendKeys(val);
  }
  
  public void setPassword(String val){
	  Logger.info("Заполнить поле 'Пароль' значением '"+val+"'");
	  WebElement password_el = (new WebDriverWait(driver, 10))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(password)));
	  password_el.sendKeys(val);
  }
  
  public void clickEnter(){
	  Logger.info("Нажать кнопку 'Вход в систему'");
	  WebElement enter_el = (new WebDriverWait(driver, 10))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(enter)));
	  enter_el.click();
  }
}
