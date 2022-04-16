package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchPage {
	
	private WebDriver driver;
	
		// 1. By Locators: OR
	
		@FindBy(id="twotabsearchtextbox")
		WebElement searchBox;
		
		@FindBy(id="nav-search-submit-button")
		WebElement searchBtn;
		
		@FindBy(xpath="(//span[text()='Kim'])[1]")
		WebElement searchedItem;
		
		
		
		//constructor
		public SearchPage(WebDriver edriver) {
			this.driver = edriver;
			PageFactory.initElements(driver, this);
		//	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		}
		
	
		public void searchFor(String searchFor) {
			searchBox.sendKeys(searchFor);
		}

		public void clickOnSearch() {
			searchBtn.click();
		}
		
		public void clickOnSearchedItem() {
			searchedItem.click();
		}
		
}
