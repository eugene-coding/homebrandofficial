package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class ProductPage extends LoadableComponent<ProductPage> {
    private final WebDriver driver;

    @FindBy(className = "t-store__prod-popup__btn")
    private WebElement addToCartButton;

    @FindBy(className = "t706__carticon-wrapper")
    private WebElement cartButton;

    @FindBy(css = ".t706__sidebar-bottom, .t706__cartpage-open-form")
    private WebElement checkoutButton;

    @FindBy(id = "input_1496239431201")
    private WebElement fullNameInput;

    @FindBy(xpath = "//form[@id=\"form349791057\"]//input[@name=\"tildaspec-phone-part[]\"]")
    private WebElement phoneInput;

    @FindBy(id = "input_1627385047591")
    private WebElement countryOrRegionMapInput;

    @FindBy(id = "input_1630305196291")
    private WebElement deliveryAddressInput;

    @FindBy(name="tildadelivery-city")
    private WebElement cityInput;

    @FindBy(name = "tildadelivery-userinitials")
    private WebElement recipientInput;

    @FindBy(name = "tildadelivery-street")
    private WebElement streetInput;

    @FindBy(name = "tildadelivery-house")
    private WebElement houseInput;

    @FindBy(name = "tildadelivery-aptoffice")
    private WebElement apartmentInput;

    @FindBy(id = "input_1683878302422")
    private WebElement deliveryPhoneInput;

    @FindBy(id = "input_1683878343596")
    private WebElement emailInput;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCartButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(cartButton));
    }

    public void checkout() {
        clickOnCartButton();
        clickOnCheckoutButton();
    }

    private void clickOnCartButton() {
        cartButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }

    private void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
        }
    }
}
