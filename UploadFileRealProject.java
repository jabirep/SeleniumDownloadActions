package LoveDale;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class UploadFileRealProject {
		
	    public static void main(String[] args) throws InterruptedException {
	    	
	        // Set the path to the GeckoDriver executable
	    	WebDriverManager.firefoxdriver().setup();
	    	
	        // Initialize the WebDriver
	        WebDriver driver = new FirefoxDriver();

	        // Navigate to the web page with the file input
	        driver.get("https://smartcampustesting.kran.co.in/smartcampus/");
	        
	        driver.findElement(By.name("username")).sendKeys("annamma");
	        driver.findElement(By.name("password")).sendKeys("passwd");
	        
	        driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();

	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//div[@class='btn triggerSidebar d-flex justify-content-center align-items-center']//i[@class='fa fa-th']")).click();
	        driver.findElement(By.xpath("//h6[normalize-space()='Registration']")).click();
	        driver.findElement(By.xpath("//a[@title='Add New Registration']")).click();
	        

	        // Locate the file input element
	        WebElement fileInput = driver.findElement(By.xpath("//input[@id='studentPhoto']"));

	        // Define the path to the file you want to upload
	        String filePath = "/home/jabir/Downloads/dummy passport.jpg";

	        // Upload the file by sending the file path to the file input element
	        fileInput.sendKeys(filePath);
	        
	        Thread.sleep(5000);
	        // Perform additional actions if needed, e.g., submit the form
	        // WebElement submitButton = driver.findElement(By.id("submit-button"));
	        // submitButton.click();

	        // Close the driver
	        driver.quit();
	    }
	}



