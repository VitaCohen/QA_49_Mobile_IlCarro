package mobile.tests;

import config.AppiumConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @BeforeMethod
    public  void openLoginScreen(){
        new SplashScreen(driver).goToSerchScreen(10);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();;
        searchScreen.clickBtnLogin();
    }

    @Test
    public void  loginPositiveTest(){

    }

}
