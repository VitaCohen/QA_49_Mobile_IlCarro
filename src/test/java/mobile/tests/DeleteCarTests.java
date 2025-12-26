package mobile.tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MyCarsScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.List;

public class DeleteCarTests extends AppiumConfig {

    @BeforeMethod
    public void login(){
        new SplashScreen(driver).goToSerchScreen(10);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("eva_b915@mail.com")
                .password("123456Ee!")
                .build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYalla();
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
    }

@Test
    public void deleteCarPositiveTest(){
    MyCarsScreen myCarsScreen = new MyCarsScreen(driver);
    List<String> listBeforeDeleteCar = myCarsScreen.readCarList();

    myCarsScreen.deleteCar();
    myCarsScreen.clickBtnYes();
    List<String> listAfterDeleteCar = myCarsScreen.readCarList();
    Assert.assertNotEquals(listBeforeDeleteCar, listAfterDeleteCar);

}


}
