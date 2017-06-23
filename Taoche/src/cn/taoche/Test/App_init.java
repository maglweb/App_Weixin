package cn.taoche.Test;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import cn.taoche.util.App_BaseCase;


public class App_init extends App_BaseCase{
    
	public static Logger logger = Logger.getLogger(App_init.class);
	
	@Test
	public void Test_Startup() {
		Assert.assertTrue(driver.getPageSource().contains("语言"));
		WebElement loginBtn = driver.findElement(By.name("登录"));
		Assert.assertTrue(loginBtn.isEnabled());
		WebElement loginReg = driver.findElement(By.name("注册"));
		Assert.assertTrue(loginReg.isDisplayed());
	}
}
