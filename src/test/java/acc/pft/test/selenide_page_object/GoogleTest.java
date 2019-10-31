package acc.pft.test.selenide_page_object;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
  @Test
  public void userCanSearch() {
    open("https://google.com/ncr");
    new PfrPage().searchFor("selenide");

    SearchResultsPage results = new SearchResultsPage();
    results.getResults().shouldHave(sizeGreaterThan(1));
    results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
  }
}
