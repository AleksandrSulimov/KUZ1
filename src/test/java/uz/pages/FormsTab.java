package uz.pages;



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
public class FormsTab extends Page {

	private String formular = ".//div/a[contains(.,'Формуляры')]";
	private String upravlenie_zakupkami = ".//div/span[contains(.,'Управление закупками')]/preceding-sibling::span[1]/a";
	private String planirovanie = ".//span[text()='Планирование']/ancestor::span/preceding-sibling::span/a";
	private String formirovanieOBAS = ".//div/span[contains(.,'Формирование ОБАС')]/preceding-sibling::span[1]/a";
	private String kartochki_uz = ".//div/span[contains(.,'Карточки укрупненных закупок')]/preceding-sibling::span[1]/a";
	private String uz_200 = ".//div/span/a[contains(.,'Карточки укрупненных закупок - 200')]";
	private String uz_300 = ".//div/span/a[contains(.,'Карточки укрупненных закупок - 300')]";
	private String uz_400 = ".//div/span/a[contains(.,'Карточки укрупненных закупок - 400')]";
	private String kartochki_uz_200 = ".//div/span[contains(.,'Карточки УЗ 200')]/preceding-sibling::span[1]/a";
	private String kartochki_uz_300 = ".//div/span[contains(.,'Карточки УЗ 300')]/preceding-sibling::span[1]/a";
	private String kartochki_uz_400 = ".//div/span[contains(.,'Карточки УЗ 400')]/preceding-sibling::span[1]/a";
	private String status = ".//div/span[contains(.,'По статусам')]/preceding-sibling::span[1]/a";
	private String my_doc = ".//div/span[contains(.,'Мои документы')]/preceding-sibling::span[1]/a";
	private String soglasovanie = ".//div/span/a[contains(.,'Карточки закупки на согласовании')]";
	private String utverjdenie = ".//div/span/a[contains(.,'Карточки закупки на утверждении')]";
	
  public FormsTab(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void clickForms(){
	  Logger.info("Нажать на вкладку 'Формуляры'");
	  WebElement formular_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(formular))); 
	  formular_el.click();
  }
  
  public void checkFormsIsActive(){
	  Logger.info("Проверить вкладка 'Формуляры' выбрана");
	  Boolean flag = false;
	  int i = 0;
	  while(flag==false){
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }

		  WebElement formular_el = (new WebDriverWait(driver, 60))
				  .until(ExpectedConditions.elementToBeClickable(By.xpath(formular))); 
		  flag = formular_el.getAttribute("class").contains("Selected");
		  if(flag==false){
			  driver.navigate().refresh();
			  i++;
			  try {
			       Thread.sleep(6000);
			     } catch( InterruptedException ex ) {
			     }
			  clickForms();
		  }
		  if(i>3){
			  break;
		  }
	  }
	  Assert.assertTrue(flag);
  }

  public void openUpravlenieZakupkami(){
	  Logger.info("Раскрыть в дереве пункт 'Управление закупками'");
	  WebElement upravlenie_zakupkami_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(upravlenie_zakupkami)));
	  String state = upravlenie_zakupkami_el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  upravlenie_zakupkami_el.click();
	  }
	  
  }
  public void openPlanirovanie(){
	  Logger.info("Раскрыть в дереве пункт 'Планирование'");
	  WebElement planirovanie_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(planirovanie)));
	  String state = planirovanie_el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  planirovanie_el.click();
	  }
  }
  public void openFormirovanieOBAS(){
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  Logger.info("Раскрыть в дереве пункт 'Формирование ОБАС'");
	  WebElement formirovanieOBAS_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(formirovanieOBAS)));
	  String state = formirovanieOBAS_el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  formirovanieOBAS_el.click();
	  }
  }
  public void openKartochkiUZ(){
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  Logger.info("Раскрыть в дереве пункт 'Карточки укрупненных закупок'");
	  WebElement kartochki_uz_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(kartochki_uz)));
	  String state = kartochki_uz_el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  kartochki_uz_el.click();
	  }

  }
 
  public void clickUZ_200(){
	  Logger.info("Нажать в дереве пункт 'Карточки укрупненных закупок - 200'");
	  WebElement uz_200_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(uz_200)));
	  uz_200_el.click();
  }  
  public void clickUZ_300(){
	  Logger.info("Нажать в дереве пункт 'Карточки укрупненных закупок - 300'");
	  WebElement uz_300_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(uz_300)));
	  uz_300_el.click();
  }
  public void clickUZ_400(){
	  Logger.info("Нажать в дереве пункт 'Карточки укрупненных закупок - 400'");
	  WebElement uz_400_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(uz_400)));
	  uz_400_el.click();
  }
  public void openKartochkiUZ200(){
	  Logger.info("Раскрыть в дереве пункт 'Карточки УЗ 200'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kartochki_uz_200)));
	  String state = el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  el.click();
	  }
  }
  public void openKartochkiUZ300(){
	  Logger.info("Раскрыть в дереве пункт 'Карточки УЗ 300'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kartochki_uz_300)));
	  String state = el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  el.click();
	  }
  } 
  public void openKartochkiUZ400(){
	  Logger.info("Раскрыть в дереве пункт 'Карточки УЗ 400'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kartochki_uz_400)));
	  String state = el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  el.click();
	  }
  }
  public void openPoStatusam(){
	  Logger.info("Раскрыть в дереве пункт 'По статусам'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(status)));
	  String state = el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  el.click();
	  }
  }
  public void openMyDocuments(){
	  Logger.info("Раскрыть в дереве пункт 'Мои документы'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(my_doc)));
	  String state = el.getAttribute("title");
	  if(state.contains("Развернуть")){
		  el.click();
	  }
  }
  public void clickSoglasovanie(){
	  Logger.info("Нажать в дереве пункт 'Карточки закупки на согласовании'");
	  WebElement uz_200_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(soglasovanie)));
	  uz_200_el.click();
  } 
  public void clickUtverjdenie(){
	  Logger.info("Нажать в дереве пункт 'Карточки закупки на согласовании'");
	  WebElement uz_200_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(utverjdenie)));
	  uz_200_el.click();
  }   
}
