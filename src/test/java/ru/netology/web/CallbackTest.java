package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CallbackTest {
    SelenideElement form;

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        form = $("form.form");
    }

    @Test
    void shouldTestV1() {
        form.$("[data-test-id=name] input").sendKeys("Василий Пупкин");
        form.$("[data-test-id=phone] input").sendKeys("+71231234123");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        String actual = $("[data-test-id=order-success]").getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actual.trim());
    }
}
