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

	private String formular = ".//div/a[contains(.,'���������')]";
	private String upravlenie_zakupkami = ".//div/span[contains(.,'���������� ���������')]/preceding-sibling::span[1]/a";
	private String planirovanie = ".//span[text()='������������']/ancestor::span/preceding-sibling::span/a";
	private String formirovanieOBAS = ".//div/span[contains(.,'������������ ����')]/preceding-sibling::span[1]/a";
	private String kartochki_uz = ".//div/span[contains(.,'�������� ����������� �������')]/preceding-sibling::span[1]/a";
	private String uz_200 = ".//div/span/a[contains(.,'�������� ����������� ������� - 200')]";
	private String uz_300 = ".//div/span/a[contains(.,'�������� ����������� ������� - 300')]";
	private String uz_400 = ".//div/span/a[contains(.,'�������� ����������� ������� - 400')]";
	private String kartochki_uz_200 = ".//div/span[contains(.,'�������� �� 200')]/preceding-sibling::span[1]/a";
	private String kartochki_uz_300 = ".//div/span[contains(.,'�������� �� 300')]/preceding-sibling::span[1]/a";
	private String kartochki_uz_400 = ".//div/span[contains(.,'�������� �� 400')]/preceding-sibling::span[1]/a";
	private String status = ".//div/span[contains(.,'�� ��������')]/preceding-sibling::span[1]/a";
	private String my_doc = ".//div/span[contains(.,'��� ���������')]/preceding-sibling::span[1]/a";
	private String soglasovanie = ".//div/span/a[contains(.,'�������� ������� �� ������������')]";
	private String utverjdenie = ".//div/span/a[contains(.,'�������� ������� �� �����������')]";
	
  public FormsTab(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void clickForms(){
	  Logger.info("������ �� ������� '���������'");
	  WebElement formular_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(formular))); 
	  formular_el.click();
  }
  
  public void checkFormsIsActive(){
	  Logger.info("��������� ������� '���������' �������");
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
	  Logger.info("�������� � ������ ����� '���������� ���������'");
	  WebElement upravlenie_zakupkami_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(upravlenie_zakupkami)));
	  String state = upravlenie_zakupkami_el.getAttribute("title");
	  if(state.contains("����������")){
		  upravlenie_zakupkami_el.click();
	  }
	  
  }
  public void openPlanirovanie(){
	  Logger.info("�������� � ������ ����� '������������'");
	  WebElement planirovanie_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(planirovanie)));
	  String state = planirovanie_el.getAttribute("title");
	  if(state.contains("����������")){
		  planirovanie_el.click();
	  }
  }
  public void openFormirovanieOBAS(){
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  Logger.info("�������� � ������ ����� '������������ ����'");
	  WebElement formirovanieOBAS_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(formirovanieOBAS)));
	  String state = formirovanieOBAS_el.getAttribute("title");
	  if(state.contains("����������")){
		  formirovanieOBAS_el.click();
	  }
  }
  public void openKartochkiUZ(){
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  Logger.info("�������� � ������ ����� '�������� ����������� �������'");
	  WebElement kartochki_uz_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(kartochki_uz)));
	  String state = kartochki_uz_el.getAttribute("title");
	  if(state.contains("����������")){
		  kartochki_uz_el.click();
	  }

  }
 
  public void clickUZ_200(){
	  Logger.info("������ � ������ ����� '�������� ����������� ������� - 200'");
	  WebElement uz_200_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(uz_200)));
	  uz_200_el.click();
  }  
  public void clickUZ_300(){
	  Logger.info("������ � ������ ����� '�������� ����������� ������� - 300'");
	  WebElement uz_300_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(uz_300)));
	  uz_300_el.click();
  }
  public void clickUZ_400(){
	  Logger.info("������ � ������ ����� '�������� ����������� ������� - 400'");
	  WebElement uz_400_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(uz_400)));
	  uz_400_el.click();
  }
  public void openKartochkiUZ200(){
	  Logger.info("�������� � ������ ����� '�������� �� 200'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kartochki_uz_200)));
	  String state = el.getAttribute("title");
	  if(state.contains("����������")){
		  el.click();
	  }
  }
  public void openKartochkiUZ300(){
	  Logger.info("�������� � ������ ����� '�������� �� 300'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kartochki_uz_300)));
	  String state = el.getAttribute("title");
	  if(state.contains("����������")){
		  el.click();
	  }
  } 
  public void openKartochkiUZ400(){
	  Logger.info("�������� � ������ ����� '�������� �� 400'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kartochki_uz_400)));
	  String state = el.getAttribute("title");
	  if(state.contains("����������")){
		  el.click();
	  }
  }
  public void openPoStatusam(){
	  Logger.info("�������� � ������ ����� '�� ��������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(status)));
	  String state = el.getAttribute("title");
	  if(state.contains("����������")){
		  el.click();
	  }
  }
  public void openMyDocuments(){
	  Logger.info("�������� � ������ ����� '��� ���������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(my_doc)));
	  String state = el.getAttribute("title");
	  if(state.contains("����������")){
		  el.click();
	  }
  }
  public void clickSoglasovanie(){
	  Logger.info("������ � ������ ����� '�������� ������� �� ������������'");
	  WebElement uz_200_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(soglasovanie)));
	  uz_200_el.click();
  } 
  public void clickUtverjdenie(){
	  Logger.info("������ � ������ ����� '�������� ������� �� ������������'");
	  WebElement uz_200_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(utverjdenie)));
	  uz_200_el.click();
  }   
}
