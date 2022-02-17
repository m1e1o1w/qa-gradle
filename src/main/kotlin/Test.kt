package src.main

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit

fun chrome(): WebDriver {
    WebDriverManager.chromedriver().setup()
    return ChromeDriver()
}

fun main() {
    val options = ChromeOptions()
    val driver = chrome()
    driver.get("https://google.com")

    driver.getTitle(); // => "Google"

    driver.manage().timeouts().implicitlyWait(500, TimeUnit.MICROSECONDS)
    val acceptButton = driver.findElements(By.id("L2AGLb"))

    acceptButton[0].click()
    val searchBox = driver.findElement(By.name("q"));
    val searchButton = driver.findElement(By.name("btnK"));

    searchBox.sendKeys("Selenium");
    searchButton.submit()

    driver.quit()
}