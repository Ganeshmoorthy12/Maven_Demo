	package Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class baseclass {

	public static WebDriver driver;

	public static void Browserlaunch() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Soft\\Ganesh\\G1\\Ipt1\\Demo\\src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} catch (Exception e) {
			System.out.println("invalid Chrome broweser" + e.getMessage());
		}

	}

	public static void geturl(String url) {
		try {

			driver.get(url);

		} catch (Exception e) {
			System.out.println("Unable to open :" + e.getMessage());
		}

	}

	public static void maximize() {

		try {

			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println("Unable to maximize the screen :" + e.getMessage());
		}

	}

	public static void click(WebElement searchbox) {
		try {

			searchbox.click();

		} catch (Exception e) {
			System.out.println("Unable to search :" + e.getMessage());
		}

	}

	public static void elementsendkey(WebElement element, String value) {

		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to sendkey :" + e.getMessage());
		}

	}

	public static void elementclick(WebElement element) {
		try {

			element.click();

		} catch (Exception e) {
			System.out.println("Unable to click :" + e.getMessage());
		}

	}

	public static void screenshot(String name) {
		try {
			File des = new File("D:\\Soft\\Ganesh\\G1\\Ipt1\\Demo\\src\\test\\resources\\Screenshot" + name + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			// FileHandler.
		} catch (Exception e) {
			System.out.println("Unable to take screenshot :" + e.getMessage());
		}

	}

	public static void mousemover(WebElement element) {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			System.out.println("Unable to move :" + e.getMessage());
		}

	}

	public static void Timeout() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void naviagtebackward() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println("Unable to backward :" + e.getMessage());
		}

	}

	public static void naviagtereferesh() {
		try {
			driver.navigate().refresh();

		} catch (Exception e) {
			System.out.println("Unable to referesh :" + e.getMessage());
		}

	}

	public static void switchTowindow(String windowname) {
		// String mainwindow = driver.getWindowHandle();// main window//
		Set<String> childwindow = driver.getWindowHandles();// all window-returntype
		for (String Window : childwindow) {

			String title = driver.switchTo().window(Window).getTitle();
			if (windowname.equals(title)) {
				break;

			}
		}
	}

	public static void addcart(WebElement add) {

		try {

			add.click();

		} catch (Exception e) {
			System.out.println("Unable to click :" + e.getMessage());
		}

	}

	// excel read
	// 0-1st row
	// 1-2nd row
	// 0-1st column
	// 1-2nd column
	public static String excelread(int rows, int col) throws IOException {
		String path = ".\\src\\test\\resources\\testdata\\Test.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);// return type
		Row row = sheetAt.getRow(rows);// return type
		Cell cell = row.getCell(col);// return type
		DataFormatter data = new DataFormatter();
		String formatCellValue = data.formatCellValue(cell);// return type
		System.out.println(formatCellValue + " ||");
		return formatCellValue;

	}

	// excel write

	
	public static void dropdown(WebElement element, String option, String i) {
		Select s = new Select(element);
		try {
			if (option.equals("index")) {
				s.selectByIndex(Integer.parseInt(i));

			} else if (option.equals("text")) {
				s.selectByVisibleText(i);
			} else if (option.equals("value")) {
				s.selectByValue(i);
			}
		} catch (Exception e) {
			System.out.println("Unable to entr the qty :"+e.getMessage());
		}
	}
	
	public static void gettext(WebElement element) {
		try {
			
			System.out.println(element.getText());
			
		} catch (Exception e) {
			System.out.println("Unable to gettext :"+e.getMessage());
		}
		

	}

	public static void Threadsleepforsec(int sec) {
		try {
			
			
			TimeUnit.SECONDS.sleep(sec);
			
		} catch (Exception e) {
		    System.out.println("Unable to sleep :"+e.getMessage());
		}

	}
}