package uz.spravochnik;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.pages.Page;
import uz.util.Logger;

public class Periodicity extends Page {
	private String window = "//div[contains(.,'������������� ������������� �������')]/following-sibling::div";
	//������ //div[contains(.,'������������� ������������� �������')]/following-sibling::div
	private String table_loc = window + "//th[contains(.,'�������������')]/../../../../..";
	
	//��� ������� � ��������� ����� � �����
	private String filterInput = table_loc + "//div[contains(@class, 'fakepaging-header')]//th//input[contains(@class, 'textbox') or contains(@class, 'datebox')]";
	
	private String filterVisible = table_loc + "//img[@title='��������� ��������']";
	
	private String rows_loc = table_loc + "/div[3]/table/tbody[not(contains(@class,'emptybody'))]/tr";
	
	private String navigation_loc = table_loc + "/../../../../div[3]/div[1]/div/div/div/div/div";
	private String navigationNext_loc = navigation_loc + "/div[6]/div/button";
	private String navigationCurPage_loc = navigation_loc + "/div[3]/input";//@value
	private String navigationMaxPage_loc = navigation_loc + "/div[5]/span";//text
	
	private String buttonOk = ".//div/button[contains(.,'������')]/preceding-sibling::button[contains(.,'OK')]";

	public Periodicity(WebDriver driver) {
		super(driver);
	}

	public void select(String val){
		clearFilter();
		
		Logger.info("������� � ����������� �������� '"+val+"'");
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
					row.findElement(By.xpath(".//td[2]/div")).click();//".//td[1]/div/span"
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
	
	public void clearFilter(){
		  Logger.info("������� ������� � �����������");
		  WebElement row = null;
		  String val = null;
		  Boolean flag = false;
		  WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterVisible)));
		  WebElement filter = driver.findElement(By.xpath(filterVisible));
		  String scr = filter.getAttribute("src");
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
	
	public void navigationNext(){
		  WebDriverWait wait = new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(navigationNext_loc)));
		  driver.findElement(By.xpath(navigationNext_loc)).click();
	  }
	
	public void clickOk(){
		  Logger.info("������ � ����������� ������ '��'");
		  WebDriverWait wait = new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonOk)));
		  driver.findElement(By.xpath(buttonOk)).click();
		  try {
		       Thread.sleep(2000);
		     } catch( InterruptedException ex ) {
		     }
	  }
}
