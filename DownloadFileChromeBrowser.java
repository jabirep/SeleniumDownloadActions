package LoveDale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class DownloadFileChromeBrowser {
	
	public static WebDriver driver;
	
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
    	WebDriverManager.chromedriver().setup();
    	
        // Create a map to set preferences
        Map<String, Object> prefs = new HashMap<>();
        // Set the download directory
        prefs.put("download.default_directory", "/home/jabir/Downloads/JABIR_KRAN");
        //disable popups
        prefs.put("profile.default_content_settings.popups", 0);
        //Disable the download prompt
        prefs.put("download.prompt_for_download", false);
        //Enable safe browsing
        prefs.put("safebrowsing.enabled", "true");

        // Create ChromeOptions and add the preferences
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Add the options to the driver (initialize the webdriver with the configured options)
        driver = new ChromeDriver(options);

        // Navigate to the file download page
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        

        // Perform the file download operation (e.g., click on the download link/button)
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
        Thread.sleep(8000);

        // Close the driver
        driver.quit();
    }
}

