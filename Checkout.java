package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://demo.avactis.com/4.7.9/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCheckout() throws Exception {
    driver.get(baseUrl + "/4.7.9/index.php");
    driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
    driver.findElement(By.id("input_text_empty_id_1529840949")).clear();
    driver.findElement(By.id("input_text_empty_id_1529840949")).sendKeys("øæå 1");
    driver.findElement(By.xpath("//input[@value='Continue Checkout']")).click();
    driver.findElement(By.name("shippingModuleAndMethod[method_code]")).click();
    driver.findElement(By.xpath("(//input[@value='Continue Checkout'])[2]")).click();
    driver.findElement(By.xpath("//input[@value='Place Order']")).click();
    driver.findElement(By.linkText("Sign Out")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
