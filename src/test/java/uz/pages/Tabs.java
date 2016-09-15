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
public class Tabs extends Page {

private String formular = ".//div/a[contains(.,'‘ормул€ры')]";

  

  public Tabs(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void clickForms(){
	  Logger.info("Ќажать на вкладку '‘ормул€ры'");
	  WebElement formular_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(formular))); 
	  formular_el.click();
  }
  



}
