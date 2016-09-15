package uz.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.popup.SoglasovatZakupkuPopUp;
import uz.popup.UtverditPopUp;
import uz.util.Logger;

/**
 * Sample page
 */
public class UZ200Page extends Page {
	//Фильтры
	private String filterList = ".//div[1]/table/tbody/tr[2]/th/div//span/a";
	private String filterListElement = "(.//div/ul[li/span[2]]/li[1])[1]";
	private String filterInput = ".//div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/input";
	private String filterDate = ".//div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/input";
	private String filterInputName =".//div[1]/table/tbody/tr[2]/th[position() = (count(//th[contains(.,'Номер')]/preceding-sibling::*)+1)]/div/table/tbody/tr/td/table/tbody/tr/td[3]/input";//(.//div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/input)[2]
//	private String statusTable = ".//th/div[contains(.,'Статус')]";
//	private String filterVisible = ".//div[1]/table/tbody/tr[1]/th[1]/div/table/tbody/tr/td/table/tbody/tr/td/img";
	private String filterVisible = ".//img[@title='Видимость фильтров']";
	private String table_number = ".//div[3]/table/tbody/tr[1]/td[position() = (count(//th[contains(.,'Номер')]/preceding-sibling::*)+1)]/div"; //[6]
	private String table_status = ".//div[3]/table/tbody/tr[1]/td[position() = (count(//th[contains(.,'Статус')]/preceding-sibling::*)+1)]/div";
	private String table_checkbox_frst_row = ".//div[3]/table/tbody/tr[1]/td[1]/div/span";
	
	private String addDocument = ".//img[contains(@src,'document_new.png')]/..";//".//button[contains(@title,'Создать новый документ')][img[contains(@src,'document_new.png')]]";
	private String na_soglasovanie = ".//img[contains(@src,'ico_dollar.png')]/..";
	private String soglasovat_zakupku = ".//button[@title='Согласовать закупку']";
	private String utverdit = ".//button[@title='Утвердить']";
	private String refresh = ".//button[@title='Обновить список документов']";
	//Tabs
	private String osnovnyeSvedenijaTab = ".//li/a[contains(.,'Основные сведения')]";
	private String harakteristikaFinansovogoObespechenijaTab = ".//li/a[contains(.,'Характеристика финансового обеспечения')]|.//ul[li/a[contains(.,'Основные сведения')]]/li[2]/a";
	private String listSoglasovanijaTab = ".//li/a[contains(.,'Лист согласования')]";
	//Сохранить изменения
	private String saveChange = ".//tr[td/button[contains(@title,'Сохранить изменения')]]/td[5]/button";
	//Закрыть карточку уз
	private String closeUz = "(.//div[button[contains(@title,'Карточки укрупненных закупок')]]|.//div[button[contains(@title,'Карточки закупки на согласовании')]]|.//div[button[contains(@title,'Карточки закупки на утверждении')]])/a[contains(@title,'Закрыть')]";
	//Закрыть окно
	//private String closeWindow = ".//button[contains(.,'Закрыть окно')]";
	private String closeWindow = ".//tr[td/button[contains(@title,'Закрыть окно')]]/td[7]/button";

  public UZ200Page(WebDriver webDriver) {
    super(webDriver);
    driver.switchTo().frame(1);
  }
  public void waitPageLoad(){
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(refresh)));
  }
//Новый документ
  public void newDocument(){
	  Logger.info("Нажать кнопку 'Создать новый документ'");
	  WebElement addDocument_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(addDocument)));
	  addDocument_el.click();
  }
  
  //на согласование
  public void clickSoglasovanie(){
	  Logger.info("Нажать кнопку 'Отправить на согласование'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(na_soglasovanie)));
	  el.click();
  }
  //согласовать закупку
  public void clickSoglasovatZakupku(){
	  Logger.info("Нажать кнопку 'Согласовать закупку'");
	 
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(soglasovat_zakupku)));
	  el.click();
  }
  //утвердить
  public void clickUtverdit(){
	  Logger.info("Нажать кнопку 'Утвердить'"); 
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(utverdit)));
	  el.click();
  }
  //Сохранить изменения
  public void saveChange(){
	  Logger.info("Нажать кнопку 'Сохранить изменения'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(saveChange)));
	  el.click();
  }
//Закрыть  уз
  public void closeUZ(){
	  Logger.info("Закрыть вкладку карточки УЗ");
	  driver.switchTo().defaultContent();
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(closeUz)));
	  el.click();
  }
  public void closeWindow(){
	  Logger.info("Закрыть карточку УЗ");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(closeWindow)));
	  el.click();
  }
 //Вкладки
  public void goToTabOsnovnyeSvedenija(){
	  Logger.info("Перейти на вкладку 'Общая информация о закупке'");
	  WebElement osnovnyeSvedenijaTab_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(osnovnyeSvedenijaTab)));
	  osnovnyeSvedenijaTab_el.click();
  }
  
  public void goToTabHarakteristikaFinansovogoObespechenija(){
	  Logger.info("Перейти на вкладку 'Характеристика финансового обеспечения'");
	  WebElement  harakteristikaFinansovogoObespechenija_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath( harakteristikaFinansovogoObespechenijaTab)));
	  harakteristikaFinansovogoObespechenija_el.click();
  }  
  
  public void goToTabListSoglasovanija(){
	  Logger.info("Перейти на вкладку 'Лист согласования'");
	  WebElement  listSoglasovanija_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath( listSoglasovanijaTab)));
	  listSoglasovanija_el.click();
  } 
  
  public void clearFilter(){
	  Logger.info("Очистка фильтра в таблице карточек УЗ");
	  WebElement row = null;
	  String val = null;
	  Boolean flag = false;
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
	  WebElement filter = driver.findElement(By.xpath(filterVisible));
	  if(filter.getAttribute("src").contains("filter_off")){
		 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterInputName)));
			WebElement el = driver.findElement(By.xpath(filterInputName));
			((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el);
			
			el.click();
			el.sendKeys(Keys.ENTER);
			 try {
			       Thread.sleep(2000);
			     } catch( InterruptedException ex ) {
			     }

		  }
		  
		  WebElement cell = null;
		  WebElement li = null;
		  val = null;
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(filterList)));
		  List <WebElement> el_list  = driver.findElements(By.xpath(filterList));
		  for (Iterator<WebElement> el_iterator = el_list.iterator(); el_iterator.hasNext();) {
			  cell = (WebElement) el_iterator.next();
			  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", cell);
			  ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", cell);

		  }
		  WebElement date_el=null;
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(filterDate)));
		  List <WebElement> date_list  = driver.findElements(By.xpath(filterDate));
		  for (Iterator<WebElement> date_iterator = date_list.iterator(); date_iterator.hasNext();) {
			  date_el = (WebElement) date_iterator.next();
			  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", date_el);
			  ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", date_el);

		  }
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(filterInput)));
		  List <WebElement> list  = driver.findElements(By.xpath(filterInput));
		  for(int it = 0; it<(list.size()-1); it++){
			  row = list.get(it);
			  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", row);
			  ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", row);

		  }
		 
/*		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterInputName)));
		WebElement el = driver.findElement(By.xpath(filterInputName));
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el);
		
		el.click();
		el.sendKeys(Keys.ENTER);
		 try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }

	  }*/

  }
  public void setFilter(String name, String val){
	  Logger.info("Заполнить поле '"+name+"' фильтра в таблице карточек УЗ значением '"+val+"' и применить фильтр");
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
	  WebElement filter = driver.findElement(By.xpath(filterVisible));
	  if(filter.getAttribute("src").contains("filter_on")){
		  filter.click();
	  }
	  String filterName = null;
	  if(name.equalsIgnoreCase("Номер")){
		  filterName = filterInputName;
	  }
	  try {
	       Thread.sleep(2000);
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
  
  public void clearFilter(String name){
	  Logger.info("Очистка фильтра '"+name+"' в таблице карточек УЗ");
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
	  WebElement filter = driver.findElement(By.xpath(filterVisible));
	  if(filter.getAttribute("src").contains("filter_on")){
		  filter.click();
	  }
	  String filterName = null;
	  if(name.equalsIgnoreCase("Номер")){
		  filterName = filterInputName;
	  }
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filterName)));
	  WebElement el = driver.findElement(By.xpath(filterName));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", el);
	  el.click();
	  el.sendKeys(Keys.ENTER);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
  }
  public void assertNumber(String val){
	  Logger.info("Проверить поле 'Номер'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(table_number)));
	  WebElement number_el = driver.findElement(By.xpath(table_number));
	  String curNumber = number_el.getText();
	  Assert.assertEquals(val, curNumber);
  }
  public void assertStatus(String val){
	  Logger.info("Проверить поле 'Статус'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(table_status)));
	  WebElement el = driver.findElement(By.xpath(table_status));
	  String curStatus = el.getText();
	  Assert.assertEquals(val, curStatus);
  }
  public void selectFirstRow(){
	  Logger.info("Выбрать чекбокс первой строки");
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(table_checkbox_frst_row)));
	  WebElement el = driver.findElement(By.xpath(table_checkbox_frst_row));
	  el.click();
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
  }
  public void assertNewDocument(String docNumber){
	  	Logger.info("Проверить Карточка появилась в списковой форме");
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("Номер", docNumber);
	    assertNumber(docNumber);
	    clearFilter("Номер");
  }
  
  public void otpravitNaSoglasovanie(String docNumber){
	  	Logger.info("Отправить карточку на согласование");
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("Номер", docNumber);
	    assertNumber(docNumber);
	    selectFirstRow();
	    clickSoglasovanie();
	    clearFilter("Номер");
  }
  public void soglasovatZakupku(String docNumber){
	  	driver.switchTo().frame(1);
	  	Logger.info("Согласование закупки");
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("Номер", docNumber);
	    //assertNumber(docNumber);
	    selectFirstRow();
	    clickSoglasovatZakupku();
	    SoglasovatZakupkuPopUp popup = new SoglasovatZakupkuPopUp(driver);
	    popup.clickSoglasovat();
	    popup.clickOk();
	    clearFilter("Номер");
  }
  public void utverjdenieZakupku(String docNumber){
	  	Logger.info("Утверждение закупки");
	  	driver.switchTo().frame(1);
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("Номер", docNumber);
	    //assertNumber(docNumber);
	    selectFirstRow();
	    clickUtverdit();
	    UtverditPopUp popup = new UtverditPopUp(driver);
	    popup.clickUtverdit();
	    popup.clickOk();
	    clearFilter("Номер");
	    
  }

}
