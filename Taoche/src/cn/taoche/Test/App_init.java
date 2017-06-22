package cn.taoche.Test;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class App_init {
	public AppiumDriver driver;

	@Test
	public void Test_Startup() {
		Assert.assertTrue(driver.getPageSource().contains("语言"));
		WebElement loginBtn = driver.findElement(By.name("登录"));
		Assert.assertTrue(loginBtn.isEnabled());
		WebElement loginReg = driver.findElement(By.name("注册"));
		Assert.assertTrue(loginReg.isDisplayed());
	}

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Exception {
		File app = new File("E:\\OtherSoftware\\weixin_1060.apk");
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
		Thread.sleep(10000);
	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		driver.quit();
	}

}
