package org.selenide.examples.google.parallel.paralleltestclasses;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class GoogleTest2 {

  @Before
  public void setup(){
    Configuration.driverManagerEnabled = true;
    Configuration.startMaximized = true;
    Configuration.screenshots = true;
//    Configuration.remote = "http://localhost:4444/wd/hub";
    Configuration.baseUrl = "https://google.com";
    Configuration.holdBrowserOpen = false;
    Configuration.browser = "chrome";
  }
  /*
  Need to explicitly close browser in Selenide, since Selenide does not allow this
  Configuration.holdBrowserOpen - is only fro debugging when need to leave browser open after all tests executed
   */
  @After
  public void teardown(){
    close();
  }


  @Test
  public void search_selenide_in_google() {

    open("/ncr");
    $(By.name("q")).val("selenide").pressEnter();
    $$("#ires .g").shouldHave(sizeGreaterThan(1));
    $("#ires .g").shouldBe(Condition.visible).shouldHave(
        text("Selenide: concise UI tests in Java"),
        text("selenide.org"));
  }



}