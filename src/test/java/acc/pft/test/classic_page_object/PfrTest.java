package acc.pft.test.classic_page_object;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class PfrTest {
  WebDriver driver;

  @Before
  public void setUp() {
    String currentBrowser = System.getProperty("selenide.browser", "firefox");
    if ("chrome".equals(currentBrowser)) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if ("firefox".equals(currentBrowser)) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else if ("safari".equals(currentBrowser)) {
      driver = new SafariDriver();
    } else if ("edge".equals(currentBrowser)) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    } else if ("ie".equals(currentBrowser)) {
      WebDriverManager.iedriver().setup();
      driver = new InternetExplorerDriver();
    }
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void userCanSearch() {
    driver.get("https://www.google.com/ncr");
    PfrPage page = PageFactory.initElements(driver, PfrPage.class);
    SearchResultsPage results = page.searchFor("Selenide");
    assertThat(results.getResults().get(0).getText(), containsString("Selenide: concise UI tests in Java"));
  }
}
