package uz.spravochnik;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.pages.Page;
import uz.util.Logger;

/**
 * Sample page
 */
public class UserSpravochnik extends Page {


	private String buttonOk = ".//button[contains(.,'Выход')]/preceding-sibling::button[contains(.,'OK')]";
	
	
  public UserSpravochnik(WebDriver webDriver) {
    super(webDriver);
  }
  

  //_Voskresensky.NN
  public void select(String val){
	  Logger.info("Выбрать в справочнике значение '"+val+"'");
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(.,'"+val+"')]")));
	  driver.findElement(By.xpath(".//span[contains(.,'"+val+"')]")).click();
	  clickOk();
  }
  public void clickOk(){
	  Logger.info("Нажать в справочнике кнопку 'ОК'");
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonOk)));
	  driver.findElement(By.xpath(buttonOk)).click();
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
  }
  

}