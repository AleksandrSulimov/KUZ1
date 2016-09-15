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
	//�������
	private String filterList = ".//div[1]/table/tbody/tr[2]/th/div//span/a";
	private String filterListElement = "(.//div/ul[li/span[2]]/li[1])[1]";
	private String filterInput = ".//div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/input";
	private String filterDate = ".//div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/input";
	private String filterInputName =".//div[1]/table/tbody/tr[2]/th[position() = (count(//th[contains(.,'�����')]/preceding-sibling::*)+1)]/div/table/tbody/tr/td/table/tbody/tr/td[3]/input";//(.//div[1]/table/tbody/tr[2]/th/div/table/tbody/tr/td/table/tbody/tr/td[3]/input)[2]
//	private String statusTable = ".//th/div[contains(.,'������')]";
//	private String filterVisible = ".//div[1]/table/tbody/tr[1]/th[1]/div/table/tbody/tr/td/table/tbody/tr/td/img";
	private String filterVisible = ".//img[@title='��������� ��������']";
	private String table_number = ".//div[3]/table/tbody/tr[1]/td[position() = (count(//th[contains(.,'�����')]/preceding-sibling::*)+1)]/div"; //[6]
	private String table_status = ".//div[3]/table/tbody/tr[1]/td[position() = (count(//th[contains(.,'������')]/preceding-sibling::*)+1)]/div";
	private String table_checkbox_frst_row = ".//div[3]/table/tbody/tr[1]/td[1]/div/span";
	
	private String addDocument = ".//img[contains(@src,'document_new.png')]/..";//".//button[contains(@title,'������� ����� ��������')][img[contains(@src,'document_new.png')]]";
	private String na_soglasovanie = ".//img[contains(@src,'ico_dollar.png')]/..";
	private String soglasovat_zakupku = ".//button[@title='����������� �������']";
	private String utverdit = ".//button[@title='���������']";
	private String refresh = ".//button[@title='�������� ������ ����������']";
	//Tabs
	private String osnovnyeSvedenijaTab = ".//li/a[contains(.,'�������� ��������')]";
	private String harakteristikaFinansovogoObespechenijaTab = ".//li/a[contains(.,'�������������� ����������� �����������')]|.//ul[li/a[contains(.,'�������� ��������')]]/li[2]/a";
	private String listSoglasovanijaTab = ".//li/a[contains(.,'���� ������������')]";
	//��������� ���������
	private String saveChange = ".//tr[td/button[contains(@title,'��������� ���������')]]/td[5]/button";
	//������� �������� ��
	private String closeUz = "(.//div[button[contains(@title,'�������� ����������� �������')]]|.//div[button[contains(@title,'�������� ������� �� ������������')]]|.//div[button[contains(@title,'�������� ������� �� �����������')]])/a[contains(@title,'�������')]";
	//������� ����
	//private String closeWindow = ".//button[contains(.,'������� ����')]";
	private String closeWindow = ".//tr[td/button[contains(@title,'������� ����')]]/td[7]/button";

  public UZ200Page(WebDriver webDriver) {
    super(webDriver);
    driver.switchTo().frame(1);
  }
  public void waitPageLoad(){
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(refresh)));
  }
//����� ��������
  public void newDocument(){
	  Logger.info("������ ������ '������� ����� ��������'");
	  WebElement addDocument_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(addDocument)));
	  addDocument_el.click();
  }
  
  //�� ������������
  public void clickSoglasovanie(){
	  Logger.info("������ ������ '��������� �� ������������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(na_soglasovanie)));
	  el.click();
  }
  //����������� �������
  public void clickSoglasovatZakupku(){
	  Logger.info("������ ������ '����������� �������'");
	 
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(soglasovat_zakupku)));
	  el.click();
  }
  //���������
  public void clickUtverdit(){
	  Logger.info("������ ������ '���������'"); 
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(utverdit)));
	  el.click();
  }
  //��������� ���������
  public void saveChange(){
	  Logger.info("������ ������ '��������� ���������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(saveChange)));
	  el.click();
  }
//�������  ��
  public void closeUZ(){
	  Logger.info("������� ������� �������� ��");
	  driver.switchTo().defaultContent();
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(closeUz)));
	  el.click();
  }
  public void closeWindow(){
	  Logger.info("������� �������� ��");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(closeWindow)));
	  el.click();
  }
 //�������
  public void goToTabOsnovnyeSvedenija(){
	  Logger.info("������� �� ������� '����� ���������� � �������'");
	  WebElement osnovnyeSvedenijaTab_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(osnovnyeSvedenijaTab)));
	  osnovnyeSvedenijaTab_el.click();
  }
  
  public void goToTabHarakteristikaFinansovogoObespechenija(){
	  Logger.info("������� �� ������� '�������������� ����������� �����������'");
	  WebElement  harakteristikaFinansovogoObespechenija_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath( harakteristikaFinansovogoObespechenijaTab)));
	  harakteristikaFinansovogoObespechenija_el.click();
  }  
  
  public void goToTabListSoglasovanija(){
	  Logger.info("������� �� ������� '���� ������������'");
	  WebElement  listSoglasovanija_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath( listSoglasovanijaTab)));
	  listSoglasovanija_el.click();
  } 
  
  public void clearFilter(){
	  Logger.info("������� ������� � ������� �������� ��");
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
	  Logger.info("��������� ���� '"+name+"' ������� � ������� �������� �� ��������� '"+val+"' � ��������� ������");
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
	  WebElement filter = driver.findElement(By.xpath(filterVisible));
	  if(filter.getAttribute("src").contains("filter_on")){
		  filter.click();
	  }
	  String filterName = null;
	  if(name.equalsIgnoreCase("�����")){
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
	  Logger.info("������� ������� '"+name+"' � ������� �������� ��");
	  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
	  WebElement filter = driver.findElement(By.xpath(filterVisible));
	  if(filter.getAttribute("src").contains("filter_on")){
		  filter.click();
	  }
	  String filterName = null;
	  if(name.equalsIgnoreCase("�����")){
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
	  Logger.info("��������� ���� '�����'");
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
	  Logger.info("��������� ���� '������'");
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
	  Logger.info("������� ������� ������ ������");
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
	  	Logger.info("��������� �������� ��������� � ��������� �����");
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("�����", docNumber);
	    assertNumber(docNumber);
	    clearFilter("�����");
  }
  
  public void otpravitNaSoglasovanie(String docNumber){
	  	Logger.info("��������� �������� �� ������������");
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("�����", docNumber);
	    assertNumber(docNumber);
	    selectFirstRow();
	    clickSoglasovanie();
	    clearFilter("�����");
  }
  public void soglasovatZakupku(String docNumber){
	  	driver.switchTo().frame(1);
	  	Logger.info("������������ �������");
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("�����", docNumber);
	    //assertNumber(docNumber);
	    selectFirstRow();
	    clickSoglasovatZakupku();
	    SoglasovatZakupkuPopUp popup = new SoglasovatZakupkuPopUp(driver);
	    popup.clickSoglasovat();
	    popup.clickOk();
	    clearFilter("�����");
  }
  public void utverjdenieZakupku(String docNumber){
	  	Logger.info("����������� �������");
	  	driver.switchTo().frame(1);
	  	waitPageLoad();
	  	clearFilter();
	    setFilter("�����", docNumber);
	    //assertNumber(docNumber);
	    selectFirstRow();
	    clickUtverdit();
	    UtverditPopUp popup = new UtverditPopUp(driver);
	    popup.clickUtverdit();
	    popup.clickOk();
	    clearFilter("�����");
	    
  }

}
