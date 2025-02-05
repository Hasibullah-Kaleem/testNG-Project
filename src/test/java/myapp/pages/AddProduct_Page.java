package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddProduct_Page {

    public AddProduct_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//select[@id='product_type']")
    public WebElement productTypeDropdown; //1
    @FindBy(id = "featured_img_display")
    public WebElement addImage1; //2
    @FindBy(xpath = "//button[@class='browser button button-hero']")
    public WebElement selectImage1; //3
    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement addImage2; //4
    @FindBy(id = "__wp-uploader-id-4")
    public WebElement selectImage2; //5
    @FindBy(xpath = "(//*[@id='menu-item-upload'])[2]")
    public WebElement uploadImageTab; //6
    @FindBy(xpath = "//button[contains(@class, 'media-button-select')]") // //button[text()='Select']
    public WebElement selectPastedImage; //7
    @FindBy(xpath = "(//button[contains(text(), 'Add to Gallery')])[2]")
    public WebElement addToGallery; //8
    @FindBy(id = "pro_title")
    public WebElement productTitle; //9
    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement regularPrice; //10
    @FindBy(xpath = "//input[@id='sale_price']")
    public WebElement salePrice; //11
    @FindBy(xpath = "//body[@id='tinymce']") //there is an Iframe
    public WebElement shortDescription; //12
    @FindBy(xpath = "//body[@id='tinymce']") //there is an Iframe
    public WebElement description; //13
    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtualCheckbox; //14
    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadableCheckbox; //15
    @FindBy(xpath = "//input[@data-super_parent='399']")
    public WebElement clothesCategory; //16
    @FindBy(xpath = "//input[@data-super_parent='459']")
    public WebElement defactoProductBrand; //17
    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStockCheckbox; //18
    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQuantity; //19
    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submitButton; //20
    @FindBy(xpath = "//span[text()='Published']")
    public WebElement publishedTag; //21
    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit']/div")
    public WebElement incorrectInput; //22

}
