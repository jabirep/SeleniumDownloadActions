package LoveDale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownlloadFileRealProject {
	
public static void main(String[] args) throws InterruptedException {
    	
        // Set the path to the GeckoDriver executable
    	WebDriverManager.firefoxdriver().setup();

        // Create a map to set preferences
        FirefoxOptions options = new FirefoxOptions();
        // Use 2 for custom location
        options.addPreference("browser.download.folderList", 2); 
        //define the custom path to the directory
        options.addPreference("browser.download.dir", "/home/jabir/Downloads/JABIR_KRAN");
        //Specify the MIME types to automatically save without prompting 
        //(e.g., application/octet-stream for binary files).
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        // Disable the built-in PDF viewer
        options.addPreference("pdfjs.disabled", true);

        // Add the options to the driver
        WebDriver driver = new FirefoxDriver(options);

        // Navigate to the file download page
        //here go to smartcampus admission, view the admitted student and download the pdf contained in the report
        driver.get("https://smartcampustesting.kran.co.in/smartcampus/");
        
        driver.findElement(By.name("username")).sendKeys("annamma");
        driver.findElement(By.name("password")).sendKeys("passwd");
        
        driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();

        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//div[@class='btn triggerSidebar d-flex justify-content-center align-items-center']//i[@class='fa fa-th']")).click();
        driver.findElement(By.xpath("//a[@id='admission']//div[@class='desti-image']")).click();
        driver.findElement(By.id("admApproved")).click();


        // Perform the file download operation (e.g., click on the download link/button)
        driver.findElement(By.xpath("//i[@class='fas fa-sharp fa-regular fa-eye']")).click();
        
        // Cast the driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(8000);
        
        //i have used css locator to locate the pdf file from the student report
        WebElement element=driver.findElement(By.cssSelector("div.col-12:nth-child(3) > div:nth-child(1) > div:nth-child(3) > "
        		+ "div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > span:nth-child(1)"));
        element.click();
        // Close the driver
        driver.quit();
        //Done
    }

}
