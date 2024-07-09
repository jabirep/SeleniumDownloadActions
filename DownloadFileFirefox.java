package LoveDale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class DownloadFileFirefox {
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
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");

        // Perform the file download operation (e.g., click on the download link/button)
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
        Thread.sleep(8000);
        
        // Close the driver
        driver.quit();
    }
}

