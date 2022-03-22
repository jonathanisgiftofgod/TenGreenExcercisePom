package pageElementsFacebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class PageElementsPom extends BaseClass{
	public PageElementsPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement userId;
	@FindBy(id="pass")
	private WebElement password;
	@FindBy(xpath="//button[@value=\"1\"]")
	private WebElement login;
	public WebElement getUserId() {
		return userId;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
}
