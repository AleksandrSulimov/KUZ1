package uz.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

import uz.util.Logger;

/**
 * Sample page
 */
public class HarakteristikaFinansovogoObespechenijaTab extends Page {
	//������� ����������� �������� ����������� ������� �������������� ������ � ���� ��������������� �������
	private String currencyCheckBox = ".//span[contains(.,'������� ����������� �������� ����������� ������� �������������� ������ � ���� ��������������� �������')]/div";
	//����� ����������� ����������� �� ������������� �������
	private String tableSoglasujushhieCollapse = "(.//div[div/div/div/table/tbody/tr/td/table/tbody/tr/td/span[contains(.,'����� ����������� �����������')]])[1]";//����� ����������� ����������� �� ������������� �������
	private String addRow = "//td/button[contains(@title,'�������� ����� ������')]";
	private String addRowCur = "(//td/button[contains(@title,'�������� ����� ������')])[2]";
	private String volTable = ".//th/div/span[contains(.,'�����')]/../../../../../../../div[3]/table/tbody[1]/tr";
	private String plannedYearList = volTable + "/td[2]/div/span/input";
	private String item2016 = ".//ul/li/span[contains(.,'2016')]";
	private String kbkButton = volTable + "/td[12]/div/button";
	private String kosguButton = volTable + "/td[15]/div/button";
	private String currencyButton = volTable + "/td[21]/div/button";
	private String dopPriznakButton = volTable + "/td[18]/div/button";
	private String predlozhenie2015 = volTable + "/td[20]/div/input";
	private String predlozhenie2016 = volTable + "/td[23]/div/input";//200,300 [23]|400 [20] ///td[24]/div/input
	private String predlozhenie2017 = volTable + "/td[26]/div/input";//200 [26]|[23]///td[27]/div/input
	private String predlozhenie2018 = volTable + "/td[29]/div/input";//200 [29]|[26]///td[30]/div/input
	private String predlozhenie2015Cur = volTable + "/td[23]/div/input";
	private String predlozhenie2016Cur = volTable + "/td[29]/div/input";
	private String predlozhenie2017Cur = volTable + "/td[34]/div/input";
	private String predlozhenie2018Cur = volTable + "/td[39]/div/input";

	
  public HarakteristikaFinansovogoObespechenijaTab(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void selectCurrencyCheckBox(){
	  
	  Logger.info("������� checkbox '������� ����������� �������� ����������� ������� �������������� ������ � ���� ��������������� �������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(currencyCheckBox)));
	  el.click();
  }
  
//����� ��������
  public void newRow(){
	  Logger.info("������ ������  '�������� ����� ������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tableSoglasujushhieCollapse)));
	  el.findElement(By.xpath(addRow)).click();
  }
  public void newRowForCurrency(){
	  Logger.info("������ ������  '�������� ����� ������'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(addRowCur)));
	  el.findElement(By.xpath(addRowCur)).click();
  }

  public void setPlaniruemyjGod(String val){
	  Logger.info("��������� ���� '����������� ��� ���������� ���������' ��������� '"+val+"'");
	  WebElement plannedYearList_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(plannedYearList)));
	  plannedYearList_el.click();
	  if(val.equals("2016")){
		  WebElement el = (new WebDriverWait(driver, 60))
				  .until(ExpectedConditions.elementToBeClickable(By.xpath(item2016)));
		  el.click();
	  }
	  
  }
  public void clickKbkSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '���'");
	  WebElement  kbkButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kbkButton)));
	  kbkButton_el.click();
  } 
  public void clickKosguSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '�����'");
	  WebElement  kosguButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(kosguButton)));
	  kosguButton_el.click();
  } 
  public void clickPriznakSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '�������������� ������������� �������'");
	  WebElement  dopPriznakButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(dopPriznakButton)));
	  dopPriznakButton_el.click();
  }
  public void clickKppoSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '��������� ����������� ���������� �������������'");
	  WebElement  dopPriznakButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(dopPriznakButton)));
	  dopPriznakButton_el.click();
  }
  
  public void setPredlozhenie2015(String val){
	  Logger.info("��������� ���� '2015. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2015)));
	  el.clear();
	  el.sendKeys(val);
  }
  
  public void setPredlozhenie2016(String val){
	  Logger.info("��������� ���� '2016. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2016)));
	  el.clear();
	  el.sendKeys(val);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el1 = driver.findElement(By.xpath(predlozhenie2017));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el1);
  }
  
  public void setPredlozhenie2017(String val){
	  Logger.info("��������� ���� '2017. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2017)));
	  el.clear();
	  el.sendKeys(val);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el1 = driver.findElement(By.xpath(predlozhenie2016));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el1);
  }
  
  public void setPredlozhenie2018(String val){
	  Logger.info("��������� ���� '2018. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2018)));
	  el.clear();
	  el.sendKeys(val);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el1 = driver.findElement(By.xpath(predlozhenie2016));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el1);
  }

  public void clickCurrencySpravochnick(){
	  Logger.info("������ ������ ������ ����������� '��� ������'");
	  WebElement  currencyButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(currencyButton)));
	  currencyButton_el.click();
  }
  public void setPredlozhenie2015Valuta(String val){
	  Logger.info("��������� ���� '2015. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2015Cur)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void setPredlozhenie2016Valuta(String val){
	  Logger.info("��������� ���� '2016. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2016Cur)));
	  el.clear();
	  el.sendKeys(val);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el1 = driver.findElement(By.xpath(predlozhenie2017Cur));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el1);
  }
  
  public void setPredlozhenie2017Valuta(String val){
	  Logger.info("��������� ���� '2017. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2017Cur)));
	  el.clear();
	  el.sendKeys(val);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el1 = driver.findElement(By.xpath(predlozhenie2016Cur));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el1);
  }
  
  public void setPredlozhenie2018Valuta(String val){
	  Logger.info("��������� ���� '2018. �����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(predlozhenie2018Cur)));
	  el.clear();
	  el.sendKeys(val);
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el1 = driver.findElement(By.xpath(predlozhenie2016Cur));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el1);
  }
}
