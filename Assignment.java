package selenium_Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PolarSecurtiyTest_Finviz
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\Desktop\\eclipse\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		
		//open the website
		driver.get("https://finviz.com/");
		
		BufferedReader br = null;
		String jsonData = "";
		try {
	        String line;
	        br = new BufferedReader(new FileReader("C:\\Users\\user1\\eclipse-workspace\\selenium_Test\\src\\selenium_Test\\hA_vars.json"));
	        while ((line = br.readLine()) != null) {
	            jsonData += line + "\n";
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (br != null)
	                br.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    } 
		
		JSONObject obj = new JSONObject(jsonData);
		
		String criteria1 = (String) obj.get("criteria1");
		String valuec1 = (String) obj.get("valuec1");
		String criteria2 = (String) obj.get("criteria2");
		String valuec2 = (String) obj.get("valuec2");
		String criteria3 = (String) obj.get("criteria3");
		String valuec3 = (String) obj.get("valuec3");
		String sortByCrit =(String) obj.get("sortByCrit");
		String sortByOrd = (String) obj.get("sortByOrd");
		
		//find "Screener" tab and click it
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Screener")));
		driver.findElement(By.linkText("Screener")).click();
		
		//find "All" tab in Screener and click it
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"filter-table-tabs\"]/tbody/tr[2]/td[12]")));
		driver.findElement(By.xpath("//*[@id=\"filter-table-tabs\"]/tbody/tr[2]/td[12]")).click();
		
		//find the criteria DropDown box Select and sort by values
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(criteria1)));
		Select dropPb = new Select (driver.findElement(By.id(criteria1)));
		dropPb.selectByVisibleText(valuec1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(criteria2)));
		Select dropCratio = new Select (driver.findElement(By.id(criteria2)));
		dropCratio.selectByVisibleText(valuec2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(criteria3)));
		Select dropSector = new Select (driver.findElement(By.id(criteria3)));
		dropSector.selectByVisibleText(valuec3);
		
		//Find the "sort by" 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderSelect")));
		Select dropSortBy = new Select (driver.findElement(By.id("orderSelect")));
		dropSortBy.selectByVisibleText(sortByCrit);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderDirSelect")));
		Select dropSortByOrd = new Select (driver.findElement(By.id("orderDirSelect")));
		dropSortByOrd.selectByVisibleText(sortByOrd);
		
		String companyColXpathStart = "//*[@id=\"screener-views-table\"]/tbody/tr[4]/td/table/tbody/tr[";
		String companyColXpathEnd = "]/td[3]/a";
		
		int numOfStocksWanted = 10;
		int startRow = 2, j = 0;
		String curCompanyName = ""; 
		for (; j < numOfStocksWanted; j++)
		{
			String curxPath = companyColXpathStart + startRow + companyColXpathEnd;
			curCompanyName = driver.findElement(By.xpath(curxPath)).getText();
			System.out.println(curCompanyName);
			startRow++;
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//closing the browser
		driver.close();

	}

}
