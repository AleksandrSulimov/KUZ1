package uz;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

@RunWith(Suite.class)
@SuiteClasses({
	KUZ_200_RUR_1.class,
	KUZ_200_RUR_2.class,
	KUZ_200_RUR_3.class,
	KUZ_200_RUR_4.class,
	KUZ_200_CUR_1.class,
	KUZ_300_1.class,
	KUZ_300_2.class,
	KUZ_400_FAIP_1.class,
	KUZ_400_FAIP_2.class,
	KUZ_400_NO_FAIP_1.class,
	KUZ_400_PORPOSE_FAIP_1.class})
public class JUnitTestSuite {

  @Rule
  public ExternalResource webDriverFactory = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    };

    @Override
    protected void after() {
      WebDriverFactory.dismissAll();
    };
  };
}
