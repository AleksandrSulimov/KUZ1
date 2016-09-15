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
	//�����
	private String tableAuthor=".//div[div/div/div/table/tbody/tr/td/table/tbody/tr/td/span[contains(.,'�����')]]";
	private String dolzhnostAuthor = tableAuthor + "//td[2]/div/input";
	private String telefonAuthor = tableAuthor + "//td[3]/div/input";
	
	//�����������
	private String addTableSoglas = ".//span[text()='��������� ������������']/ancestor::td[1]/preceding-sibling::td//span/div";
	private String tableSoglasujushhieCollapse = ".//div[div/div/div/table/tbody/tr/td/table/tbody/tr/td/span[contains(.,'�����������')]]";
	private String addRow = tableSoglasujushhieCollapse + "//button[contains(@title, '�������� ����� ������')]";
	
	private String tableSoglasujushhie = ".//div[div/table/tbody/tr/th/div/span[contains(.,'����')]]/div[3]/table/tbody[1]/tr";
	private String stage = tableSoglasujushhie + "/td[2]/div/input";
	private String codeGroup = tableSoglasujushhie + "/td[3]/div/input";
	private String numberSoglasujushhie = tableSoglasujushhie + "/td[4]/div/input";
	private String soglasujushhieSpravochnik = tableSoglasujushhie + "/td/div/button";//"/td[7]/div/button"
	
	//������������
	private String tableUtverzhdajushhij = ".//div[div/div/div/table/tbody/tr/td/table/tbody/tr/td/span[contains(.,'������������')]]";
	private String utverzhdajushhijSpravochnik = tableUtverzhdajushhij + "/div[2]/table/tbody/tr[3]/td/div/button";
	private String telefonUtverzhdajushhij = tableUtverzhdajushhij + "/div[2]/table/tbody/tr[3]/td[5]/div/input";
	

  public ListSoglasovanijaTab(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void setDolzhnostAuthor(String val){
	  Logger.info("��������� ���� '���������' � ������� '�����' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(dolzhnostAuthor)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void setTelephoneAuthor(String val){
	  Logger.info("��������� ���� '�������' � ������� '�����' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(telefonAuthor)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void addTableSoglas(){
	  Logger.info("������ ���-���� '��������� ������������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(addTableSoglas)));
	  el.click();
  }
  public void newRow(){
	  Logger.info("������ ������  '�������� ����� ������' � ������� '�����������'");
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(addRow)));
	  el.click();
  }
  public void setStage(String val){
	  Logger.info("��������� ���� '����' � ������� '�����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(stage)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void setCodeGroup(String val){
	  Logger.info("��������� ���� '��� ������' � ������� '�����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(codeGroup)));
	  el.clear();
	  el.sendKeys(val);
  }
  public void setNumberSoglasujushhego(String val){
	  Logger.info("��������� ���� '���������� ����� ������������' � ������� '�����������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(numberSoglasujushhie)));
	  el.clear();
	  el.sendKeys(val);
  }  
  public void clickSoglasujushhieSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '�����������'");
	  WebElement  kbkButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(soglasujushhieSpravochnik)));
	  kbkButton_el.click();
  } 
  public void clickUtverzhdajushhijSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '������������'");
	  WebElement  kbkButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(utverzhdajushhijSpravochnik)));
	  kbkButton_el.click();
  }  
  public void setTelephoneUtverzhdajushhego(String val){
	  Logger.info("��������� ���� '�������' � ������� '������������' ��������� '"+val+"'");
	  WebElement  el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(telefonUtverzhdajushhij)));
	  el.clear();
	  el.sendKeys(val);
  }

}
