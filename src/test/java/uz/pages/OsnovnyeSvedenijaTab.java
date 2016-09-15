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
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.base.Browser;
import uz.util.Logger;

/**
 * �������� �������� - �������
 */
public class OsnovnyeSvedenijaTab extends Page {
	//��������� ������ � �������, ���� ����� ����������
	//private String statusTable = ".//th/div[contains(.,'������')]";
	private String addDocument = ".//img[contains(@src,'document_new.png')]/..";//".//button[contains(@title,'������� ����� ��������')][img[contains(@src,'document_new.png')]]";
	//Tabs
	private String osnovnyeSvedenijaTab = ".//li/a[contains(.,'�������� ��������')]";
	private String harakteristikaFinansovogoObespechenijaTab = ".//li/a[contains(.,'�������������� ����������� �����������')]";
	private String listSoglasovanijaTab = ".//li/a[contains(.,'���� ������������')]";
	//����� ���������� � �������
	private String status = ".//tr/td/div/span[contains(.,'������')]/../../../td[2]/div/input";
	private String number = ".//tr/td/div/span[contains(.,'������')]/../../../td[4]/div/input";
	private String date_field = ".//tr/td/div/span[contains(.,'������')]/../../../td/div/span/input";//td[9]
	private String typeObject_list = ".//tr/td/div/span[contains(.,'��� �������')]/../../../td[2]/div/span/a";
	private String vkluchenFaip = ".//ul/li/span[contains(.,'01')]";
	private String neVkluchenFaip = ".//ul/li/span[contains(.,'03')]";
	private String predpologaetsaFaip = ".//ul/li/span[contains(.,'02')]";
	private String faipNEWSpravochnikButton = ".//tr[td/div/span[contains(.,'������������ ������� ������������ �������������,�����������, ������� ����������� ��������� *')]]/../tr[2]/td[2]/div/button[1]";
	private String faipSpravochnikButton = ".//tr[td/div/span[contains(.,'������������ ������� ������������ �������������,�����������, ������� ����������� ��������� *')]]/../tr[2]/td[2]/div/button[2]";
	private String nameObject = ".//tr[td/div/span[contains(.,'������������ ������� ������������ �������������,�����������, ������� ����������� ��������� *')]]/../tr[2]/td/div/input";
	private String napravlenieInvestirovanija = ".//tr/td/div/span[contains(.,'����������� ��������������')]/../../../td[2]/div/input";
	private String kodUchetnojEdinicy = ".//tr/td/div/span[contains(.,'��� ������� �������')]/../../../td[2]/div/input";
	private String edinicaIzmerenijaSpravochnikButton = ".//tr[td/div/span[contains(.,'������� ���������')]]/../tr/td[3]/div/button";
	private String moshnost = ".//tr/td/div/span[contains(.,'��������')]/../../../td[2]/div/input";
	private String okvedButton = ".//tr[td/div/span[contains(.,'�����')]]/../tr/td[3]/div/button";
	private String razdelFaip = ".//tr/td/div/span[contains(.,'������ ����')]/../../../td[2]/div/input";
	private String fcpButton = ".//tr[td/div/span[contains(.,'����������� ������� ���������')]]/../tr/td[3]/div/button";
	private String otrasl = ".//tr/td/div/span[contains(.,'�������')]/../../../td[2]/div/input";
	private String gruppaMeroprijatij = ".//tr/td/div/span[contains(.,'������ �����������')]/../../../td[2]/div/input";
	private String groupObjectFaip = ".//tr/td/div/span[contains(.,'������ �������� ����')]/../../../td[2]/div/input";
	private String zastrojshhik = ".//tr/td/div/span[contains(.,'����������')]/../../../td[2]/div/input";
	private String gosudarstvennyjZakazchik  = ".//tr/td/div/span[contains(.,'��������������� ��������')]/../../../td[2]/div/input";
	
	//�������� � ����������� ��������������� ���������
	private String zakazchik = ".//tr/td/div/span[contains(.,'��������')]/../../../td[2]/dov/textarea";//getText
	private String inn = ".//tr/td/div/span[contains(.,'���')]/../../../td[2]/div/input";
	private String kpp = ".//tr/td/div/span[contains(.,'���')]/../../../td[5]/div/input";
	private String ogrn = ".//tr/td/div/span[contains(.,'���')]/../../../td[8]/div/input";
	//�������� � �������� ������������ ���������������� ���������
	private String naimenovanieObectaZakupki = ".//tr/td/div/span[contains(.,'������������ ������� �������')]/../../../td[2]/div/input";
	private String okpd = ".//tr/td/div/span[contains(.,'���� *')]/../../../td[2]/div/input";
	private String okpdButton = ".//tr/td/div/span[contains(.,'����')]/../../../td[3]/div/button"; //'���� *'
	private String periodicityButton = ".//tr/td/div/span[contains(.,'������������� ������������� �������')]/../../../td[6]/div/button|.//tr/td/div/span[contains(.,'������������� ������������� ����������� �������')]/../../../td[6]/div/button";
	private String npoButton = ".//tr/td/div/span[contains(.,'������������ ���������� ������������� *')]/../../../td[3]/div/button";
	private String naimenovanieKodaTovara = ".//tr/td/div/span[contains(.,'������������ ���� ������')]/../../../td[2]/div/textarea";	
	private String opisanieZakupki = ".//tr/td/div/span[contains(.,'�������� �������')]/../../../../../../../../../following-sibling::tr[1]/td/div/textarea";
	private String srokOsushhestvlenijaZakupki = ".//tr/td/div/span[contains(.,'���� ������������� ����������� �������')]/../../../td[2]/div/span/input|.//tr/td/div/span[contains(.,'���� ������������� �������')]/../../../td[2]/div/span/input|.//tr/td/div/span[contains(.,'����� ������������� ����������� �������')]/../../../td[2]/div/span/input|.//tr/td/div/span[contains(.,'����� ������������� �������')]/../../../td[2]/div/span/input"; 
//	private String periodichnostOsushhestvlenijaZakupkiButton = ".//tr/td/div/span[contains(.,'������������� ������������� �������')]/../../../td[5]/div/span/a|.//tr/td/div/span[contains(.,'������������� ������������� ����������� �������')]/../../../td[5]/div/span/a";
//	private String periodichnostOsushhestvlenijaZakupkiButton = ".//tr/td/div/span[contains(.,'������������� ������������� �������')]/../../../td[6]/div/button|.//tr/td/div/span[contains(.,'������������� ������������� ����������� �������')]/../../../td[6]/div/button";
	private String kUkazannomuSroku = ".//ul/li/span[contains(.,'����������')]";	
	private String obosnovanieZakupki = ".//tr/td/div/span[contains(.,'����������� �������')]/../../../../../../../../../following-sibling::tr[1]/td/div/textarea";
	private String addAttachment = ".//button[contains(@title,'�������� ��������')]";
	private String uploadFile = ".//*[@id='fileupload']";
	private String uploadProgress =".//*[@id='progress']/div";
	private String uploadSave = ".//div/button[contains(.,'�������')]/preceding-sibling::button[contains(.,'���������')]";
	private String celOsushhestvlenijaZakupki = ".//tr/td/div/span[contains(.,'���� ������������� �������')]/../../../../../../../../../following-sibling::tr[1]/td/div/textarea";

  public OsnovnyeSvedenijaTab(WebDriver webDriver) {
    super(webDriver);
    //driver.switchTo().frame(1);
  }
  
//����� ��������
  public void newDocument(){
	  WebElement addDocument_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(addDocument)));
	  addDocument_el.click();
  }
 //�������
  public void goToTabOsnovnyeSvedenija(){
	  WebElement osnovnyeSvedenijaTab_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(osnovnyeSvedenijaTab)));
	  osnovnyeSvedenijaTab_el.click();
  }
  
  public void goToTabHarakteristikaFinansovogoObespechenija(){
	  WebElement  harakteristikaFinansovogoObespechenija_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath( harakteristikaFinansovogoObespechenijaTab)));
	  harakteristikaFinansovogoObespechenija_el.click();
  }  
  
  public void goToTabListSoglasovanija(){
	  WebElement  listSoglasovanija_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath( listSoglasovanijaTab)));
	  listSoglasovanija_el.click();
  } 
//����� ���������� � �������
  public String getStatus(){
	  WebElement status_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(status)));
	  return status_el.getAttribute("value");
  }
  public void checkStatus(String val){
	  Logger.info("��������� ���� '������'");
	  Assert.assertEquals(val, getStatus());
  }
  public String getDate(){
	  WebElement date_field_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(date_field)));
	  return date_field_el.getAttribute("value");
  }
  
  public void checkDate(){
	  Logger.info("��������� ���� '����'");
	  DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	  Date date = new Date(); 
	  Assert.assertEquals(dateFormat.format(date),getDate());
  }
  public String getNumber(){
	  Logger.info("������� �������� �� ���� '�����'");
	  String value = null;
	  int i = 0;
	  WebElement number_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(number)));//presenceOfElementLocated
	  ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('disabled', '')",number_el);
	  while(value==null||value.equals("")){
		  
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
		  value = number_el.getAttribute("value");
		  if(i>=10){
			  break;
		  }
		  i++;
	  }
	  Logger.info("�������� ���� '�����' = '"+value+"'");
	  return value;
  }
  
  public void clickOkpdSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '����'");
	  WebElement  okpdButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(okpdButton)));
	  okpdButton_el.click();
  } 
  
  public void clickPeriodicitySpravochnick(){
	  Logger.info("������ ������ ������ ����������� '������������� ������������� �������'");
	  WebElement  periodicityButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(periodicityButton)));
	  periodicityButton_el.click();
  } 
  
  public void clickNpoSpravochnick(){
	  Logger.info("������ ������ ������ ����������� '������������ ���������� �������������'");
	  WebElement  okpdButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(npoButton)));
	  okpdButton_el.click();
  } 
    
  public void setOpisanieZakupki(String val){
	  Logger.info("��������� ���� '�������� �������' ��������� '"+val+"'");
	  WebElement opisanieZakupki_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(opisanieZakupki)));
	  opisanieZakupki_el.sendKeys(val);
  }
  public void setSrokOsushhestvlenijaZakupki(String val){
	  Logger.info("��������� ���� '���� ������������� �������' ��������� '"+val+"'");
	  WebElement srokOsushhestvlenijaZakupki_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(srokOsushhestvlenijaZakupki)));
	  srokOsushhestvlenijaZakupki_el.sendKeys(val);
  }
  public void setPeriodichnostOsushhestvlenijaZakupki(String val){
/*	  Logger.info("������� � ���������� ������ '������������� ������������� �������' �������� '"+val+"'");
	  WebElement periodichnostOsushhestvlenijaZakupkiButton_el = driver.findElement(By.xpath(periodichnostOsushhestvlenijaZakupkiButton)); 
			  (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(periodichnostOsushhestvlenijaZakupkiButton)));
	  periodichnostOsushhestvlenijaZakupkiButton_el.click();
//	  if(val.equals("� ���������� �����")){
//		  WebElement el = (new WebDriverWait(driver, 60))
//				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(kUkazannomuSroku)));
//		  el.click();
//	  }*/
  }

  public void setObosnovanieZakupki(String val){
	  Logger.info("��������� ���� '����������� �������' ��������� '"+val+"'");
	  WebElement obosnovanieZakupki_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(obosnovanieZakupki)));
	  obosnovanieZakupki_el.sendKeys(val);
  }
  
  public void setCelOsushhestvlenijaZakupki(String val){
	  Logger.info("��������� ���� '���� ������������� �������' ��������� '"+val+"'");
	  WebElement celOsushhestvlenijaZakupki_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(celOsushhestvlenijaZakupki)));
	  celOsushhestvlenijaZakupki_el.sendKeys(val);
  } 
  
  public void setUploadedFile(String filePath) {
      
	    File autoIt = new File("src/main/resources/upload.exe");
	 
	    try {
	        // ������ exe � ��������� ���� � ������������ ����� 
	        // � �������� ���������
	        Process p = Runtime.getRuntime().exec(
	                autoIt.getAbsolutePath() + " " + filePath);
	        // �������� ���������� �������
	        p.waitFor();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
  
  public void uploadFile(){
	  Logger.info("������ ������ '�������� ��������'");
	  WebElement addAttachment_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(addAttachment)));
	  addAttachment_el.click();
	  Logger.info("������ � ���� �������� ���������� ������ '���������'");
	  WebElement uploadFile_el = (new WebDriverWait(driver, 60))
	  		.until(ExpectedConditions.presenceOfElementLocated(By.xpath(uploadFile)));
	  if (uploadFile_el.isDisplayed()){
		  uploadFile_el.click();
	  } else {
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click()", uploadFile_el);
	  }
	  File file = new File("src/test/resources/test.txt");
	  Logger.info("��������� ���� '��� �����' � ���� '������� ����'  ��������� '"+file.getAbsolutePath()+"' � ������ ������ '��'");
	  setUploadedFile(file.getAbsolutePath());
	  try {
	       Thread.sleep(5000);
	     } catch( InterruptedException ex ) {
	     }
	  Logger.info("������ � ���� '���������� ��������' ������ '���������'");
	  WebElement uploadSave_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(uploadSave)));
	  uploadSave_el.click();
	  try {
	       Thread.sleep(2000);
	     } catch( InterruptedException ex ) {
	     }
	  
  }
  
  public void selectTypeObject(String val){
	  Logger.info("������� � ���������� ������ '��� �������' �������� '"+val+"'");
	  WebElement periodichnostOsushhestvlenijaZakupkiButton_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(typeObject_list)));
	  periodichnostOsushhestvlenijaZakupkiButton_el.click();
	  String faip = null;
	  if(val.equals("������� � ����")){
		  faip = vkluchenFaip;
	  }else if(val.equals("�� ������� � ����")){
		  faip = neVkluchenFaip;
	  }else if(val.equals("������������ � ��������� � ����")){
		  faip = predpologaetsaFaip;
	  }
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(faip)));
	  el.click();
	  
	  }
	  public void clicFaipSpravochnick(){
		  Logger.info("������ ������ ������ ����������� '������������ ������� ������������ �������������,�����������, ������� ����������� ���������'");
		  WebElement  el = (new WebDriverWait(driver, 60))
				  .until(ExpectedConditions.elementToBeClickable(By.xpath(faipSpravochnikButton)));
		  el.click();
	  } 
	  
	  public void clicFaipNEWSpravochnick(){
		  Logger.info("������ ������ ������ ����������� '������������ ������� ������������ �������������,�����������, ������� ����������� ���������'");
		  WebElement  el = (new WebDriverWait(driver, 60))
				  .until(ExpectedConditions.elementToBeClickable(By.xpath(faipNEWSpravochnikButton)));
		  el.click();
	  } 
  

  public void setNameObject(String val){
	  Logger.info("��������� ���� '������������ ������� ������������ �������������,�����������, ������� ����������� ���������' ��������� '"+val+"'");
	  WebElement nameObject_el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameObject)));
	  nameObject_el.sendKeys(val);
  }
  public void setNapravlenieInvestirovanija(String val){
	  Logger.info("��������� ���� '����������� ��������������' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(napravlenieInvestirovanija)));
	  el.sendKeys(val);
  } 
  public void setKodUchetnojEdinicy(String val){
	  Logger.info("��������� ���� '��� ������� �������' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(kodUchetnojEdinicy)));
	  el.sendKeys(val);
  }
  public void clikEdinicaIzmerenijaSpravochnik(){
	  Logger.info("������ ������ ������ ����������� '������� ���������'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(edinicaIzmerenijaSpravochnikButton)));
	  el.click();
  } 
  public void setMoshnost(String val){
	  Logger.info("��������� ���� '��������' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(moshnost)));
	  el.sendKeys(val);
  }
  public void clikOkvedSpravochnik(){
	  Logger.info("������ ������ ������ ����������� '�����'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(okvedButton)));
	  el.click();
  } 
  public void setRazdelFaip(String val){
	  Logger.info("��������� ���� '������ ����' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(razdelFaip)));
	  el.sendKeys(val);
  }
  public void clikFcpSpravochnik(){
	  Logger.info("������ ������ ������ ����������� '����������� ������� ��������� (���)'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(fcpButton)));
	  el.click();
  }
  public void setOtrasl(String val){
	  Logger.info("��������� ���� '�������' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otrasl)));
	  el.sendKeys(val);
  }
  public void setGruppaMeroprijatij(String val){
	  Logger.info("��������� ���� '������ �����������' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(gruppaMeroprijatij)));
	  el.sendKeys(val);
  }
  public void setGroupObjectFaip(String val){
	  Logger.info("��������� ���� '������ �������� ����' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(groupObjectFaip)));
	  el.sendKeys(val);
  }
  public void setZastrojshhik(String val){
	  Logger.info("��������� ���� '����������' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(zastrojshhik)));
	  el.sendKeys(val);
  }
  public void setGosudarstvennyjZakazchik(String val){
	  Logger.info("��������� ���� '��������������� ��������' ��������� '"+val+"'");
	  WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(gosudarstvennyjZakazchik)));
	  el.sendKeys(val);
  }
}
