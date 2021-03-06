package uz;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import uz.pages.FormsTab;
import uz.pages.HarakteristikaFinansovogoObespechenijaTab;
import uz.pages.KUZ_400_HarakteristikaFinansovogoObespechenijaTab;
import uz.pages.ListSoglasovanijaTab;
import uz.pages.LoginPage;
import uz.pages.Menu;
import uz.pages.OsnovnyeSvedenijaTab;
import uz.pages.Tabs;
import uz.pages.Top;
import uz.pages.UZ200Page;
import uz.spravochnik.DopPriznakSpravochnik;
import uz.spravochnik.FaipSpravochnik;
import uz.spravochnik.FcpSpravochnik;
import uz.spravochnik.KbkSpravochnik;
import uz.spravochnik.KosguSpravochnik;
import uz.spravochnik.KppoSpravochnik;
import uz.spravochnik.NpoSpravochnik;
import uz.spravochnik.FaipNEWSpravochnik;
import uz.spravochnik.OkeiSpravochnik;
import uz.spravochnik.OkpdSpravochnik;
import uz.spravochnik.OkvedSpravochnik;
import uz.spravochnik.Periodicity;
import uz.spravochnik.UserSpravochnik;
import uz.user.User;
import uz.util.Logger;
import uz.util.PropertyLoader;


public class KUZ_400_PORPOSE_FAIP_1 extends JUnitTestBase {

  private LoginPage loginpage;
  private Menu menu;
  private Tabs tabs;
  private FormsTab formsTab;
  private UZ200Page uz400;
  private OkeiSpravochnik okei;
  private OkvedSpravochnik okved;
  private FaipNEWSpravochnik faip;
  private OkpdSpravochnik okpd;
  private Periodicity periodicity;
  private OsnovnyeSvedenijaTab osnovnyeSvedenija;
  private KUZ_400_HarakteristikaFinansovogoObespechenijaTab finsCharacteristics;
  private KbkSpravochnik kbk;
  private KosguSpravochnik kosgu;
  private FcpSpravochnik fcp;
  private ListSoglasovanijaTab listSoglasovanija;
  private UserSpravochnik userSpravochnik;
  private Top top;
//  private Logger log = Logger.getInstance();
  private User user = new User();
  private String number = null;
  private String okpd_1, okpd_2, okpd_3, okpd_r, opisanie_zakupki, srok_osushhestvlenija_zakupki, periodichnost_osushhestvlenija_zakupki, obosnovanie_zakupki, cel_osushhestvlenija_zakupki,
	planiruemyj_god, kbk_val, kosgu_val,  predlozhenie_2016, predlozhenie_2017, predlozhenie_2018, dolzhnost_author, telephone_author, stage, code_group, nomer_soglasujushhego,
	soglasujushhiy, utverzhdajushhiy, telephone_utverzhdajushhego, type_object, name_object,napravlenie_investirovanija, kod_uchetnoj_edinicy,																aaa,
	edinica_izmerenija, moshnost_val, okved_val, razdel_faip, fcp_val, otrasl, gruppa_meroprijatij, group_object_faip, zastrojshhik, gosudarstvennyj_zakazchik;
private String fromResource = "/kuz_400_porpose_faip_1.properties";
  @Before
  public void initPageObjects() throws IOException {
    loginpage = PageFactory.initElements(driver, LoginPage.class);
    menu = PageFactory.initElements(driver, Menu.class);
    tabs = PageFactory.initElements(driver, Tabs.class);
    formsTab = PageFactory.initElements(driver, FormsTab.class);
    okei = PageFactory.initElements(driver, OkeiSpravochnik.class);
    okpd = PageFactory.initElements(driver, OkpdSpravochnik.class);
    faip = PageFactory.initElements(driver, FaipNEWSpravochnik.class);
    periodicity = PageFactory.initElements(driver, Periodicity.class);
    fcp = PageFactory.initElements(driver, FcpSpravochnik.class);
    osnovnyeSvedenija = PageFactory.initElements(driver, OsnovnyeSvedenijaTab.class);
    finsCharacteristics = PageFactory.initElements(driver, KUZ_400_HarakteristikaFinansovogoObespechenijaTab.class);
    kbk = PageFactory.initElements(driver, KbkSpravochnik.class);
    kosgu = PageFactory.initElements(driver, KosguSpravochnik.class);
    okved = PageFactory.initElements(driver, OkvedSpravochnik.class);
    listSoglasovanija = PageFactory.initElements(driver, ListSoglasovanijaTab.class);
    userSpravochnik = PageFactory.initElements(driver, UserSpravochnik.class);
    top = PageFactory.initElements(driver, Top.class);
    this.okpd_1=PropertyLoader.loadPropertyLocale("okpd_1", fromResource);
	this.okpd_2=PropertyLoader.loadPropertyLocale("okpd_2", fromResource);
	this.okpd_3=PropertyLoader.loadPropertyLocale("okpd_3", fromResource);
	this.okpd_r=PropertyLoader.loadPropertyLocale("okpd_r", fromResource);
	this.opisanie_zakupki=PropertyLoader.loadPropertyLocale("opisanie_zakupki", fromResource);
	this.srok_osushhestvlenija_zakupki=PropertyLoader.loadPropertyLocale("srok_osushhestvlenija_zakupki", fromResource);
	this.periodichnost_osushhestvlenija_zakupki=PropertyLoader.loadPropertyLocale("periodichnost_osushhestvlenija_zakupki", fromResource);
	this.obosnovanie_zakupki=PropertyLoader.loadPropertyLocale("obosnovanie_zakupki", fromResource);
	this.cel_osushhestvlenija_zakupki=PropertyLoader.loadPropertyLocale("cel_osushhestvlenija_zakupki", fromResource);
	this.planiruemyj_god=PropertyLoader.loadPropertyLocale("planiruemyj_god", fromResource);
	this.kbk_val=PropertyLoader.loadPropertyLocale("kbk_val", fromResource);
	this.kosgu_val=PropertyLoader.loadPropertyLocale("kosgu_val", fromResource);
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
	this.type_object=PropertyLoader.loadPropertyLocale("type_object", fromResource);
	this.name_object=PropertyLoader.loadPropertyLocale("name_object", fromResource);
	this.napravlenie_investirovanija=PropertyLoader.loadPropertyLocale("napravlenie_investirovanija", fromResource);
	this.kod_uchetnoj_edinicy=PropertyLoader.loadPropertyLocale("kod_uchetnoj_edinicy", fromResource);
	this.edinica_izmerenija=PropertyLoader.loadPropertyLocale("edinica_izmerenija", fromResource);
	this.moshnost_val=PropertyLoader.loadPropertyLocale("moshnost_val", fromResource);
	this.okved_val=PropertyLoader.loadPropertyLocale("okved_val", fromResource);
	this.razdel_faip=PropertyLoader.loadPropertyLocale("razdel_faip", fromResource);
	this.fcp_val=PropertyLoader.loadPropertyLocale("fcp_val", fromResource);
	this.otrasl=PropertyLoader.loadPropertyLocale("otrasl", fromResource);
	this.gruppa_meroprijatij=PropertyLoader.loadPropertyLocale("gruppa_meroprijatij", fromResource);
	this.group_object_faip=PropertyLoader.loadPropertyLocale("group_object_faip", fromResource);
	this.zastrojshhik=PropertyLoader.loadPropertyLocale("zastrojshhik", fromResource);
	this.gosudarstvennyj_zakazchik=PropertyLoader.loadPropertyLocale("gosudarstvennyj_zakazchik", fromResource);
  }

  @Override
  public void runTest() {
	log.logTestName("�������� ��� 400 (������������ � ��������� � ����)");
	
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
    formsTab.clickUZ_400();
    
    log.logStep(1, "� ������� �������� ����������� ������� ������ ������ '������� ����� ��������'");
    uz400 = new UZ200Page(driver);
    uz400.newDocument();
    
    log.logStep(2, "� ������� '�������� � �������� ������������ ���������������� ���������' ��������� ����");
    uz400.goToTabOsnovnyeSvedenija();
    osnovnyeSvedenija.checkStatus("��������");
    osnovnyeSvedenija.checkDate();
    osnovnyeSvedenija.clickOkpdSpravochnick();
    okpd.select(okpd_1, okpd_2, okpd_r);
    osnovnyeSvedenija.selectTypeObject(type_object);
    osnovnyeSvedenija.clicFaipNEWSpravochnick();
    faip.selectWithFilter("���", name_object); 
    
//    osnovnyeSvedenija.setNameObject(name_object);
//    osnovnyeSvedenija.setNapravlenieInvestirovanija(napravlenie_investirovanija);
    osnovnyeSvedenija.setRazdelFaip(razdel_faip);
//    osnovnyeSvedenija.clikFcpSpravochnik();
//    fcp.selectWithFilter("���", fcp_val);
//    osnovnyeSvedenija.setOtrasl(otrasl);
//    osnovnyeSvedenija.setGruppaMeroprijatij(gruppa_meroprijatij);
//    osnovnyeSvedenija.setGroupObjectFaip(group_object_faip);
//    osnovnyeSvedenija.setZastrojshhik(zastrojshhik);
//    osnovnyeSvedenija.setGosudarstvennyjZakazchik(gosudarstvennyj_zakazchik);
//    osnovnyeSvedenija.setKodUchetnojEdinicy(kod_uchetnoj_edinicy);
//    osnovnyeSvedenija.clikEdinicaIzmerenijaSpravochnik();
//    okei.selectWithFilter("���", edinica_izmerenija);
//    osnovnyeSvedenija.setMoshnost(moshnost_val);
//    osnovnyeSvedenija.clikOkvedSpravochnik();
//    okved.selectWithFilter("���", okved_val);
    osnovnyeSvedenija.setOpisanieZakupki(opisanie_zakupki);
    osnovnyeSvedenija.setSrokOsushhestvlenijaZakupki(srok_osushhestvlenija_zakupki);
    osnovnyeSvedenija.clickPeriodicitySpravochnick();
    periodicity.select(periodichnost_osushhestvlenija_zakupki);
//    osnovnyeSvedenija.setPeriodichnostOsushhestvlenijaZakupki(periodichnost_osushhestvlenija_zakupki);
    osnovnyeSvedenija.setObosnovanieZakupki(obosnovanie_zakupki);
//    osnovnyeSvedenija.uploadFile();
    osnovnyeSvedenija.setCelOsushhestvlenijaZakupki(cel_osushhestvlenija_zakupki);

    log.logStep(3, "������� �� ������� '�������������� ����������� �����������'.");
    uz400.goToTabHarakteristikaFinansovogoObespechenija();
    finsCharacteristics.newRow();
    finsCharacteristics.setPlaniruemyjGod(planiruemyj_god);
    finsCharacteristics.clickKbkSpravochnick();
    kbk.select(kbk_val);
    finsCharacteristics.clickKosguSpravochnick();
    kosgu.selectWithFilter("���", kosgu_val);
    finsCharacteristics.setPredlozhenie2016(predlozhenie_2016);
    finsCharacteristics.setPredlozhenie2017(predlozhenie_2017);
    finsCharacteristics.setPredlozhenie2018(predlozhenie_2018);
    
    log.logStep(4, "������� �� ������� '���� ������������'.");
    uz400.goToTabListSoglasovanija();
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
    
    log.logStep(5, "������ �� ������ '��������� ��������� � ������� ����'");
    uz400.saveChange();
    uz400.goToTabOsnovnyeSvedenija();
    number = osnovnyeSvedenija.getNumber();
    uz400.closeWindow();
    uz400.otpravitNaSoglasovanie(number);
    uz400.closeUZ();
    
    log.logStep(6, "������������ ��������'");
    formsTab.openUpravlenieZakupkami();
    formsTab.openPlanirovanie();
    formsTab.openFormirovanieOBAS();
    formsTab.openKartochkiUZ();
    formsTab.openKartochkiUZ400();
    formsTab.openMyDocuments();
    formsTab.clickSoglasovanie();
    uz400.soglasovatZakupku(number);
    uz400.closeUZ();
    
    log.logStep(6, "����������� ��������'");
    formsTab.clickUtverjdenie();
    uz400.utverjdenieZakupku(number);
    uz400.closeUZ();
    
    top.clickLogout();
    
//    log.logTestEnd("�������� ��� 400 (�� ������� ����)");
  }
//  @After
//  public void tearDown() throws Exception {  
//      driver.quit();  
//  }  
}
