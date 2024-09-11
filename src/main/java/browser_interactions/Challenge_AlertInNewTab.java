package browser_interactions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import setup.Main;

public class Challenge_AlertInNewTab extends Main {

  public static void main(String[] args) {
    driver.get("https://www.selenium.dev/selenium/web/alerts.html");

    driver.findElement(By.id("open-window-with-onload-alert")).click();

    var tabs = driver.getWindowHandles();
    var currentTab = driver.getWindowHandle();

    for (String tab : tabs) {
      driver.switchTo().window(tab);
      if (!currentTab.equals(driver.getWindowHandle())) {
        break;
      }
    }

    Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
    alert.accept();

    driver.quit();
  }
}