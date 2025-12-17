package mobile.tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void  registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("cat" + i +"@mail.com")
                .password("123456Aa!")
                .firstName("Kate")
                .lastName("Cat")
                .build();
        new SplashScreen(driver).goToSerchScreen(10);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(
                searchScreen.validatePopUpMessageRegistrationSuccess("Registration success!"));
    }

    @Test
    public void  registrationNegativeTest_WoCheckBox(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("cat" + i +"@mail.com")
                .password("123456Aa!")
                .firstName("Kate")
                .lastName("Cat")
                .build();
        new SplashScreen(driver).goToSerchScreen(10);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickBtnYalla();
        Assert.assertTrue( new ErrorScreen(driver)
               .validateErrorMessage("All fields must be filled and agree terms"));
    }

    //WO @
    @Test
    public void  registrationNegativeTest_WrongEmail(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("cat" + i +"mail.com")
                .password("123456Aa!")
                .firstName("Kate")
                .lastName("Cat")
                .build();
        new SplashScreen(driver).goToSerchScreen(10);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue( new ErrorScreen(driver)
                .validateErrorMessage("{username=must be a well-formed email address}"));
    }


}
