package evaluation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MxPlayer {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//we have set the DesiredCapabilities below
		// DesiredCapabilities is the set of key-value pairs
		// which help to automate the framework
		DesiredCapabilities cap = new DesiredCapabilities();
		// here we have provided the platformName
		cap.setCapability("platformName", "Android");
		// below we provided our device platformVersion i.e. 14
		cap.setCapability("platformVersion", "14");
		// udid of devices is provided below
		cap.setCapability("udid", "VKA66DRSKJPBCEEE");
		// automation name as UiAutomator is mentioned below which is same for every one
		cap.setCapability("automationName", "UiAutomator2");
		// in appPackage we have to copy the code from the application
		cap.setCapability("appPackage", "com.mxtech.videoplayer.ad");
		// in AppActivity we have to go in appActivity in application and provide the appActivity
		cap.setCapability("appActivity", "com.mxtech.videoplayer.ad.ActivityWelcomeMX");

		// here we have iniated the URL
		// 127.0.01 is the loczal host ip address
		// 4723 is a default port for the appium
		URL url = new URL("http://127.0.01:4723");
		
		// here we have iniated Android driver and provided the parameters as a url and cap
		AndroidDriver driver = new AndroidDriver(url, cap);
		
		// after that we are ensuring the application is successfully opened using the System.out.println.
		System.out.println("MX PLAYER Application successfully opened...");
		
	

		
		
		// below we have used an click action on an application. 
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]")).click();
		System.out.println("Click action is successfully done");
		
		// below we have send the text using sendKeys 
		driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"com.mxtech.videoplayer.ad:id/search_src_text\"]")).sendKeys("videos");
		System.out.println("sendKeys action is successfully done");

		// click on cross or cancel button
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Done\"]")).click();
		
		
		// click on Login button
		WebElement ele1 = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.mxtech.videoplayer.ad:id/iv_user_avatar\"]"));		
		ele1.click();
		System.out.println("successfully clicked on Login button");
		
		
		WebElement ele2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Help\"]"));
		String text = ele2.getText();
		System.out.println(text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true)", text);
		
		
		
	}

}
