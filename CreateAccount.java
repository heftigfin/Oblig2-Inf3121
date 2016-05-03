package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
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
  public void testCreateAccount() throws Exception {
    driver.get(baseUrl + "/4.7.9/");
    driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    driver.findElement(By.name("customer_info[Customer][Email]")).clear();
    driver.findElement(By.name("customer_info[Customer][Email]")).sendKeys("helpplz@yes.com");
    driver.findElement(By.name("customer_info[Customer][Password]")).clear();
    driver.findElement(By.name("customer_info[Customer][Password]")).sendKeys("yes");
    driver.findElement(By.name("customer_info[Customer][RePassword]")).clear();
    driver.findElement(By.name("customer_info[Customer][RePassword]")).sendKeys("yes");
    driver.findElement(By.name("customer_info[Customer][FirstName]")).clear();
    driver.findElement(By.name("customer_info[Customer][FirstName]")).sendKeys("Marting");
    driver.findElement(By.name("customer_info[Customer][LastName]")).clear();
    driver.findElement(By.name("customer_info[Customer][LastName]")).sendKeys("Ødegaard");
    driver.findElement(By.name("customer_info[Customer][ZipCode]")).clear();
    driver.findElement(By.name("customer_info[Customer][ZipCode]")).sendKeys("1234");
    driver.findElement(By.name("customer_info[Customer][City]")).clear();
    driver.findElement(By.name("customer_info[Customer][City]")).sendKeys("Tønsberg");
    driver.findElement(By.name("customer_info[Customer][Streetline1]")).clear();
    driver.findElement(By.name("customer_info[Customer][Streetline1]")).sendKeys("Færøyene 1");
    driver.findElement(By.name("customer_info[Customer][Phone]")).clear();
    driver.findElement(By.name("customer_info[Customer][Phone]")).sendKeys("198274918274");
    driver.findElement(By.xpath("//input[@value='Register']")).click();
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
