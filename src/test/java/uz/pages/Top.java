package uz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.util.Logger;

/**
 * Sample page
 */
public class Top extends Page {

private String exitButton = ".//button[span[contains(.,'Выйти')]]";
  

  public Top(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void clickLogout(){
	  Logger.info("Нажать кнопку 'Выйти'");
	  driver.switchTo().defaultContent();
	  WebElement menu_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(exitButton))); 
	  menu_el.click();
  }

}
