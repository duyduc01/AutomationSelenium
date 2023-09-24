package gjs.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gjs.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Factory
	@FindBy(xpath = "//*[@class='card']//b")
	List<WebElement> products;

	By productsBy = By.xpath("//*[@class='card']//b");
	By addToCart = By.xpath("//*[@class='card']//button[contains(.,'Cart')]");
	By spinner = By.xpath("//*[contains(@class,'ngx-spinner-overlay')]");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String pName) {
		WebElement prod = getProductList().stream().filter(p->p.getText().toLowerCase().contains(pName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String pName) {
		WebElement prod = getProductByName(pName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(spinner);
		waitForElementToDisappear(spinner);
	}

}
