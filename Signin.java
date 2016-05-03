package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignInChangePasswordLogOut {
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
  public void testSignInChangePasswordLogOut() throws Exception {
    driver.get(baseUrl + "/4.7.9/index.php");
    driver.findElement(By.linkText("Sign In")).click();
    driver.findElement(By.id("account_sign_in_form_email_id")).click();
    driver.findElement(By.id("account_sign_in_form_email_id")).clear();
    driver.findElement(By.id("account_sign_in_form_email_id")).sendKeys("helpplz@yes.com");
    driver.findElement(By.id("account_sign_in_form_passwd_id")).clear();
    driver.findElement(By.id("account_sign_in_form_passwd_id")).sendKeys("yes");
    driver.findElement(By.xpath("//input[@value='Sign In']")).click();
    driver.findElement(By.linkText("Change Password")).click();
    driver.findElement(By.id("account_change_password_form_current_password_id")).clear();
    driver.findElement(By.id("account_change_password_form_current_password_id")).sendKeys("yes");
    driver.findElement(By.id("account_change_password_form_new_password_id")).clear();
    driver.findElement(By.id("account_change_password_form_new_password_id")).sendKeys("yes");
    driver.findElement(By.id("account_change_password_form_retype_password_id")).clear();
    driver.findElement(By.id("account_change_password_form_retype_password_id")).sendKeys("yes");
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
