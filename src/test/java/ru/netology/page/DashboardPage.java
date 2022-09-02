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


    public void verifyIsDashboardPage(){
        heading.shouldBe(visible);
    }

    public int getCardBalance(String id) {
        val text = cards.find(attribute("data-test-id", DataHelper.getCard(id).getId())).text();
        return extractBalance(text);


    }

    private int extractBalance(String text) {
//        val start = text.indexOf(balanceStart);
//        val finish = text.indexOf(balanceFinish);
//        val value = text.substring(start + balanceStart.length(), finish);
//        или так
        val start = text.split(":");
        val value = start[1].substring(0, start[1].indexOf("р.")).trim();
        return Integer.parseInt(value);
    }

    public TransferPage choosingACardToTopUpYourBalance(String id) {
        $("[data-test-id='" + DataHelper.getCard(id).getId() + "'] [data-test-id='action-deposit']").click();
        return new TransferPage();
    }




}
