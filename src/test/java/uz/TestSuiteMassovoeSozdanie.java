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
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class,
	KUZ_200_CUR_1.class
	})
public class TestSuiteMassovoeSozdanie {

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
