package uz.popup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.pages.Page;
import uz.util.Logger;

public class SoglasovatZakupkuPopUp extends Page {
	
	private String popup = ".//div[contains(.,'Согласовать закупку')]";
	private String buttonSoglasovat = ".//div[contains(.,'Согласовать закупку')]/descendant-or-self::*/button[contains(.,'Согласовать')]";
	private String buttonOk = ".//div[contains(.,'Согласовать закупку')]/descendant-or-self::*/button[contains(.,'ОК')]";

	public SoglasovatZakupkuPopUp(WebDriver driver) {
		super(driver);
	}
	
	public void waitPopUp(){
		Logger.info("Ожидаем появления Pop-Up 'Согласовать закупку'");
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popup)));
	}
	public void clickOk(){
		waitPopUp();
		Logger.info("Нажать кнопку 'ОК' в Pop-Up окне");
		WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(buttonOk)));
		el.click();
	}
	public void clickSoglasovat(){
		waitPopUp();
		Logger.info("Нажать кнопку 'Согласовать' в Pop-Up окне");
		WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(buttonSoglasovat)));
		el.click();
		try {
		       Thread.sleep(7000);
		     } catch( InterruptedException ex ) {
		     }
	}

}
