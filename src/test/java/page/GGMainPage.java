package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GGMainPage {

    public GGMainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//button[@data-cy='search-find-button']")
    public WebElement bulButton;

    @FindBy(xpath = "//a[@aria-label='2. sayfa']")
    public WebElement ikinciSayfa;

    @FindBy(xpath = "(//div[@class='sc-1o6eogh-1 drryHP'])[2]")
    public WebElement birinciUrun;

    @FindBy(xpath = "//h1[@id='sp-title']")
    public WebElement urunBilgisi;

    @FindBy(xpath = "(//div[@id='sp-price-lowPrice'])[1]")
    public WebElement fiyatBilgisi;

    @FindBy(xpath = "//button[@id='add-to-basket']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//a[@class='header-cart-hidden-link']")
    public WebElement sepet;

    @FindBy(xpath = "//p[@class='new-price']")
    public WebElement sepettekiFiyat;

    @FindBy(xpath ="//select[@class='amount']" )
    public WebElement drapDown;

    @FindBy(xpath = "//i[@class='gg-icon gg-icon-bin-medium']")
    public WebElement sil;

    @FindBy(xpath = "//h2[text()='Sepetinizde ürün bulunmamaktadır.']")
    public WebElement sepetBosYazisi;



}
