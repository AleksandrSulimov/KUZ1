package uz;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import uz.pages.FormsTab;
import uz.pages.HarakteristikaFinansovogoObespechenijaTab;
import uz.pages.ListSoglasovanijaTab;
import uz.pages.LoginPage;
import uz.pages.Menu;
import uz.pages.OsnovnyeSvedenijaTab;
import uz.pages.Tabs;
import uz.pages.Top;
import uz.pages.UZ200Page;
import uz.spravochnik.DopPriznakSpravochnik;
import uz.spravochnik.KbkSpravochnik;
import uz.spravochnik.KosguSpravochnik;
import uz.spravochnik.KppoSpravochnik;
import uz.spravochnik.NpoSpravochnik;
import uz.spravochnik.OkpdSpravochnik;
import uz.spravochnik.Periodicity;
import uz.spravochnik.UserSpravochnik;
import uz.user.User;
import uz.util.Logger;
import uz.util.PropertyLoader;


public class KUZ_300_1 extends JUnitTestBase {

  private LoginPage loginpage;
  private Menu menu;
  private Tabs tabs;
  private FormsTab formsTab;
  private UZ200Page uz300;
  private NpoSpravochnik npo;
  private KppoSpravochnik kppo;
  private OkpdSpravochnik okpd;
  private Periodicity periodicity;
  private OsnovnyeSvedenijaTab osnovnyeSvedenija;
  private HarakteristikaFinansovogoObespechenijaTab finsCharacteristics;
  private KbkSpravochnik kbk;
  private KosguSpravochnik kosgu;
  private DopPriznakSpravochnik dopPriznak;
  private ListSoglasovanijaTab listSoglasovanija;
  private UserSpravochnik userSpravochnik;
  private Top top;
//  private Logger log = Logger.getInstance();
  private User user = new User();
  private String number = null;
  private String okpd_1, okpd_2, okpd_3, okpd_4, okpd_r, opisanie_zakupki, srok_osushhestvlenija_zakupki, periodichnost_osushhestvlenija_zakupki, obosnovanie_zakupki, cel_osushhestvlenija_zakupki,
	planiruemyj_god, kbk_val, kosgu_val, npo_val, kppo_val, analiticheskiy_priznak, currency_val, predlozhenie_2016, predlozhenie_2017, predlozhenie_2018, dolzhnost_author, telephone_author, stage, code_group, nomer_soglasujushhego,
	soglasujushhiy, utverzhdajushhiy, telephone_utverzhdajushhego;
private String fromResource = "/kuz_300_1.properties";
  @Before
  public void initPageObjects() throws IOException {
    loginpage = PageFactory.initElements(driver, LoginPage.class);
    menu = PageFactory.initElements(driver, Menu.class);
    tabs = PageFactory.initElements(driver, Tabs.class);
    formsTab = PageFactory.initElements(driver, FormsTab.class);
    npo = PageFactory.initElements(driver, NpoSpravochnik.class);
    okpd = PageFactory.initElements(driver, OkpdSpravochnik.class);
    periodicity = PageFactory.initElements(driver, Periodicity.class);
    osnovnyeSvedenija = PageFactory.initElements(driver, OsnovnyeSvedenijaTab.class);
    finsCharacteristics = PageFactory.initElements(driver, HarakteristikaFinansovogoObespechenijaTab.class);
    kbk = PageFactory.initElements(driver, KbkSpravochnik.class);
    kosgu = PageFactory.initElements(driver, KosguSpravochnik.class);
    kppo = PageFactory.initElements(driver, KppoSpravochnik.class);
    listSoglasovanija = PageFactory.initElements(driver, ListSoglasovanijaTab.class);
    userSpravochnik = PageFactory.initElements(driver, UserSpravochnik.class);
    top = PageFactory.initElements(driver, Top.class);
    this.okpd_1=PropertyLoader.loadPropertyLocale("okpd_1", fromResource);
	this.okpd_2=PropertyLoader.loadPropertyLocale("okpd_2", fromResource);
	this.okpd_3=PropertyLoader.loadPropertyLocale("okpd_3", fromResource);
	this.okpd_4=PropertyLoader.loadPropertyLocale("okpd_4", fromResource);
	this.okpd_r=PropertyLoader.loadPropertyLocale("okpd_r", fromResource);
	this.opisanie_zakupki=PropertyLoader.loadPropertyLocale("opisanie_zakupki", fromResource);
	this.srok_osushhestvlenija_zakupki=PropertyLoader.loadPropertyLocale("srok_osushhestvlenija_zakupki", fromResource);
	this.periodichnost_osushhestvlenija_zakupki=PropertyLoader.loadPropertyLocale("periodichnost_osushhestvlenija_zakupki", fromResource);
	this.obosnovanie_zakupki=PropertyLoader.loadPropertyLocale("obosnovanie_zakupki", fromResource);
	this.cel_osushhestvlenija_zakupki=PropertyLoader.loadPropertyLocale("cel_osushhestvlenija_zakupki", fromResource);
	this.planiruemyj_god=PropertyLoader.loadPropertyLocale("planiruemyj_god", fromResource);
	this.kbk_val=PropertyLoader.loadPropertyLocale("kbk_val", fromResource);
	this.kosgu_val=PropertyLoader.loadPropertyLocale("kosgu_val", fromResource);
	this.analiticheskiy_priznak=PropertyLoader.loadPropertyLocale("analiticheskiy_priznak", fromResource);
	this.npo_val=PropertyLoader.loadPropertyLocale("npo_val", fromResource);
	this.kppo_val=PropertyLoader.loadPropertyLocale("kppo_val", fromResource);
	this.currency_val=PropertyLoader.loadPropertyLocale("currency_val", fromResource);
	this.predlozhenie_2016=PropertyLoader.loadPropertyLocale("predlozhenie_2016", fromResource);
	this.predlozhenie_2017=PropertyLoader.loadPropertyLocale("predlozhenie_2017", fromResource);
	this.predlozhenie_2018=PropertyLoader.loadPropertyLocale("predlozhenie_2018", fromResource);
	this.dolzhnost_author=PropertyLoader.loadPropertyLocale("dolzhnost_author", fromResource);
	this.telephone_author=PropertyLoader.loadPropertyLocale("telephone_author", fromResource);
	this.stage=PropertyLoader.loadPropertyLocale("stage", fromResource);
	this.code_group=PropertyLoader.loadPropertyLocale("code_group", fromResource);
	this.nomer_soglasujushhego=PropertyLoader.loadPropertyLocale("nomer_soglasujushhego", fromResource);
	this.soglasujushhiy=PropertyLoader.loadPropertyLocale("soglasujushhiy", fromResource);
	this.utverzhdajushhiy=PropertyLoader.loadPropertyLocale("utverzhdajushhiy", fromResource);
	this.telephone_utverzhdajushhego=PropertyLoader.loadPropertyLocale("telephone_utverzhdajushhego", fromResource);
  }

  @Override
  public void runTest() {
	log.logTestName("Создание КУЗ 300");
	
	log.logStep(0, "Предусловия");
	log.info("Переход по ссылке: "+baseUrl);
    driver.get(baseUrl);
    loginpage.setLogin(user.getUserName());
    loginpage.setPassword(user.getUserPassword());
    loginpage.clickEnter();
    menu.clickUpravlenieZakupkami();
    tabs.clickForms();
    formsTab.checkFormsIsActive();
    formsTab.openUpravlenieZakupkami();
    formsTab.openPlanirovanie();
    formsTab.openFormirovanieOBAS();
    formsTab.openKartochkiUZ();
    formsTab.clickUZ_300();
    
    log.logStep(1, "В реестре карточек укрупненных закупок нажать кнопку 'Создать новый документ'");
    uz300 = new UZ200Page(driver);
    uz300.newDocument();
    
    log.logStep(2, "В разделе 'Сведения о закупках федерального государственного заказчика' заполнить поля");
    uz300.goToTabOsnovnyeSvedenija();
    osnovnyeSvedenija.checkStatus("Черновик");
    osnovnyeSvedenija.checkDate();
    osnovnyeSvedenija.clickNpoSpravochnick();
//    npo.select(npo_val);
    npo.selectWithFilter("Кодовое обозначение элемента", npo_val);
    osnovnyeSvedenija.clickOkpdSpravochnick();
    okpd.select(okpd_1, okpd_2, okpd_3, okpd_4, okpd_r);
    osnovnyeSvedenija.setOpisanieZakupki(opisanie_zakupki);
    osnovnyeSvedenija.setSrokOsushhestvlenijaZakupki(srok_osushhestvlenija_zakupki);
    osnovnyeSvedenija.clickPeriodicitySpravochnick();
    periodicity.select(periodichnost_osushhestvlenija_zakupki);
//    osnovnyeSvedenija.setPeriodichnostOsushhestvlenijaZakupki(periodichnost_osushhestvlenija_zakupki);
    osnovnyeSvedenija.setObosnovanieZakupki(obosnovanie_zakupki);
//    osnovnyeSvedenija.uploadFile();
    osnovnyeSvedenija.setCelOsushhestvlenijaZakupki(cel_osushhestvlenija_zakupki);

    log.logStep(3, "Перейти на вкладку 'Характеристика финансового обеспечения'.");
    uz300.goToTabHarakteristikaFinansovogoObespechenija();
    finsCharacteristics.newRow();
    finsCharacteristics.setPlaniruemyjGod(planiruemyj_god);
    finsCharacteristics.clickKbkSpravochnick();
    kbk.select(kbk_val);
    finsCharacteristics.clickKosguSpravochnick();
//    kosgu.selectWithFilter("Код", kosgu_val);
    kosgu.select(kosgu_val);
    finsCharacteristics.clickKppoSpravochnick();
    kppo.select(kppo_val);
//    kppo.selectWithFilter("Кодовое обозначение элемента", kppo_val);
    finsCharacteristics.setPredlozhenie2016(predlozhenie_2016);
    finsCharacteristics.setPredlozhenie2017(predlozhenie_2017);
    finsCharacteristics.setPredlozhenie2018(predlozhenie_2018);
    
    log.logStep(4, "Перейти на вкладку 'Лист согласования'.");
    uz300.goToTabListSoglasovanija();
//    listSoglasovanija.setDolzhnostAuthor(dolzhnost_author);
//    listSoglasovanija.setTelephoneAuthor(telephone_author);
    listSoglasovanija.addTableSoglas();
    listSoglasovanija.newRow();
    listSoglasovanija.setStage(stage);
    listSoglasovanija.setCodeGroup(code_group);
    listSoglasovanija.setNumberSoglasujushhego(nomer_soglasujushhego);
    listSoglasovanija.clickSoglasujushhieSpravochnick();
    userSpravochnik.select(soglasujushhiy);
    listSoglasovanija.clickUtverzhdajushhijSpravochnick();
    userSpravochnik.select(utverzhdajushhiy);
    listSoglasovanija.setTelephoneUtverzhdajushhego(telephone_utverzhdajushhego);
    
    
    log.logStep(5, "Нажать на кнопку 'Сохранить изменения и закрыть окно'");
    uz300.saveChange();
    uz300.goToTabOsnovnyeSvedenija();
    number = osnovnyeSvedenija.getNumber();
    uz300.closeWindow();
    uz300.otpravitNaSoglasovanie(number);
    uz300.closeUZ();
    
    log.logStep(6, "Согласование карточки'");
    formsTab.openUpravlenieZakupkami();
    formsTab.openPlanirovanie();
    formsTab.openFormirovanieOBAS();
    formsTab.openKartochkiUZ();
    formsTab.openKartochkiUZ300();
    formsTab.openMyDocuments();
    formsTab.clickSoglasovanie();
    uz300.soglasovatZakupku(number);
    uz300.closeUZ();
    
    log.logStep(6, "Утверждение карточки'");
    formsTab.clickUtverjdenie();
    uz300.utverjdenieZakupku(number);
    uz300.closeUZ();
    
    top.clickLogout();

//    log.logTestEnd("Создание КУЗ 300");
  }
//  @After
//  public void tearDown() throws Exception {  
//      driver.quit();  
//  }  
}
