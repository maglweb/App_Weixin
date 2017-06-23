package cn.taoche.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class App_BaseCase {
	public AppiumDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Exception {
		File app = new File("E:\\Magl\\Software\\weixin_1060.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// 不需要按照的话去掉这个
		capabilities.setCapability(MobileCapabilityType.APP,
				app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Q505T");
		capabilities
				.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.tencent.mm");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,
				"com.tencent.mm.ui.LauncherUI");
		capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY,
				"com.tencent.mm.ui.LauncherUI");
		// 支持中文输入
		capabilities.setCapability("unicodeKeyboard", "True");
		// 重置输入法为系统默认
		capabilities.setCapability("restKeyboard", "True");
		// 安装时不对apk进行重签名，设置很有必要，否则有的apk在重签名后无法正常使用
		// capabilities.setCapability("noSign", "True");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		Thread.sleep(5000);
		System.out.println("启动APP");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("登录")));
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		driver.quit();
	}
}
