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
public class Menu extends Page {

private String menu = ".//div/a[contains(.,'Меню')]";
private String upravlenie_zakupkami = ".//div/a[contains(.,'Управление закупками')]";
private String element_off = "/img[@src[contains(.,'_off')]]";
  

  public Menu(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void clickMenu(){
	  WebElement menu_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(menu))); 
	  menu_el.click();
  }
  
  public void clickUpravlenieZakupkami(){
	  Logger.info("В меню выбрать пункт 'Управление закупками'");
	  WebElement upravlenie_zakupkami_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(upravlenie_zakupkami)));
	  String src = upravlenie_zakupkami_el.findElement(By.tagName("img")).getAttribute("src");
	  if(src.contains("_off")){
		  upravlenie_zakupkami_el.click();
	  }
	  
  }

}
