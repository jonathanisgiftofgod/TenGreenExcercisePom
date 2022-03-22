package pageElementsFacebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class pageElementsGreens extends BaseClass{
	public pageElementsGreens() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='collapseOne']/div/div/div[1]/div[1]/a/div[1]")
	private WebElement certification;
	@FindBy(xpath="//*[@id='nav-wrapper']/ul/li[5]/a")
	private WebElement testimonial;
	@FindBy(xpath="//div[@title='Courses']")
	private WebElement courses;
	@FindBy(xpath="//span[contains(text(),'Software Testing (12)')]")
	private WebElement softwareTest;
	@FindBy(xpath="//span[contains(text(),'Selenium Certification Training')]")
	private WebElement seleniumTest;
	
	
	public WebElement getCertification() {
		return certification;
	}
	public WebElement getTestimonial() {
		return testimonial;
	}
	public WebElement getCourses() {
		return courses;
	}
	public WebElement getSoftwareTest() {
		return softwareTest;
	}
	public WebElement getSeleniumTest() {
		return seleniumTest;
	}
	
}
