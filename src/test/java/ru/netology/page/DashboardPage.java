package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final SelenideElement heading = $("[data-test-id=dashboard]");
    private static ElementsCollection cards = $$(".list__item div");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";
    private static ElementsCollection ids = $$("li div");

    public void verifyIsDashboardPage(){
        heading.shouldBe(visible);
    }

    public static int getCardBalance(String id) {
        String text = null;
        if (id == "1") {
            text = cards.first().text();
        }
        if (id == "2") {
            text = cards.last().text();
        }
        return extractBalance(text);
    }

    private static int extractBalance(String text) {
//        val start = text.indexOf(balanceStart);
//        val finish = text.indexOf(balanceFinish);
//        val value = text.substring(start + balanceStart.length(), finish);
//        или так
        val start = text.split(":");
        val value = start[1].substring(0, start[1].indexOf("р.")).trim();
        return Integer.parseInt(value);
    }


    public DashboardPage transfer(String amount, String number, String id) {
        String numberId = null;
        if (id == "1") {
            numberId = ids.first().getAttribute("data-test-id");
        }
        if (id == "2") {
            numberId = ids.last().getAttribute("data-test-id");
        }
        $("[data-test-id='" + numberId + "'] [data-test-id='action-deposit']").click();
        $("[data-test-id='amount'] input").setValue(amount);
        $("[data-test-id='from'] input").setValue(number);
        $("[data-test-id='action-transfer']").click();
        return new DashboardPage();
    }

    //    проверяем баланс
    public void chekingBalance(String id, String balance) {
        Assertions.assertEquals(getCardBalance(id),balance);
    }

}
