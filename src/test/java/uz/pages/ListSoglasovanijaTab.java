package uz.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
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
public class ListSoglasovanijaTab extends Page {
	//Автор
	private String tableAuthor=".//div[div/div/div/table/tbody/tr/td/table/tbody/tr/td/span[contains(.,'Автор')]]";
	private String dolzhnostAuthor = tableAuthor + "//td[2]/div/input";
	private String telefonAuthor = tableAuthor + "//td[3]/div/input";
	
	//Согласующие
	private String addTableSoglas = ".//span[text()='Требуется согласование']/ancestor::td[1]/preceding-sibling::td//span/div";
	private String tableSoglasujushhieCollapse = ".//div[div/div/div/table/tbody/tr/td/table/tbody/tr/td/span[contains(.,'Согласующие')]]";
	private String addRow = tableSoglasujushhieCollapse + "//button[contains(@title, 'Добавить новую строку')]";
	
	private String tableSoglasujushhie = ".//div[div/table/tbody/tr/th/div/span[contains(.,'Этап')]]/div[3]/table/tbody[1]/tr";
	private String stage = tableSoglasujushhie + "/td[2]/div/input";
	private String codeGroup = tableSoglasujushhie + "/td[3]/div/input";
	private String numberSoglasujushhie = tableSoglasujushhie + "/td[4]/div/input";
	private String soglasujushhieSpravochnik = tableSoglasujushhie + "/td/div/button";//"/td[7]/div/button"
	
	//Утверждающий
	private String tableUtverzhdajushhij = ".//div[div/div/div/table/tbody/tr/td/table/tbody/tr/td/span[contains(.,'Утверждающий')]]";
	private String utverzhdajushhijSpravochnik = tableUtverzhdajushhij + "/div[2]/table/tbody/tr[3]/td/div/button";
	private String telefonUtverzhdajushhij = tableUtverzhdajushhij + "/div[2]/table/tbody/tr[3]/td[5]/div/input";
	

  public ListSoglasovanijaTab(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void setDolzhnostAuthor(String val){
	  Logger.info("Заполнить поле 'Должность' в разделе 'Автор' значением '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(dolzhnostAuthor)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void setTelephoneAuthor(String val){
	  Logger.info("Заполнить поле 'Телефон' в разделе 'Автор' значением '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(telefonAuthor)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void addTableSoglas(){
	  Logger.info("Нажать чек-бокс 'Требуется согласование'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(addTableSoglas)));
	  el.click();
  }
  public void newRow(){
	  Logger.info("Нажать кнопку  'Добавить новую строку' в разделе 'Согласующие'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(addRow)));
	  el.click();
  }
  public void setStage(String val){
	  Logger.info("Заполнить поле 'Этап' в разделе 'Согласующие' значением '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(stage)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void setCodeGroup(String val){
	  Logger.info("Заполнить поле 'Код группы' в разделе 'Согласующие' значением '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(codeGroup)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void setNumberSoglasujushhego(String val){
	  Logger.info("Заполнить поле 'Порядковый номер согласующего' в разделе 'Согласующие' значением '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(numberSoglasujushhie)));
	  el.clear();
	  el.sendKeys(val);
  }  
  public void clickSoglasujushhieSpravochnick(){
	  Logger.info("Нажать кнопку вызова справочника 'Согласующие'");
	  WebElement  kbkButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(soglasujushhieSpravochnik)));
	  kbkButton_el.click();
  } 
  public void clickUtverzhdajushhijSpravochnick(){
	  Logger.info("Нажать кнопку вызова справочника 'Утверждающий'");
	  WebElement  kbkButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(utverzhdajushhijSpravochnik)));
	  kbkButton_el.click();
  }  
  public void setTelephoneUtverzhdajushhego(String val){
	  Logger.info("Заполнить поле 'Телефон' в разделе 'Утверждающий' значением '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(telefonUtverzhdajushhij)));
	  el.clear();
	  el.sendKeys(val);
  }

}
