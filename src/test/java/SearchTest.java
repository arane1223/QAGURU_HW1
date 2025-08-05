import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void captchaTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("html").shouldHave(text("Об этой странице"));
    }

    @Test //это я сам чуть-чуть попрактиковался
    void successfulSearchTestYa () {
        open ("https://ya.ru/");
        $("[name=text]").setValue("art republic").pressEnter();
        $("html").shouldHave(text("Интерьерная фотостудия в Екатерринбурге"));
    }
}
