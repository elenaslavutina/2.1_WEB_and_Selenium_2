package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationTest {
    SelenideElement form;

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        form = $("form.form");
    }

    @Test
    void shouldNotPassedIfNameNotValid1() {
        form.$("[data-test-id=name] input").sendKeys("Василий_Пупкин");
        form.$("[data-test-id=phone] input").sendKeys("+71231234123");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        String actual = $("[data-test-id=name].input_invalid .input__sub").getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", actual.trim());
    }

    @Test
    void shouldNotPassedIfPhoneNotValid1() {
        form.$("[data-test-id=name] input").sendKeys("Василий Пупкин");
        form.$("[data-test-id=phone] input").sendKeys("71231234123");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        String actual = $("[data-test-id=phone].input_invalid .input__sub").getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", actual.trim());
    }
}
