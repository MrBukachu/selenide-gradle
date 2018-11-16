package org.selenide.examples.google.parallel.paralleltestclasses;

import static com.codeborne.selenide.Selenide.close;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractTest {

  @BeforeClass
  public static void setup(){
    Configuration.driverManagerEnabled = true;
    Configuration.startMaximized = true;
    Configuration.screenshots = true;
    Configuration.remote = "http://localhost:4444/wd/hub";
    Configuration.baseUrl = "https://google.com";
    Configuration.holdBrowserOpen = false;
    Configuration.browser = "firefox";
//    Configuration.browserCapabilities =
  }


  /*
Need to explicitly close browser in Selenide, since Selenide does not allow this
Configuration.holdBrowserOpen - is only fro debugging when need to leave browser open after all tests executed
 */
  @AfterClass
  public static void teardown(){
    close();
  }

}
