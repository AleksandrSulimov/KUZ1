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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.pages.Page;
import uz.util.Logger;

/**
 * Sample page
 */
public class OkpdSpravochnik extends Page {
	private String window = ".//div[div[contains(.,'ОКПД 2')]]/descendant-or-self::*";
	private String leftBlock = ".//div[div/table[contains(.,'Кодовое обозначение элемента справочника')]]";
	private String leftTable = leftBlock + "/div[3]/table/tbody/tr";
	private String leftElementRow = leftTable + "/td/div/span[2]";
	private String leftElementExpand = leftTable + "/td/div/span[1]";
	private String leftNavigation = leftBlock + "/div[4]/div/ul";
	private String leftNavigationNext = leftNavigation + "/li[4]/a";
	private String leftNavigationCurPage = leftNavigation + "/li[3]/input";
	private String leftNavigationMaxPage = leftNavigation + "/li[3]/span";

	private String buttonOk = ".//div/button[contains(.,'Отмена')]/preceding-sibling::button[contains(.,'OK')]";
	
	private String rightTable = ".//div[contains(.,'Наименование')]/following-sibling::div/table/tbody[1]/tr/td[2]/div";
	//фильтр
	private String table_loc = window + "//th[contains(.,'Наименование')]/../../../../..";
	private String filterInput = table_loc + "/div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/input";
	private String filterVisible = table_loc + "/div[1]/table/tbody/tr[1]/th[1]/div/table/tbody/tr/td/table/tbody/tr/td/img";
	
	private String leftElementRowNew = leftBlock + "//div[span[contains(.,'%1$s')]]";
	private String leftElementExpandNew = "/span[@class='z-tree-icon']";
	private String leftElementTextNew = "/span[@class='z-treecell-text']";
	
  public OkpdSpravochnik(WebDriver webDriver) {
    super(webDriver);
  }
  
//Left
  public void leftNavigationNext(){
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(leftNavigationNext)));
	  driver.findElement(By.xpath(leftNavigationNext)).click();
  }
 
  public Integer getCurPage(){
	  try {
	       Thread.sleep(1000);
	     } catch( InterruptedException ex ) {
	     }
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(leftNavigationCurPage)));
	  return Integer.parseInt(driver.findElement(By.xpath(leftNavigationCurPage)).getAttribute("value"));
  }
  
  public Integer getMaxPage(){
	  try {
	       Thread.sleep(1000);
	     } catch( InterruptedException ex ) {
	     }
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(leftNavigationMaxPage)));
	  return Integer.parseInt(driver.findElement(By.xpath(leftNavigationMaxPage)).getText().replaceAll("(\\D)+", ""));
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
  
  public void selectLevelOne(String val){
	  Logger.info("Выбрать и раскрыть в справочнике в левом блоке на первом уровне дерева значение '"+val+"'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  my_generic_wait_for_page_load();
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);//.ignoring(StaleElementReferenceException.class);
/*	  List <WebElement> list  = null;
	  int cur = 0;
	  int max = 0;
	  String title = null;
	  cur = getCurPage();
	  max = getMaxPage();
	  for(int i = cur;i<=max;i++){
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(leftTable)));//visibilityOfAllElementsLocatedBy
		  list  = driver.findElements(By.xpath(leftTable));
		  for (Iterator<WebElement> iterator = list.iterator(); iterator.hasNext();) {
			WebElement row = (WebElement) iterator.next();
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(row)));//visibilityOf
			title = row.getAttribute("title");
			row.findElement(By.xpath(".//td/div/span[2]")).click();
			if(title.equals(val)){
				row.findElement(By.xpath(".//td/div/span[1]")).click();
				my_generic_wait_for_page_load();
				return;
			}
		  }
		  list = null;
		  leftNavigationNext();
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
		  my_generic_wait_for_page_load();
		  wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(leftTable))));//visibilityOfElementLocated
	  }*/
//	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(leftTable)));//visibilityOfAllElementsLocatedBy
//	  List <WebElement> list  = driver.findElements(By.xpath(leftTable));
	  driver.findElement(By.xpath(String.format(leftElementRowNew, 10))).click();
	  my_generic_wait_for_page_load();
	  try {
	       Thread.sleep(6000);
	     } catch( InterruptedException ex ) {
	     }
	  driver.findElement(By.xpath(String.format(leftElementRowNew, 10))).sendKeys(Keys.END);
	  my_generic_wait_for_page_load();
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementTextNew, val))).click();
	  my_generic_wait_for_page_load();
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementExpandNew, val))).click();
//	  row.findElement(By.xpath(leftElementExpandNew)).click();
//	  driver.findElement(By.xpath(String.format(leftElementExpandNew, val))).click();
  } 
  
  public void selectLevelTwo(String val){
	  Logger.info("Выбрать и раскрыть в справочнике в левом блоке на втором уровне дерева значение '"+val+"'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  my_generic_wait_for_page_load();
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);//.ignoring(StaleElementReferenceException.class);
/*	  List <WebElement> list  = null;
	  int cur = 0;
	  int max = 0;
	  String title = null;
	  cur = getCurPage();
	  max = getMaxPage();
	  for(int i = cur;i<=max;i++){
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(leftTable)));//visibilityOfAllElementsLocatedBy
		  list  = driver.findElements(By.xpath(leftTable));
		  for (Iterator<WebElement> iterator = list.iterator(); iterator.hasNext();) {
			WebElement row = (WebElement) iterator.next();
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(row)));//visibilityOf
			title = row.getAttribute("title");
			if(title.equals(val)){
				row.findElement(By.xpath(".//td/div/span[3]")).click();
				row.findElement(By.xpath(".//td/div/span[2]")).click();
				my_generic_wait_for_page_load();
				return;
			}
		  }
		  list = null;
		  leftNavigationNext();
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
		  my_generic_wait_for_page_load();
		  wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(leftTable))));//visibilityOfElementLocated
	  }*/
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementTextNew, val))).click();
	  my_generic_wait_for_page_load();
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementExpandNew, val))).click();
  } 
  public void selectLevelThree(String val){
	  Logger.info("Выбрать и раскрыть в справочнике в левом блоке на третьем уровне дерева значение '"+val+"'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  my_generic_wait_for_page_load();
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);//.ignoring(StaleElementReferenceException.class);
/*	  List <WebElement> list  = null;
	  int cur = 0;
	  int max = 0;
	  String title = null;
	  cur = getCurPage();
	  max = getMaxPage();
	  for(int i = cur;i<=max;i++){
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(leftTable)));//visibilityOfAllElementsLocatedBy
		  list  = driver.findElements(By.xpath(leftTable));
		  for (Iterator<WebElement> iterator = list.iterator(); iterator.hasNext();) {
			WebElement row = (WebElement) iterator.next();
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(row)));//visibilityOf
			title = row.getAttribute("title");
			if(title.equals(val)){
				row.findElement(By.xpath(".//td/div/span[4]")).click();
				row.findElement(By.xpath(".//td/div/span[3]")).click();
				my_generic_wait_for_page_load();
				return;
			}
		  }
		  list = null;
		  leftNavigationNext();
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
		  my_generic_wait_for_page_load();
		  wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(leftTable))));//visibilityOfElementLocated
	  }*/
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementTextNew, val))).click();
	  my_generic_wait_for_page_load();
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementExpandNew, val))).click();
  } 
  public void selectLevelFour(String val){
	  Logger.info("Выбрать и раскрыть в справочнике в левом блоке на четвертом уровне дерева значение '"+val+"'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  my_generic_wait_for_page_load();
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);//.ignoring(StaleElementReferenceException.class);
/*	  List <WebElement> list  = null;
	  int cur = 0;
	  int max = 0;
	  String title = null;
	  cur = getCurPage();
	  max = getMaxPage();
	  for(int i = cur;i<=max;i++){
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(leftTable)));//visibilityOfAllElementsLocatedBy
		  list  = driver.findElements(By.xpath(leftTable));
		  for (Iterator<WebElement> iterator = list.iterator(); iterator.hasNext();) {
			WebElement row = (WebElement) iterator.next();
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(row)));//visibilityOf
			title = row.getAttribute("title");
			if(title.equals(val)){
				row.findElement(By.xpath(".//td/div/span[5]")).click();
				row.findElement(By.xpath(".//td/div/span[4]")).click();
				my_generic_wait_for_page_load();
				return;
			}
		  }
		  list = null;
		  leftNavigationNext();
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
		  my_generic_wait_for_page_load();
		  wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(leftTable))));//visibilityOfElementLocated
	  }*/
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementTextNew, val))).click();
	  my_generic_wait_for_page_load();
	  driver.findElement(By.xpath(String.format(leftElementRowNew+leftElementExpandNew, val))).click();
  } 
 public void selectRightTable(String code){
	 Logger.info("Выбрать в справочнике в правом блоке значение '"+code+"'");
	 try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  my_generic_wait_for_page_load();
	 WebDriverWait wait = new WebDriverWait(driver, 60);
	  String txt = null;
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(rightTable)));
	  List<WebElement>  leftTable_el = driver.findElements(By.xpath(rightTable));
	  Iterator<WebElement> el_i = leftTable_el.iterator();
	  while(el_i.hasNext()){
		  WebElement row = (WebElement) el_i.next();
		  wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(row)));
		  txt = row.getText();
		  if(txt.equals(code)){
			  row.click();
			  return;
		  }
	  }	 
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
  
  public void select(String lvlOneVal, String lvlTwoValue, String rightCodeValue ){
	 clearFilter();
	 selectLevelOne(lvlOneVal);
	 selectLevelTwo(lvlTwoValue);
	 selectRightTable(rightCodeValue);
	 clickOk();
  }
  
  public void select(String lvlOneVal, String lvlTwoValue, String lvlThreeValue, String rightCodeValue ){
	  clearFilter();
	  selectLevelOne(lvlOneVal);
	  selectLevelTwo(lvlTwoValue);
	  selectLevelThree(lvlThreeValue);
	  selectRightTable(rightCodeValue);
	  clickOk();
  }
  public void select(String lvlOneVal, String lvlTwoValue, String lvlThreeValue, String lvlFourValue, String rightCodeValue ){
	  clearFilter();
	  selectLevelOne(lvlOneVal);
	  selectLevelTwo(lvlTwoValue);
	  selectLevelThree(lvlThreeValue);
	  selectLevelFour(lvlFourValue);
	  selectRightTable(rightCodeValue);
	  clickOk();
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
		  
	  }

  }

}