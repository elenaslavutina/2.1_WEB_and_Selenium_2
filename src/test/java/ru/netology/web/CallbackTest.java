package ru.netology.web;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Selenide.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallbackTest {


    @Test
    void shouldTestV1() {
        open("http://localhost:9999");
        $("form.form").$("[data-test-id=name]input").sendKeys("Василий Пупкин");
        $("[data-test-id=phone] input").sendKeys("+71231234123");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        String actual = $("[data-test-id=order-success]").getText();

        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actual.trim());
    }


}