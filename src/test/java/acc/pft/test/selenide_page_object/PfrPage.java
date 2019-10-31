package acc.pft.test.selenide_page_object;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PfrPage {
  public void searchFor(String text) {
    $(By.name("q")).val(text).pressEnter();
  }
}
