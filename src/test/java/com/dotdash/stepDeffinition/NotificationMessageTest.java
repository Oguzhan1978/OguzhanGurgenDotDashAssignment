package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class NotificationMessageTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void notificationMessage() throws InterruptedException {

        ArrayList<String> answers = new ArrayList<String>();

        answers.add("Action unsuccesful, please try again");
        answers.add("Action successful");

        WebElement clickHereButton = Driver.getDriver().findElement(By.xpath("//a[@href='/notification_message']"));
        clickHereButton.click();

        clickHereButton = Driver.getDriver().findElement(By.xpath("//a[@href='/notification_message']"));
        clickHereButton.click();

         clickHereButton = Driver.getDriver().findElement(By.xpath("//a[@href='/notification_message']"));
         clickHereButton.click();


         WebElement messageBox = Driver.getDriver().findElement(By.id("flash"));

         String message = messageBox.getText();
        System.out.println(message);


        Assert.assertTrue(message.contains(answers.get(0).toString()) || message.contains(answers.get(1).toString()));


    }
}
