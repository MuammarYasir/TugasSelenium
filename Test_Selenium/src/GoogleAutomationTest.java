import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAutomationTest {
    public static void main(String[] args) throws InterruptedException {
        // Set path driver webdriver chrome
    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        // Test case 1: Akses halaman google.com dan verifikasi judulnya
        driver.get("https://www.google.com/");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        assert actualTitle.contains(expectedTitle);

        // Test case 2: Cari kata kunci menggunakan form pencarian dan verifikasi hasilnya
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("selenium");
        searchField.sendKeys(Keys.RETURN);

        Thread.sleep(5000); // Tunggu 5 detik untuk halaman memuat

        WebElement searchResult = driver.findElement(By.xpath("//h3[text()='Selenium']"));
        assert searchResult.isDisplayed();

        // Test case 3: Akses halaman gambar dan verifikasi judulnya
        WebElement imageLink = driver.findElement(By.xpath("//a[text()='Gambar']"));
        imageLink.click();

        Thread.sleep(2000); // Tunggu 2 detik untuk halaman memuat

        String expectedImageTitle = "Google Images";
        String actualImageTitle = driver.getTitle();
        assert actualImageTitle.contains(expectedImageTitle);

        // Test case 4: Cari gambar menggunakan kata kunci dan verifikasi hasilnya
        WebElement imageSearchField = driver.findElement(By.name("q"));
        imageSearchField.sendKeys("selenium");
        imageSearchField.sendKeys(Keys.RETURN);

        Thread.sleep(5000); // Tunggu 5 detik untuk halaman memuat

        WebElement imageResult = driver.findElement(By.xpath("//img[@alt='Selenium']"));
        assert imageResult.isDisplayed();

        // Test case 5: Akses halaman video dan verifikasi judulnya
        WebElement videoLink = driver.findElement(By.xpath("//a[text()='Video']"));
        videoLink.click();

        Thread.sleep(2000); // Tunggu 2 detik untuk halaman memuat

        String expectedVideoTitle = "Google Videos";
        String actualVideoTitle = driver.getTitle();
        assert actualVideoTitle.contains(expectedVideoTitle);

        // Tutup browser
        driver.quit();
    }
}