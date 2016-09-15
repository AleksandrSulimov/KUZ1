package uz.popup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.pages.Page;
import uz.util.Logger;

public class SoglasovatZakupkuPopUp extends Page {
	
	private String popup = ".//div[contains(.,'����������� �������')]";
	private String buttonSoglasovat = ".//div[contains(.,'����������� �������')]/descendant-or-self::*/button[contains(.,'�����������')]";
	private String buttonOk = ".//div[contains(.,'����������� �������')]/descendant-or-self::*/button[contains(.,'��')]";

	public SoglasovatZakupkuPopUp(WebDriver driver) {
		super(driver);
	}
	
	public void waitPopUp(){
		Logger.info("������� ��������� Pop-Up '����������� �������'");
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popup)));
	}
	public void clickOk(){
		waitPopUp();
		Logger.info("������ ������ '��' � Pop-Up ����");
		WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(buttonOk)));
		el.click();
	}
	public void clickSoglasovat(){
		waitPopUp();
		Logger.info("������ ������ '�����������' � Pop-Up ����");
		WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(buttonSoglasovat)));
		el.click();
		try {
		       Thread.sleep(7000);
		     } catch( InterruptedException ex ) {
		     }
	}

}
