package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


class ValidationTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();


    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

/*
    @Test
    void shouldNotPassedIfNameNotValid1() {
        open("http://localhost:9999");
        $("form.form").$("[data-test-id=name] input").sendKeys("Василий_Пупкин");
        $("form.form").$("[data-test-id=phone] input").sendKeys("+71231234123");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        String actual = $("[data-test-id=name]").$("[.input_invalid]").$(".input__sub").getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", actual.trim());
    }

    @Test
    void shouldNotPassedIfPhoneNotValid1() {
        open("http://localhost:9999");
        $("form.form").$("[data-test-id=name] input").sendKeys("Василий Пупкин");
        $("form.form").$("[data-test-id=phone] input").sendKeys("71231234123");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        String actual = $("[data-test-id=phone]").$("[.input_invalid]").$(".input__sub").getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", actual.trim());
    }

*/
}