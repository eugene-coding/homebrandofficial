package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class WearPage extends LoadableComponent<WearPage> {
    private final WebDriver driver;

    @FindBy(name = "query")
    private WebElement searchInput;

    @FindBy(className = "t-store__filter__chosen-bar")
    private WebElement appliedFiltersPopup;

    @FindBy(className = "t-store__card")
    private List<WebElement> products;

    public WearPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String query) {
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(appliedFiltersPopup));
    }

    public int getProductCount() {
        return products.size();
    }

    @Override
    protected void load() {
        driver.get("https://homebrandofficial.ru/wear");
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(searchInput));
        } catch (TimeoutException e) {
            fail();
            System.out.println(e.getMessage());
        }
    }
}
