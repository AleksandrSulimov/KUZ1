package uz;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import ru.stqa.selenium.factory.WebDriverFactory;
import uz.util.Logger;
import uz.util.PropertyLoader;

/**
 * Base class for all the JUnit-based test classes
 */
public abstract class JUnitTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;
  public static int waitTimeOut = 60;
  protected Logger log = Logger.getInstance();
  private static boolean HasWarn = false;


  protected WebDriver driver;

  @ClassRule
  public static ExternalResource webDriverProperties = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
      baseUrl = PropertyLoader.loadProperty("site.url");
      gridHubUrl = PropertyLoader.loadProperty("grid.url");
      if ("".equals(gridHubUrl)) {
        gridHubUrl = null;
      }
      capabilities = PropertyLoader.loadCapabilities();
    };
  };

  @Rule
  public ExternalResource webDriver = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
      driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      driver.manage().window().maximize();
    };
  };
  
  	/**
	 * To override
	 */
	public abstract void runTest();
  
  	/**
	 * Test
	 * @throws Throwable Throwable
	 */
	@Test
	public void xTest() throws Throwable {
		try {
			HasWarn = false;
			log.logTestName(this.getClass().getName());
			runTest();
			log.logTestEnd(this.getClass().getName());
		} catch (Throwable e) {
			log.warn("");
				log.fatal("Test failed: "/* + e.getMessage() + "\r\nStackTrace: " */+ getStackTrace(e)	);
				log.warn("");
		} finally {
			makeScreen(this.getClass());
		}
	}
	
	public static String getStackTrace(Throwable t) {
	    StringWriter sw = new StringWriter();
	    t.printStackTrace(new PrintWriter(sw));
	    return sw.toString();
	}
    
  @After
  public void tearDown() throws Exception {  
//	  makeScreen(this.getClass());
	  driver.quit();  
//	  try {
//			log.logTestEnd(this.getClass().getName());
//		} catch (Exception e) {
//		}
  } 
  
	private void makeFullSizeScreen(String path, String name){
		log.info("Путь: " + path);
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		try{
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "png", new File(path+"/fullscreenshots/FullScreen_"+name));
		}catch(IOException e){
			log.debug(e.getMessage());
		}catch(AWTException e){
			log.debug(e.getMessage());
		}
	}
  
	/**
	 * screenshot
	 */
	protected void makeScreen(Class name) {
			String fileName = name.getPackage().getName()+ "." + name.getSimpleName();
			String screenShot = "";
			File copyFile = new File(String.format(
					"surefire-reports\\html\\Screenshots/%1$s.png",fileName));
			try{
				makeFullSizeScreen(copyFile.getParentFile().getCanonicalPath(), fileName+".png");
			}catch(IOException e){
				log.warn("Failed to save fullscreenshot");
			}

			try {
				File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File(String.format(
						"surefire-reports\\html\\Screenshots/%1$s.png",fileName)));
			} catch (Exception e) {
				log.warn("Failed to save screenshot");
			}
			log.printDots(30);
	}
}
