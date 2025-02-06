package myapp.pages.WhishListPage;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhishList_Page {



    public WebElement heartIcon;

    public WhishList_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
//Locators for the WhishList page
    @FindBy(xpath = "(//div[@class='yith-wcwl-add-button']/a)[1]")
    public WebElement smallHeart;

    @FindBy(xpath = "//div[@class='yith-wcwl-wishlistaddedbrowse']")
    public WebElement smallHeart2;

    @FindBy(xpath = "//a[@class='wishlist block-type']")
    public WebElement bigHeart;

    @FindBy(xpath = "//a[@class='w-icon-heart']")
    public WebElement bigHeart2;

    @FindBy(xpath = "//*[@id=\"yith-wcwl-row-13206\"]/td[5]/div/button")
    public WebElement quickViewButton;

    @FindBy(xpath = "//*[@id=\"yith-wcwl-row-13206\"]/td[5]/div/a")
    public WebElement addToCartButton;

    //Locators for the Cart page
    @FindBy(xpath = "//i[@class='w-icon-cart']//span[@class='cart-count']")
    public WebElement cartButton;

    @FindBy(xpath = "//h4[@class='cart-title' and text()='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//a[contains(@href, 'wishlist') and @rel='nofollow' and @data-title='Browse wishlist...']")
    public WebElement wishListButtonInquickView;

    @FindBy(xpath = "//a[@class='remove remove_from_wishlist fas fa-times']")
    public WebElement removeButton;
}
