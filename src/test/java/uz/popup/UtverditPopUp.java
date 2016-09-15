package uz.popup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uz.pages.Page;
import uz.util.Logger;

public class UtverditPopUp extends Page {
	
	private String popup = ".//div[contains(.,'Утвердить')]";
	private String buttonUtverdit = ".//div[contains(.,'Утвердить')]/descendant-or-self::*/button[contains(.,'Утвердить')]";
	private String buttonOk = ".//div[contains(.,'Утвердить')]/descendant-or-self::*/button[contains(.,'ОК')]";

	public UtverditPopUp(WebDriver driver) {
		super(driver);
	}
	
	public void waitPopUp(){
		Logger.info("Ожидаем появления Pop-Up 'Утвердить'");
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popup)));
	}
	public void clickOk(){
		waitPopUp();
		Logger.info("Нажать кнопку 'ОК' в Pop-Up окне");
		WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(buttonOk)));
		el.click();
	}
	public void clickUtverdit(){
		waitPopUp();
		Logger.info("Нажать кнопку 'Утвердить' в Pop-Up окне");
		WebElement el = (new WebDriverWait(driver, 60))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(buttonUtverdit)));
		el.click();
		try {
		       Thread.sleep(7000);
		     } catch( InterruptedException ex ) {
		     }
	}

}
