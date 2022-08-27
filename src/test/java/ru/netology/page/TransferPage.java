package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {

    public DashboardPage transfer(String amount, String numberCard) {
        $("[data-test-id='amount'] input").setValue(amount);
        $("[data-test-id='from'] input").setValue(numberCard);
        $("[data-test-id='action-transfer']").click();
        return new DashboardPage();
    }
}
