package uz.spravochnik;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class NpoSpravochnik extends Page {
	
	private String table_loc = ".//div[contains(., 'Выбор записи из справочника')]";
//	private String filterInput = table_loc + "/div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/input";
	
	//Все фильтры с текстовым полем и датой
	private String filterInput = table_loc + "//div[contains(@class, 'fakepaging-header')]//th//input[contains(@class, 'textbox') OR contains(@class, 'datebox')]";
	
//	private String filterCodeInputField = table_loc + "/div[1]/table/tbody/tr[2]/th[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/input";
	private String filterCodeInputField = table_loc + "//div[contains(@class, 'fakepaging-header')]//th[2]//input";
	private String filterVisible = table_loc + "//img[@title='Видимость фильтров']";
	private String rows_loc = table_loc + "//div[3]/table/tbody[contains(@id, 'rows')]/tr";
	private String select_loc = rows_loc + "/td[1]/div/span";
	private String select_frst_loc = table_loc + "//div[3]/table/tbody/tr[1]/td[1]/div";
	private String desc_loc = rows_loc + "/td[2]/div";
	private String navigation_loc = table_loc + "//div[contains(@class, 'fake-panel')]";
	private String navigationNext_loc = navigation_loc + "/div[6]/div/button";
	private String navigationCurPage_loc = navigation_loc + "//input";//@value
	private String navigationMaxPage_loc = navigation_loc + "//div[5]/span";//text

	private String buttonOk = ".//div/button[contains(.,'Отмена')]/preceding-sibling::button[contains(.,'OK')]";
	
	
  public NpoSpravochnik(WebDriver webDriver) {
    super(webDriver);
  }
  
//Left
  public void navigationNext(){
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(navigationNext_loc)));
	  driver.findElement(By.xpath(navigationNext_loc)).click();
  }
 
  public Integer getCurPage(){
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(navigationCurPage_loc)));
	  return Integer.parseInt(driver.findElement(By.xpath(navigationCurPage_loc)).getAttribute("value"));
  }
  
  public Integer getMaxPage(){
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(navigationMaxPage_loc)));
	  return Integer.parseInt(driver.findElement(By.xpath(navigationMaxPage_loc)).getText().replaceAll("(\\D)+", ""));
  }  
  
  public void my_generic_wait_for_page_load() {
	  final WebDriverWait wait = new WebDriverWait(driver, 60);
	  final JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	  final ExpectedCondition<Boolean> jQueryActive_toBeZero = new ExpectedCondition<Boolean>() {
	     @Override
	     public Boolean apply(WebDriver driver) {
	         try {
	              return ((Long) jsExecutor
	                             .executeScript("return jQuery.active") == 0) ? true
	                             : false;
	         } catch (final WebDriverException e) {
	        	 System.out.println("It looks like jQuery is not available on the page, skipping the jQuery wait, check stack trace for details");
	             return true; //skip the wait
	         }
	     }
	 };
	    final ExpectedCondition<Boolean> document_readyState_toBeComplete = new ExpectedCondition<Boolean>() {
	             @Override
	             public Boolean apply(WebDriver driver) {
	                 return jsExecutor.executeScript("return document.readyState")
	                         .toString().equals("complete") ? true : false;
	             }
	         };
	         wait.until(jQueryActive_toBeZero);
	         wait.until(document_readyState_toBeComplete);

	  }
  
  public void waitForAsyncContentByXpath(String locatorXpath) {
	   WebElement e = (WebElement) driver.findElement(By.xpath(locatorXpath));
	   for( int i=0; i<10; i++ ) {
	     if( e.isDisplayed() ) {
	       return;
	     }
	     try {
	       Thread.sleep(1000);
	     } catch( InterruptedException ex ) {
	     }
	   }
  } 
  public void clearFilter(){
	  Logger.info("Очистка фильтра в справочнике");
	  WebElement row = null;
	  String val = null;
	  Boolean flag = false;
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
	  WebElement filter = driver.findElement(By.xpath(filterVisible));
	  if(filter.getAttribute("src").contains("filter_off")){
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(filterInput)));
		  List <WebElement> list  = driver.findElements(By.xpath(filterInput));
		  for (Iterator<WebElement> iterator = list.iterator(); iterator.hasNext();) {
			  row = (WebElement) iterator.next();
			  val = row.getAttribute("value");
			  if(val!=null){
				  row.clear();
				  flag=true;
			  }
		  }
		  if(flag){
			  row.sendKeys(Keys.ENTER);
		  }
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
		  
	  }

  }
  public void select(String val){
	  clearFilter();
	  Logger.info("Выбрать в справочнике значение '"+val+"'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  my_generic_wait_for_page_load();
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  List <WebElement> list  = null;
	  int cur = 0;
	  int max = 0;
	  String row_val = null;
	  cur = getCurPage();
	  max = getMaxPage();
	  for(int i = cur;i<=max;i++){
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(rows_loc)));
		  list  = driver.findElements(By.xpath(rows_loc));
		  for (Iterator<WebElement> iterator = list.iterator(); iterator.hasNext();) {
			WebElement row = (WebElement) iterator.next();
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(row)));
			row_val = row.findElement(By.xpath(".//td[2]/div")).getText();
			if(row_val.equals(val)){
				row.findElement(By.xpath(".//td[1]/div/span")).click();
				my_generic_wait_for_page_load();
				clickOk();
				return;
			}
		  }
		  list = null;
		  navigationNext();
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
		  my_generic_wait_for_page_load();
		  wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(rows_loc))));
	  }

  } 
  
  public void setFilter(String name, String val){
	  Logger.info("Заполнить поле '"+name+"' фильтра значением '"+val+"' и применить фильтр");
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
	  WebElement filter = driver.findElement(By.xpath(filterVisible));
	  if(filter.getAttribute("src").contains("filter_on")){
		  filter.click();
	  }
	  String filterName = null;
	  if(name.equalsIgnoreCase("Кодовое обозначение элемента")){
		  filterName = filterCodeInputField;
	  }
	  try {
	       Thread.sleep(4000);
	     } catch( InterruptedException ex ) {
	     }
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterName)));
	  WebElement el = driver.findElement(By.xpath(filterName));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el);
	  el.clear();
	  el.sendKeys(val);
	  el.sendKeys(Keys.ENTER);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
  }
  
  private void selectFirstRow(){
	  Logger.info("Выбрать первую строку");
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(select_frst_loc)));
	  WebElement el = driver.findElement(By.xpath(select_frst_loc));
	  el.click();
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
  }
  
  public void selectWithFilter(String filterName, String val){
	  clearFilter();
	  setFilter(filterName, val);
	  selectFirstRow();
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