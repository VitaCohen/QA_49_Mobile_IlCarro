package mobile.tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
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
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("eva_b915@mail.com")
                .password("123456Ee!")
                .build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYalla();
        Assert.assertTrue(new SearchScreen(driver)
                .validatePopUpMessageSuccess("Login success!"));
    }

}
