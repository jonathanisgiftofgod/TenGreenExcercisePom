package base;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public void launchUrl(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	public void enterText(WebElement id, String text) {
		id.sendKeys(text);
	}
	public void btnClick(WebElement id) {
		id.click();
	}
	public void Clear(WebElement id) {
		id.clear();
	}
	public void selectById(WebElement id, int index) {
		Select s = new Select(id);
		s.selectByIndex(index);
	}
	public void selectByValue(WebElement id, String value) {
		Select s = new Select(id);
		s.selectByValue(value);
	}
	public void selectByVisible(WebElement id, String value) {
		Select s = new Select(id);
		s.selectByVisibleText(value);
	}
	public void startTime() {
		Date d = new Date();
		System.out.println("Starting Time "+d);
	}
	public void endTime() {
		Date d = new Date();
		System.out.println("Starting Time "+d);	
	}
	public void takesScreenShot(String path) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileHandler.copy(source, dest);
	}
	public void RobotScreenShot(String path) throws AWTException, IOException {
		Robot r = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage source = r.createScreenCapture(rect);
		File dest = new File(path);
		ImageIO.write(source, "png", dest);
	}
	public String InputValues(String value) {
		String order = driver.findElement(By.id(value)).getAttribute("value");
		System.out.println(order);
		return order;
	}
	public String readExcel(String sheet, int row, int column) throws IOException {
		File f = new File("C:\\Users\\Britto\\eclipse-workspace\\GreenExcercisePom\\Excel\\Adactin.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(column);
		int cellType = c.getCellType();
		String value = null;
		if (cellType==1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)){
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			value = sf.format(dateCellValue);
		
		}
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			value = String.valueOf(l);
		}
		return value;		
	}
	public void writeExcel(int row, int column, String order) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\Green Excersise\\Selenium\\ScreenShot\\FrameWork\\output1.xlsx");
		f.createNewFile();
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Sheet1");
		Row r = s.createRow(row);
		Cell c = r.createCell(column);
		c.setCellValue(order);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		fo.close();
	}
}
