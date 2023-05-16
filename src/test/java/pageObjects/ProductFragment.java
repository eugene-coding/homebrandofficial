package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductFragment {
    private final WebElement product;

    private final By nameSelector = By.className("js-product-name");
    private final By priceSelector = By.className("js-product-price");

    public ProductFragment(WebElement product) {
        this.product = product;
    }

    public String getName(){
        return product.findElement(nameSelector).getText();
    }

    public String getPrice(){
        return product.findElement(priceSelector).getText();
    }
}
