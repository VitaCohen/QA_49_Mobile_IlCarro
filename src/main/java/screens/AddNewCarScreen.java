package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import  static config.AppiumConfig.*;

public class AddNewCarScreen extends BaseScreen{


    public AddNewCarScreen(AppiumDriver driver) {
        super(driver);
    }

    public void goToSearchScreen(int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.presenceOfElementLocated(By
                            .id("com.telran.ilcarro:id/findTitle")));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("element not found");
        }
    }


}
