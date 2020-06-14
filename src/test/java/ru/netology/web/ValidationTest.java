package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Selenide.*;


class ValidationTest {

    @Test
    void shouldNotPassedIfNameNotValid1() {
        open("http://localhost:9999");
        $(By.xpath("//*[@id=\"root\"]/div/form/div[1]/span/span/span[2]/input")).sendKeys("Василий___Пупкин");
        $("[data-test-id=phone] input").sendKeys("+71231234123");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        String actual = $(By.xpath("//*[@id=\"root\"]/div/form/div[1]/span/span/span[3]")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", actual.trim());
    }

    @Test
    void shouldNotPassedIfNameEmpty() {
        open("http://localhost:9999");
        $("[data-test-id=phone] input").sendKeys("+71231234123");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        String actual = $(By.xpath("//*[@id=\"root\"]/div/form/div[1]/span/span/span[3]")).getText();
        assertEquals("Поле обязательно для заполнения", actual.trim());
    }

    @Test
    void shouldNotPassedIfPhoneNotValid1() {
        open("http://localhost:9999");
        $(By.xpath("//*[@id=\"root\"]/div/form/div[1]/span/span/span[2]/input")).sendKeys("Василий Пупкин");
        $("[data-test-id=phone] input").sendKeys("71231234123");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        String actual = $(By.xpath("//*[@id=\"root\"]/div/form/div[2]/span/span/span[3]")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", actual.trim());
    }


    @Test
    void shouldNotPassedIfPhoneEmpty() {
        open("http://localhost:9999");
        $(By.xpath("//*[@id=\"root\"]/div/form/div[1]/span/span/span[2]/input")).sendKeys("Василий Пупкин");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        String actual = $(By.xpath("//*[@id=\"root\"]/div/form/div[2]/span/span/span[3]")).getText();
        assertEquals("Поле обязательно для заполнения", actual.trim());
    };

    @Test
    void shouldNotPassedIfAgreementNotChecked() {
        open("http://localhost:9999");
        $(By.xpath("//*[@id=\"root\"]/div/form/div[1]/span/span/span[2]/input")).sendKeys("Василий Пупкин");
        $("[data-test-id=phone] input").sendKeys("+71231234123");
        $("button.button").click();
        String actual = $("[data-test-id=agreement].input_invalid").getText();

        assertEquals("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй", actual.trim());
    }
}