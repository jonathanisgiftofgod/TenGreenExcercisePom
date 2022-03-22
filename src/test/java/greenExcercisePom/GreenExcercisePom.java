package greenExcercisePom;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import base.BaseClass;
import pageElements.PageElementsForLogin;
import pageElements.PageForBook;
import pageElements.PageForSearchHotel;
import pageElementsFacebook.PageElementsPom;

public class GreenExcercisePom extends BaseClass{
	@Test
	public void BrowserLaunch() throws IOException {
		launchUrl("http://adactinhotelapp.com/");
		PageElementsForLogin l = new PageElementsForLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		enterText(l.getUser(), readExcel("Sheet1", 0, 0));
		enterText(l.getPass(), readExcel("Sheet1", 1, 0));
		btnClick(l.getLogin());
		PageForSearchHotel s = new PageForSearchHotel();
		selectByValue(s.getLocation(), readExcel("Sheet2", 0, 0));
		selectByValue(s.getHotels(), readExcel("Sheet2", 1, 0));
		selectByValue(s.getRoomType(), readExcel("Sheet2", 2, 0));
		selectByValue(s.getNoRoom(), readExcel("Sheet2", 3, 0));
		s.getDatein().clear();
		enterText(s.getDatein(), readExcel("Sheet2", 4, 0));
		s.getDateout().clear();
		enterText(s.getDateout(), readExcel("Sheet2", 5, 0));
		selectByValue(s.getAdult(), readExcel("Sheet2", 6, 0));
		selectByValue(s.getChild(), readExcel("Sheet2", 7, 0));
		btnClick(s.getSubmit());
		s.getRadio().click();
		btnClick(s.getContinue());
		PageForBook b = new PageForBook();
		enterText(b.getFirstName(), readExcel("Sheet3", 0, 0));
		enterText(b.getLastName(), readExcel("Sheet3", 1, 0));
		enterText(b.getAddress(), readExcel("Sheet3", 2, 0));
		enterText(b.getCardNumber(), readExcel("Sheet3", 3, 0));
		selectByValue(b.getCardType(), readExcel("Sheet3", 4, 0));
		selectByValue(b.getMonth(), readExcel("Sheet3", 5, 0));
		selectByValue(b.getYear(), readExcel("Sheet3", 6, 0));
		enterText(b.getCvv(), readExcel("Sheet3", 7, 0));
		btnClick(b.getBook());
		InputValues("order_no");
		writeExcel(0, 0, InputValues("order_no"));
	}
}
