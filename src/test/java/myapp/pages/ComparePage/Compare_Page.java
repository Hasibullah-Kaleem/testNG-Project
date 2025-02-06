package myapp.pages.ComparePage;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Compare_Page {

    public WebElement heartIcon;

    public Compare_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

//Locators for the Compare page
    @FindBy(xpath = "//a[@title='Compare']")
    public WebElement scaleIcon;

    //  @FindBy(xpath = "(//a[contains(@class, 'compare')])[2]\n")
    // public WebElement scaleIcon2;

    @FindBy(xpath = " (//a[@data-product_id='19895'])[2]")
    public WebElement scaleIcon3;


    @FindBy(xpath = "//div[@class='elementor-spacer-inner']")
    public WebElement centralPanel;

    @FindBy(xpath = "//*[text()=\"Start Compare !\"]")
    public WebElement startCompare;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/compare-2/'" +
            " and contains(@class, 'btn-dark') and normalize-space(text())='Start Compare !']")
    public WebElement startCompareButton2;

    @FindBy(xpath = "//img[contains(@src, 'chess_image-5-300x300.webp')]\n")
    public WebElement procuct2;


    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement compareHeader;

    @FindBy(xpath = "//input[@aria-label='Search']\n")
    public WebElement searchBox;

//locators for the search results

    @FindBy(xpath = "//div[@class='breadcrumb-container container']\n")
    public WebElement navigationPanel;

    @FindBy(xpath = "(//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/div/h3/a")
    public WebElement productTitle1;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[2]/div/div/h3/a")
    public WebElement productTitle2;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[3]/div/div/h3/a")
    public WebElement productTitle3;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[4]/div/div/h3/a")
    public WebElement productTitle4;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[2]/div/figure")
    public WebElement priceProduct2;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[3]/div/figure")
    public WebElement priceProduct3;


    @FindBy(xpath = "(//a[@title='Compare'])[1]")
    public WebElement addCompare1;

    @FindBy(xpath = "(//a[@title='Compare'])[2]")
    public WebElement addCompare2;

    @FindBy(xpath = "(//a[@title='Compare'])[3]")
    public WebElement addCompare3;

    @FindBy(xpath = "(//a[@title='Compare'])[4]")
    public WebElement addCompare4;


    @FindBy(xpath = "(//img[@width='300' and @height='300' ])[2]")
    public WebElement productImage1;

    @FindBy(xpath = "(//img[@width='300' and @height='300' ])[4]")
    public WebElement productImage2;

    @FindBy(xpath = "(//img[contains(@src, '1709224251909')])[3]")
    public WebElement productImage8;

    @FindBy(xpath = "//img[@alt='Diablo']\n")
    public WebElement productImage3;

    @FindBy(xpath = "//img[contains(@src, 'amblem-300x300.png')]\n")
    public WebElement productImage4;


    //locators for the Men category
    @FindBy(xpath = "//*[@id=\"menu-item-12993\"]/a")
    public WebElement menCategory;

    @FindBy(xpath = "//*[@id=\"menu-item-12995\"]/a")
    public WebElement fashionCategory;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/figure")
    public WebElement productMen1;

    @FindBy(xpath = "//a[contains(text(),'Men sweater')]")
    public WebElement productMen2;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/figure/div[2]/a[2]")
    public WebElement scaleProductMen1;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[2]/div/figure/div/a[2]")
    public WebElement scaleProductMen2;


    //https://allovercommerce.com/compare-2/


    @FindBy(xpath = "//h2[contains(text(), 'No products added to the compare')]")
    public WebElement noProductsAdded;

    @FindBy(xpath = "//a[contains(@class, 'remove_from_compare') and @data-product_id='13206']\n")
    public WebElement removeProduct1;


    @FindBy(xpath = "//a[contains(@class, 'remove_from_compare') and @data-product_id='19895']\n")
    public WebElement removeProduct2;
}
