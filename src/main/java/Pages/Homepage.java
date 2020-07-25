package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	@FindBy(xpath = "(//*[text()='My Account'])[1]")
	WebElement myAccountText ;
	@FindBy(xpath = "//*[text()=\"You're shopping \"]")
	WebElement youreShoppingText;
	@FindBy(linkText = "Store Finder")
	WebElement storeFinderText;
	@FindBy(xpath = "//*[text()='Register']")
	WebElement register;
	@FindBy(xpath = "(//div[@class=\"col__12-12\"])[5]/button")
	WebElement Clickbutton; 
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String myAccountTextVerification() {
		String myAccountCurrentText = myAccountText.getText();
		return myAccountCurrentText;
	}
	public String youreShoppingTextVerification() {
		String myAccountCurrentText = youreShoppingText.getText();
		return myAccountCurrentText;
	}
	public String storeFinderTextVerification() {
		String myAccountCurrentText = storeFinderText.getText();
		return myAccountCurrentText;
	}
	public void myAccountClick() {
		myAccountText.click();
	}
	public void registerButton() {
		register.click();
	}
	public void Clicktocontinue() {
		Clickbutton.click();
		
	}

}
